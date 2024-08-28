package com.onlinebookstore.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter bookCreationCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.bookCreationCounter = meterRegistry.counter("books_created_total");
    }

    public void incrementBookCreationCounter() {
        this.bookCreationCounter.increment();
    }
}


