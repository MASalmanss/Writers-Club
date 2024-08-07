package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.service.abstracks.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
public class BookController {
    private final BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("")
    public Book updateBook(@RequestBody Book book) {
        return bookService.save(book);
    }
}
