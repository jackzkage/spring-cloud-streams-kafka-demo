package com.anbangke.stream.kafka.web;

import com.anbangke.stream.kafka.model.Greetings;
import com.anbangke.stream.kafka.service.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        Greetings greetings = Greetings.builder()
            .message(message)
            .timestamp(System.currentTimeMillis())
            .build();

        greetingsService.sendGreeting(greetings);
    }
}
