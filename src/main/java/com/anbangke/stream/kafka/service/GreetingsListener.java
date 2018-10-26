package com.anbangke.stream.kafka.service;

import com.anbangke.stream.kafka.model.Greetings;
import com.anbangke.stream.kafka.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener {

    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings message, @Header("contentType") String header) {
        log.info("Received greetings: {},{}", message, header);
    }

//    @StreamListener(Processor.INPUT)
//    public void handleGreetingsManual(Message<?> message) {
//        log.info("Received greetings: {},{}", message.getPayload(), message.getHeaders());
//
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
//    }

//
//    @ServiceActivator(inputChannel = "test-topic")
//    public void handleGreetingsDynamic(@Payload Greetings message, @Header("contentType") String header) {
//        log.info("test-topic: Received greetings: {},{}", message, header);
//    }


//    @ServiceActivator(inputChannel = "test-topic")
//    public void handleManual(Message<?> message) {
//        log.info("test-topic: Received greetings: {},{}", message.getPayload(), message.getHeaders());
//
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
//    }


}
