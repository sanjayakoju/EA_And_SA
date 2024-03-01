package com.example.programmingtest3.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value(value = "cs544Queue")
    private String queueName;

    public void send(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}
