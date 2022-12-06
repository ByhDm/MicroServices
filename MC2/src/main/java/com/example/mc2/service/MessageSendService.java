package com.example.mc2.service;

import com.example.mc2.dto.MessageDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService{
//    private final KafkaTemplate<Long, MessageDTO> kafkaTemplate;
//
//    public MessageSendService(KafkaTemplate<Long, MessageDTO> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendToMc3(MessageDTO messageDTO) {
//        messageDTO.setMc2_timestamp(System.currentTimeMillis());
//        kafkaTemplate.send("Topic", messageDTO);
//    }
}
