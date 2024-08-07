package com.MASalmanss.writers_club.service.abstracks;

import com.MASalmanss.writers_club.entity.Theme;

import java.util.List;

public interface ThemeService {
    Theme findById(Long id);
    List<Theme> findAll();
    Theme save(Theme theme);
    void deleteById(Theme theme);
}
