package com.example;

import com.example.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
public class KafkaConsumerExampleTest {

    @Container
    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));


    @DynamicPropertySource
    public static void initKafkaProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void testConsumeEvents() {
        log.info("testConsumeEvents() execution started: ");
        Customer test = new Customer(123, "test", "test@gmail.com", "77777777");
        kafkaTemplate.send("demo-7", test);
        log.info("testConsumeEvents() execution ended: ");

        await().pollInterval(Duration.ofSeconds(3)).atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {

        });
    }
}
