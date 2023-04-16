package com.PlebicomTechnicalTest;

import com.PlebicomTechnicalTest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.PlebicomTechnicalTest.repository.BookRepository;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)

public class PlebicomTechnicalTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PlebicomTechnicalTestApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Book book=new Book();
		book.setTitle("Par-delà le bien et le mal");
		book.setAuthor("Friedrich Nietzsche");
		book.setReleaseDate("1886");
		bookRepository.save(book);

		Book book2=new Book();
		book2.setTitle("L'Étranger");
		book2.setAuthor("Albert Camus");
		book2.setReleaseDate("1942");
		bookRepository.save(book2);

		Book book3=new Book();
		book3.setTitle("Don Quichotte");
		book3.setAuthor("Miguel de Cervantes");
		book3.setReleaseDate("1605-1615");
		bookRepository.save(book3);

	}

}
