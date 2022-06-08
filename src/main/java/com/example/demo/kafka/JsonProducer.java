package com.example.demo.kafka;

import com.example.demo.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user){
        Message<User>message= MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"JavaTutorial")
                .build();

        kafkaTemplate.send(message);
    }
}
