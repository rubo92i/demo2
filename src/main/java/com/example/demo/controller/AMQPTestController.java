package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amqp")
public class AMQPTestController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping
    public ResponseEntity test(@RequestParam String message){
        rabbitTemplate.convertAndSend("que01",message);
        return ResponseEntity.ok().build();
    }
}
