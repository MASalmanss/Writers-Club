package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.entity.Theme;
import com.MASalmanss.writers_club.repository.ThemeRepository;
import com.MASalmanss.writers_club.service.abstracks.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {
    private final ThemeRepository themeRepository;

    @Override
    public Theme findById(Long id) {
        return themeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Theme not found"));
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme save(Theme theme) {
        return null;
    }

    @Override
    public void deleteById(Theme theme) {

    }
}
