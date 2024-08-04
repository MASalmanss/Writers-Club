package com.MASalmanss.writers_club;

import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WritersClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(WritersClubApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookRepository){
		return result ->{
			Book book = Book.builder()
					.title("akifin kitabı")
					.content("bir gün zenci")
					.pageSize(231L)
					.isComplicated(true)
					.description("güzel")
					.build();

			bookRepository.save(book);

			Thread.sleep(3000);
			book.setContent("sgahjska");
			bookRepository.save(book);
		};
	}

}
