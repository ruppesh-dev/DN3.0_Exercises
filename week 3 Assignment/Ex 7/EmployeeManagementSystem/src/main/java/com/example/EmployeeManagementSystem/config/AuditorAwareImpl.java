package com.example.EmployeeManagementSystem.config;



import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Replace this with your logic to get the current user
        return Optional.of("system"); // Placeholder for example
    }
}

