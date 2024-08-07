package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;

import java.util.List;

public interface BookService {
    public Book save(BookDto book);
    public Book getById(Long bookId);
    public List<Book> getAll();
    public void delete(Book book);
    Book update(Book book);
}
