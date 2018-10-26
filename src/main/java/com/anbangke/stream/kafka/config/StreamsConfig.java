package com.anbangke.stream.kafka.config;

import com.anbangke.stream.kafka.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
