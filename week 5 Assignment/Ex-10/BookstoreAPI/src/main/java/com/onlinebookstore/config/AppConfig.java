package com.onlinebookstore.config;

import com.bookstoreapi.mapper.BookMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookMapper bookMapper() {
        return BookMapper.INSTANCE;
    }
}
