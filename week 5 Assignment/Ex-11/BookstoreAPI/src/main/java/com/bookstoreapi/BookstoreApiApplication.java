package com.bookstoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bookstoreapi", "com.onlinebookstore.config"})
public class BookstoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApiApplication.class, args);
    }
}
