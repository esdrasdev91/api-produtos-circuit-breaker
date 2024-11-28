package com.esdrasdev.api_produtos_circuit_breaker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.core.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfig {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerConfig.class);

    @Bean
    public RegistryEventConsumer<CircuitBreaker> circuitBreakerLog(CircuitBreakerRegistry circuitBreakerRegistry) {
        return new RegistryEventConsumer<CircuitBreaker>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                // Acessando o CircuitBreaker adicionado
                CircuitBreaker addedCircuitBreaker = entryAddedEvent.getAddedEntry();

                logger.info("CircuitBreaker added: {}", addedCircuitBreaker.getClass().getName());
                logger.info("Initial state of CircuitBreaker: {}", addedCircuitBreaker.getClass().getSimpleName());
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemovedEvent) {
            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
            }
        };
    }
}
