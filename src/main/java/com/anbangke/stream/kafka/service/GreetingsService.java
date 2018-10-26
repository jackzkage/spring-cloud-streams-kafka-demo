package com.anbangke.stream.kafka.service;

import com.anbangke.stream.kafka.model.Greetings;
import com.anbangke.stream.kafka.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class GreetingsService {

    @Autowired
    private GreetingsStreams source;

    @Autowired
    private BinderAwareChannelResolver resolver;


    public void sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}", greetings);

        MessageChannel messageChannel = source.outboundGreetings();

        //不指定topic，为output 的destination
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());


//        //指定topic，如果指定了spring.cloud.stream.dynamicDestinations: ["XXXX"],就只能取该数组里的值，不设置的话就可以自己定义topic
//        messageChannel = resolver.resolveDestination("test-topic");
//        messageChannel.send(MessageBuilder
//                .withPayload(greetings)
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build());
    }


}
