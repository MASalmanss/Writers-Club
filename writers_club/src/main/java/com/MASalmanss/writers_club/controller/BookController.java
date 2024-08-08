package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.dto.bookDtos.PageDto;
import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.entity.User;
import com.MASalmanss.writers_club.repository.UserRepository;
import com.MASalmanss.writers_club.service.abstracks.BookService;
import com.MASalmanss.writers_club.service.abstracks.PageService;
import com.MASalmanss.writers_club.utils.mappers.BookMapper;
import com.MASalmanss.writers_club.utils.mappers.PageMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN' , 'SUPER_ADMIN')")
@Slf4j
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final PageMapper pageMapper;
    private final UserRepository userRepository;
    private final PageService pageService;

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

        return bookService.save(bookDto);
    }

    @PutMapping("/{id}")
    public Book updateBook(@Valid @RequestBody BookDto bookDto , @PathVariable Long id) {
        Book book = bookService.getById(id);
        book.setDescription(bookDto.description());
        book.setTitle(bookDto.title());
        return bookService.save(bookDto);
    }

    @PutMapping("/{id}/users/{id2}")
    public List<PageDto> setPageForUser(@PathVariable Long id , @PathVariable Long id2) {
        Book book = bookService.getById(id);
        User user = userRepository.findById(id2).orElseThrow(()-> new RuntimeException("User Not Found"));
        List<Page> pages = book.getPages();
        for (Page page : pages) {
            if(page.getUser() == null){
                page.setUser(user);
                pageService.save(page);
            }
            break;
        }
         pages = book.getPages();
        return pageMapper.pageToPageDto(pages);
    }
}
