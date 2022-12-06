package com.example.mc2.config;

import com.example.mc2.WSClientMessageHandler;
import com.example.mc2.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MC2Config {
//    @Value("${ws.server}")
//    public String wsServer;
//    @Value("${kafka.server}")
//    public String kafkaServer;
//    @Value("${kafka.producer.id}")
//    private String kafkaProducerId;
//
//    @Bean
//    public WebSocketStompClient webSocketStompClient(WebSocketClient webSocketClient) {
//        WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
//        webSocketStompClient.setMessageConverter(new StringMessageConverter());
//        return webSocketStompClient;
//    }
//
//    @Bean
//    public WebSocketClient webSocketClient() {
//        List<Transport> list = List.of(new Transport[]{new WebSocketTransport(new StandardWebSocketClient()), new RestTemplateXhrTransport()});
//        return new SockJsClient(list);
//    }
//
//    @Bean
//    public StompSessionHandler stompSessionHandler() {
//        return new WSClientMessageHandler(this.getObjectMapper());
//    }
//
//    @Bean
//    public ObjectMapper getObjectMapper() {
//        return JsonMapper.builder()
//                .addModule(new JavaTimeModule())
//                .build();
//    }
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerId);
//        return props;
//    }
//
//    @Bean
//    public ProducerFactory<Long, MessageDTO> producerMessageFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<Long, MessageDTO> kafkaTemplate() {
//        KafkaTemplate<Long, MessageDTO> template = new KafkaTemplate<>(producerMessageFactory());
//        template.setMessageConverter(new StringJsonMessageConverter());
//        return template;
//    }
}
