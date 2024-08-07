package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.repository.BookRepository;
import com.MASalmanss.writers_club.service.abstracks.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public Book save(Book book) {
       return bookRepository.save(book);
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new IllegalArgumentException("Book not found"));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }


    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
