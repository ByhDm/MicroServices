package com.example.mc2;

import com.example.mc2.dto.MessageDTO;
import com.example.mc2.service.MessageReceiveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.Objects;

public class WSClientMessageHandler extends StompSessionHandlerAdapter {
//    @Autowired
//    private MessageReceiveService messageReceiveService;
//
//    @Value("${ws.topic}")
//    public String wsTopic;
//
//    private final ObjectMapper objectMapper;
//
//    public WSClientMessageHandler(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public void handleFrame(StompHeaders headers, Object payload) {
//        MessageReceiveService receiveService = this.messageReceiveService;
//        MessageDTO message;
//        try {
//            message = this.objectMapper.readValue(Objects.requireNonNull(payload).toString(), MessageDTO.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        receiveService.receiveFromMc1(message);
//    }
//
//    @Override
//    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//        String topic = this.wsTopic;
//        session.subscribe(topic, this);
//    }
}
