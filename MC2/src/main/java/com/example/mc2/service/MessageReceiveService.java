package com.example.mc2.service;

import com.example.mc2.dto.MessageDTO;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiveService{
    private final KafkaTemplate<Long, MessageDTO> kafkaMessageTemplate;
//    private MessageDTO messageDTO;

    public MessageReceiveService(KafkaTemplate<Long, MessageDTO> kafkaMessageTemplate) {
        this.kafkaMessageTemplate = kafkaMessageTemplate;
    }
//
//    public void receiveFromMc1(MessageDTO messageDTO) {
//        kafkaTimeMessageTemplate.send("Topic", messageDTO);
//    }

    public ApplicationRunner runner(MessageDTO messageDTO) {
        return args -> {
            kafkaMessageTemplate.send("topic1", messageDTO);
            System.out.println(messageDTO);
        };
    }
}
