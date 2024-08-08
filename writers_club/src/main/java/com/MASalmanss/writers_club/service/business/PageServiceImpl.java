package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.entity.Page;
import com.MASalmanss.writers_club.repository.PageRepository;
import com.MASalmanss.writers_club.service.abstracks.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;
    @Override
    public Page findById(Long id) {
       return pageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Page with id " + id + " not found"));
    }

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public Page save(Page page) {
        return pageRepository.save(page);
    }

    @Override
    public void delete(Long id) {
        Page page = pageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Page with id " + id + " not found"));
        pageRepository.delete(page);
    }
}
