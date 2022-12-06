package com.example.mc3.service;

import com.example.mc3.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageSendService {
//    private final RestTemplate restTemplate;
//    private final ObjectMapper objectMapper;
//    private final String mc1Url;
//
//    public MessageSendService(RestTemplate restTemplate, ObjectMapper objectMapper, @Value("${mc1.url}") String mc1Url) {
//        this.restTemplate = restTemplate;
//        this.objectMapper = objectMapper;
//        this.mc1Url = mc1Url;
//    }
//
//    public ResponseEntity sendToMc1(MessageDTO messageDTO) {
//        HttpHeaders var3 = new HttpHeaders();
//        var3.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity request;
//        try {
//            request = new HttpEntity(this.objectMapper.writeValueAsString(messageDTO), var3);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        ResponseEntity<String> responseEntity = this.restTemplate.exchange(this.mc1Url, HttpMethod.POST, request, String.class);
//        return responseEntity;
//    }
}
