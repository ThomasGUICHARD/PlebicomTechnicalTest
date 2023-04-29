package com.PlebicomTechnicalTest.controller;

import com.PlebicomTechnicalTest.Service.BookGetterServices;
import com.PlebicomTechnicalTest.Service.BookGetterServicesImpl;
import com.PlebicomTechnicalTest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.PlebicomTechnicalTest.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookGetterServices bookGetterServices= new BookGetterServicesImpl();

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value="/getAllBooks", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getAllBooks(@RequestParam Boolean alpha){
        List<Book> bookList;
        if (alpha){
            bookList=bookGetterServices.getBooksByAlphabeticalOrder(bookRepository);
        }else{
            bookList=bookGetterServices.getAllBooks(bookRepository);
        }
        bookList.forEach(System.out::println);
        return bookList;
    }

    @RequestMapping(value="/getPageOfBooks", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getPageOfBooks(@RequestParam int page){
        List<Book> bookList=bookGetterServices.getBooksByPage(bookRepository,page);
        bookList.forEach(System.out::println);
        return bookList;

    }
}
