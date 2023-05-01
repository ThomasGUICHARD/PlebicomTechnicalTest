package com.PlebicomTechnicalTest;

import com.PlebicomTechnicalTest.model.Book;
import com.PlebicomTechnicalTest.model.User;
import com.PlebicomTechnicalTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.PlebicomTechnicalTest.repository.BookRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)*/
@SpringBootApplication
public class PlebicomTechnicalTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PlebicomTechnicalTestApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository repo;
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

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("name2023");

		User newUser = new User("name@provider.com", password);
		User savedUser = repo.save(newUser);
	}

}
