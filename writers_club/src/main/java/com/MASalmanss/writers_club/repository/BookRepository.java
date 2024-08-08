package com.MASalmanss.writers_club.repository;

import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book , Long> {
}
