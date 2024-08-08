package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.dto.bookDtos.ThemeDto;
import com.MASalmanss.writers_club.entity.Theme;

import java.util.List;

public interface ThemeService {
    Theme findById(Long id);
    List<Theme> findAll();
    Theme save(ThemeDto themeDto);
    void deleteById(Long id);
    Theme update(ThemeDto themeDto , Long id);
}
