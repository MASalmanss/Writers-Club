package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.entity.Page;

import java.util.List;
import java.util.Optional;

public interface PageService {
    Page findById(Long id);
    List<Page> findAll();
    Page save(Page page);
    void delete(Long id);
}
