package com.MASalmanss.writers_club.repository;

import com.MASalmanss.writers_club.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> findAllPagesByBookId(Long bookId);
}
