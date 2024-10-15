package com.example.demo;

import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
@SchemaMapping("LogMessage")
public class LogMessageController {

    private final LogMessageService logMessageService;

    @QueryMapping
    public Optional<LogMessage> logMessage(@Argument("id") String id) {
        return logMessageService.getMessage(id);
    }

    @SubscriptionMapping
    public Flux<LogMessage> logMessages() {
        return logMessageService.getMessagesFlux();
    }
}
