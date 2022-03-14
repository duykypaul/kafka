package com.example.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaApplication implements CommandLineRunner {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    public static Integer test1 = 0;
    public static Integer test2 = 0;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 2000; i++) {
            kafkaTemplate.send("testf", String.valueOf(i));
//            Thread.sleep(1000);
        }
    }

//    @KafkaListener(topics = "test", groupId = "group-id", topicPartitions = {
//            @TopicPartition(
//                    topic = "test",
//                    partitions = {"0"}
//            )})
//    public void listenTest(String message) {
//        System.out.println("Received Message in group - test1: " + message);
////        System.out.println("test1: " + test1);
//    }
//
//    @KafkaListener(topics = "test", groupId = "group-id", topicPartitions = {
//            @TopicPartition(
//                    topic = "test",
//                    partitions = {"0"}
//            )})
//    public void listenTest2(String message) {
//        System.out.println("=================================== - test2: " + message);
////        System.out.println("test2: " + test2);
//    }

}
