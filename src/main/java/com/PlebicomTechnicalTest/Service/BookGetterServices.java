package com.PlebicomTechnicalTest.Service;

import com.PlebicomTechnicalTest.model.Book;
import com.PlebicomTechnicalTest.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Service
public interface BookGetterServices {
    List<Book> getAllBooks(BookRepository bookRepository);
    List<Book> getBooksByAlphabeticalOrder(BookRepository bookRepository);
    List<Book> getBooksByPage(BookRepository bookRepository, int pageNumber);
}
