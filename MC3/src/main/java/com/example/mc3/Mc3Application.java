package com.example.mc3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableKafka
@ComponentScan(basePackages = {
        "com.example.mc3.config",
        "com.example.mc3.service"
})
@PropertySource({
        "classpath:application.properties"
})
public class Mc3Application {

    public static void main(String[] args) {
        SpringApplication.run(Mc3Application.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

//    @KafkaListener(id = "myId", topics = "topic1")
//    public void listen(String in) {
//        System.out.println(in);
//    }

//    @Bean
//    public JsonDeserializer jsonDeserializer() {
//        return new JsonDeserializer() {
//            @Override
//            public Object deserialize(JsonParser p, DeserializationContext context) {
//                return null;
//            }
//        };
//    }
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        return JsonMapper.builder()
//                .addModule(new JavaTimeModule())
//                .build();
//    }

}
