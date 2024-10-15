package com.example.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class LogMessageService {

    private Long id = 0l;

    private final Flux<LogMessage> messagesFlux = Flux.interval(Duration.ofSeconds(1))
            .map(tick -> new LogMessage(
                    (++id).toString(),
                    "INFO",
                    "Message " + id,
                    Instant.now().toString()));

    public Flux<LogMessage> getMessagesFlux() {
        return messagesFlux;
    }

    public Optional<LogMessage> getMessage(String id) {
        var logMessage = messagesFlux
                .filter(message -> message.getId().equals(id))
                .blockFirst();

        return Optional.ofNullable(logMessage);
    }

}
