package com.PlebicomTechnicalTest.Service;

import com.PlebicomTechnicalTest.model.Book;
import com.PlebicomTechnicalTest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookGetterServicesImpl implements BookGetterServices{

    @Override
    public List<Book> getAllBooks(BookRepository bookRepository) {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAlphabeticalOrder(BookRepository bookRepository) {
        return bookRepository.findAll().stream().sorted((o1, o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByPage(BookRepository bookRepository,int pageNumber) {

        return bookRepository.findAll().stream().skip(pageNumber*5).limit(5).collect(Collectors.toList());
    }
}
