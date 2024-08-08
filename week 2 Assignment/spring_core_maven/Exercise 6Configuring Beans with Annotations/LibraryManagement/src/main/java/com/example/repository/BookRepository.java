package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void getBook() {
        System.out.println("book fetched successfully.");
    }
}

