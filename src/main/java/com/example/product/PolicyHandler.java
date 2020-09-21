package com.example.product;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @StreamListener(Processor.INPUT)
    public void onEventByString(@Payload String productChanged){
        System.out.println(productChanged);
    }

    @StreamListener(Processor.INPUT)
    public void onEventByObject(@Payload ProductChanged productChanged){
        if("ProductChanged".equals(productChanged.getEventType())) {
            System.out.println("Event Object eventType" +productChanged.getEventType());
            System.out.println("Event Object getProductName" +productChanged.getProductName());
        }
    }
}
