package com.example.programmingtest3.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "cs544Queue")
    public void receiver(String message) {
        System.out.println("Received Message :"+message);
    }
}
