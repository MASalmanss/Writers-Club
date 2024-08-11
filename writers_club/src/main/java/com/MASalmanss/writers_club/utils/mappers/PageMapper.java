package com.MASalmanss.writers_club.utils.mappers;

import com.MASalmanss.writers_club.dto.bookDtos.PageDto;
import com.MASalmanss.writers_club.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageMapper {

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    PageDto pageToPageDto(Page page);

    List<PageDto> pageToPageDto(List<Page> pages);

    Page pageDtoToPage(PageDto pageDto);
}
