package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.entity.Book;

import java.util.List;

public interface BookService {
    public Book save(Book book);
    public Book getById(Long bookId);
    public List<Book> getAll();
    public void delete(Book book);
}
