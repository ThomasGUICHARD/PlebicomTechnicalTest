package com.PlebicomTechnicalTest.controller;

import com.PlebicomTechnicalTest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.PlebicomTechnicalTest.repository.BookRepository;

import java.util.List;


@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value="/getAllBooks", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
