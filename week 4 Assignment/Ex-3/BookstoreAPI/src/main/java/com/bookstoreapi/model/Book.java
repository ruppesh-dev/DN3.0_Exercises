package com.bookstoreapi.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor  // Generates a no-argument constructor
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}

