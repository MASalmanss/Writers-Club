package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;
import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.repository.BookRepository;
import com.MASalmanss.writers_club.repository.PageRepository;
import com.MASalmanss.writers_club.repository.ThemeRepository;
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
    private final ThemeRepository themeRepository;

    @Override
    public Book save(BookDto bookDto) {
        Book book = bookMapper.BookDtoToBook(bookDto);

        // ID ve tema ID kontrolü
        Long adminId = bookDto.admin_id();
        Long themeId = bookDto.theme_id();

        book.setAdmin_id(adminId);
        book.setTheme(themeRepository.findById(themeId)
                .orElseThrow(() -> new IllegalArgumentException("Theme not found")));

        try {
            book = bookRepository.save(book);

            Long pageSize = book.getPageSize();
            for (int i = 0; i < pageSize; i++) {
                Page page = Page.builder()
                        .title("Page " + i)
                        .isComplicated(false)
                        .book(book)
                        .build();
                pageRepository.save(page);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Kitap eklenirken bir hata oluştu.");
        }

        return book;
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    @Override
    public List<BookDto> getAll() {
        return bookMapper.BooksToBookDto(bookRepository.findAll());
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book update(Book book) {
        // Kitap güncelleme işlemleri burada yapılmalıdır
        // Güncellenen kitabı veritabanına kaydet
        return bookRepository.save(book);
    }
}
