package com.example.demo.kafka;

import com.example.demo.payload.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    private static Logger logger= LogManager.getLogger(JsonConsumer.class);


    @KafkaListener(topics = "JavaTutorial",groupId = "mygroup")
    public void consume(User user){
        logger.info("JsonMessage received:{}",user.toString());
    }
}
