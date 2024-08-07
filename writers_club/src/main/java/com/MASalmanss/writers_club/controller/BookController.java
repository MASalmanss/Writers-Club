package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.service.abstracks.BookService;
import com.MASalmanss.writers_club.utils.mappers.BookMapper;
import jakarta.validation.Valid;
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
    private final BookMapper bookMapper;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping("")
    public Book createBook(@Valid @RequestBody BookDto bookDto) {
        Book book = bookMapper.BookDtoToBook(bookDto);
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@Valid @RequestBody BookDto bookDto , @PathVariable Long id) {
        Book book = bookService.getById(id);
        book.setDescription(bookDto.description());
        book.setTitle(bookDto.title());
        return bookService.save(book);
    }
}
