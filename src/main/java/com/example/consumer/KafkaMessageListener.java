package com.example.consumer;

import com.example.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "demo-6", groupId = "consumer-2")
    public void consume1(String message) {
        log.info("Message consumed by consumer1: " + message);
    }

    @KafkaListener(topics = "demo-6", groupId = "consumer-2")
    public void consume2(String message) {
        log.info("Message consumed by consumer2: " + message);
    }

    @KafkaListener(topics = "demo-6", groupId = "consumer-2")
    public void consume3(String message) {
        log.info("Message consumed by consumer3: " + message);
    }

    @KafkaListener(topics = "demo-6", groupId = "consumer-2")
    public void consume4(String message) {
        log.info("Message consumed by consumer4: " + message);
    }

    @KafkaListener(topics = "demo-6", groupId = "consumer-2")
    public void consume5(String message) {
        log.info("Message consumed by consumer5: " + message);
    }

    @KafkaListener(topics = "demo-7", groupId = "consumer-3")
    public void consumeEvent(Customer message) {
        log.info("Message consumed by consumeEvent: " + message);
    }
}
