package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.repository.BookRepository;
import com.MASalmanss.writers_club.repository.PageRepository;
import com.MASalmanss.writers_club.service.abstracks.BookService;
import com.MASalmanss.writers_club.utils.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final PageRepository pageRepository;
    private final UserDetailsService userDetailsService;
    @Override
    public Book save(BookDto bookDto) {
        Book book = bookMapper.BookDtoToBook(bookDto);
        Long pagesize = book.getPageSize();
        book.setAdmin_id(bookDto.admin_id());
        bookRepository.save(book);
        for (int i = 0 ; i < pagesize ; i++) {
            Page page = Page.builder()
                    .title("Page " + i )
                    .isComplicated(false)
                    .book(book)
                    .build();
            pageRepository.save(page);
        }
        return book;
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

    @Override
    public Book update(Book book) {
        return null;
    }
}
