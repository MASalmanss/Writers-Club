package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.dto.bookDtos.PageDto;
import com.MASalmanss.writers_club.entity.Page;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface PageService {
    Page findById(Long id);
    List<Page> findAll();
    Page save(PageDto pageDto);
    void delete(Long id);
    PageDto update(PageDto pageDto , Long id) throws BadRequestException;
}
