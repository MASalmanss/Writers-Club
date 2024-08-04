package com.MASalmanss.writers_club.repository;

import com.MASalmanss.writers_club.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
