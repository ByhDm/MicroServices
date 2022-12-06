package com.example.mc1.service;

import com.example.mc1.dto.MessageDTO;
import com.example.mc1.entity.MessageEntity;
import com.example.mc1.mapper.MessageMapper;
import com.example.mc1.repository.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
public class MessageService {
    @Value("${ws.topic}")
    public String topic;
    @Value("${timer.period}")
    private long period;

    private ScheduledFuture<?> scheduleFuture;
    private final MessageRepository messageRepository;
    private final MessageMapper mapper;
    private final MessageSendingOperations<String> sendOperation;
    private final ObjectMapper objectMapper;
    private final TaskScheduler taskScheduler;

    public MessageService(MessageRepository messageRepository
            , MessageMapper mapper
            , MessageSendingOperations<String> sendOperation
            , ObjectMapper objectMapper
            , TaskScheduler taskScheduler) {
        this.messageRepository = messageRepository;
        this.mapper = mapper;
        this.sendOperation = sendOperation;
        this.objectMapper = objectMapper;
        this.taskScheduler = taskScheduler;
    }

    public String getTopic() {
        return this.topic;
    }

    public long getPeriod() {
        return this.period;
    }

    public ScheduledFuture<?> getScheduleFuture() {
        return this.scheduleFuture;
    }

    public void setScheduleFuture(ScheduledFuture<?> scheduleFuture) {
        this.scheduleFuture = scheduleFuture;
    }

    public boolean startTask() {
        if (this.getScheduleFuture() == null) {
            this.setScheduleFuture(this.taskScheduler.scheduleAtFixedRate(this.task(), this.getPeriod()));
            return true;
        } else {
            return false;
        }
    }

    public void receiveFromMc3(MessageDTO messageDTO) {
        messageDTO.setEnd_timestamp(System.currentTimeMillis());
        MessageEntity entity = this.mapper.messageDTOToMessageEntity(messageDTO);
        this.messageRepository.save(entity);
    }

    public boolean stopTask() {
        if (this.getScheduleFuture() != null) {
            ScheduledFuture<?> scheduleFuture = this.getScheduleFuture();
            scheduleFuture.cancel(false);
            return true;
        } else {
            return false;
        }
    }

    public Runnable task() {
        return () -> {
            MessageEntity lastRecord = MessageService.this.messageRepository.findFirstByOrderByIdDesc().orElse(new MessageEntity(0L, 0L, 0L, 0L, 0L, 0L));
            lastRecord.setId(lastRecord.getId() + 1L);
            long id = lastRecord.getId();
            lastRecord.setSession_id(lastRecord.getSession_id() + 1L);
            MessageDTO msg = new MessageDTO(id, lastRecord.getSession_id(), System.currentTimeMillis(), 0L, 0L, 0L);
            try {
                MessageService.this.sendOperation.convertAndSend(MessageService.this.getTopic(), MessageService.this.objectMapper.writeValueAsString(msg));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
