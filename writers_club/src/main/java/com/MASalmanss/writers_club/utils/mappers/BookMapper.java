package com.MASalmanss.writers_club.utils.mappers;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface BookMapper {
    Book BookDtoToBook(BookDto bookDto);

    @Mapping(source = "theme.id" , target = "theme_id")
    BookDto BookToBookDto(Book book);


    List<BookDto> BooksToBookDto(List<Book> books);
}
