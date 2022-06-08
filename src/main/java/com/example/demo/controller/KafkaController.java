package com.example.demo.controller;

import com.example.demo.kafka.JsonProducer;
import com.example.demo.payload.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    JsonProducer jsonProducer;

    @RequestMapping(method = RequestMethod.POST,value = "/publisher")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Paylod Published successfully");
    }
}
