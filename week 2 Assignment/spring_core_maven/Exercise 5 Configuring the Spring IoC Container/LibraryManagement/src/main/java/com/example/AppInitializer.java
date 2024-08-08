
	package com.example;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import com.example.service.BookService;

	public class AppInitializer {

	    public static void main(String[] args) {
	        // Load Spring context from applicationContext.xml
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	        // Retrieve the BookService bean
	        BookService bookService = (BookService) context.getBean("bookService");

	        // Use the BookService bean (e.g., call its methods)
	        System.out.println("BookService bean retrieved successfully!");
	        bookService.fetchBook();
	        // Perform further operations with bookService if needed
	    }
	}



