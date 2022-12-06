package com.example.mc3.service;


import com.example.mc3.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageReceiveService {
    private final KafkaTemplate<Long, MessageDTO> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public MessageReceiveService(KafkaTemplate<Long, MessageDTO> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(id = "consumerServer", topics = "topic1")
    public void listen(MessageDTO messageDTO) {
        messageDTO.setMc3_timestamp(System.currentTimeMillis());
        System.out.println(messageDTO);
    }
//
////    @KafkaListener(
////            topics = {"${spring.kafka.topic}"},
////            groupId = "${kafka.producer.id}"
////    )
////    public void receiveFromMc2(MessageDTO messageDTO) {
////        messageDTO.setMc3_timestamp(System.currentTimeMillis());
////        kafkaTemplate.send("Topic", messageDTO);
////    }
//
//    @KafkaListener(id = "${kafka.consumer.id}", topics = "Topic", containerFactory = "singleFactory")
//    public void consume(MessageDTO messageDTO) {
//        messageDTO.setMc3_timestamp(System.currentTimeMillis());
//        log.info("=> consumed {}", writeValueAsString(messageDTO));
//    }
//
//
//    private String writeValueAsString(MessageDTO messageDTO) {
//        try {
//            return objectMapper.writeValueAsString(messageDTO);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Writing value to JSON failed: " + messageDTO.toString());
//        }
//    }
}
