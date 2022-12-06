package com.example.mc2;

import com.example.mc2.dto.MessageDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableKafka
@PropertySource({
        "classpath:application.properties"
})
public class Mc2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mc2Application.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<Long, MessageDTO> template) {
//        return args -> {
//            template.send("topic1", messageDTO);
//        };
//    }
}
