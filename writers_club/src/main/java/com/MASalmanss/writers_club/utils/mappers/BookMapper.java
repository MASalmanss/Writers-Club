package com.MASalmanss.writers_club.utils.mappers;

import com.MASalmanss.writers_club.dto.bookDtos.BookDto;
import com.MASalmanss.writers_club.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface BookMapper {
    Book BookDtoToBook(BookDto bookDto);
}
