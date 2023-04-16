package com.PlebicomTechnicalTest.repository;

import com.PlebicomTechnicalTest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
