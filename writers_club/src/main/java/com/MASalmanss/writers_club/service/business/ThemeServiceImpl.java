package com.MASalmanss.writers_club.service.business;

import com.MASalmanss.writers_club.dto.bookDtos.ThemeDto;
import com.MASalmanss.writers_club.entity.Theme;
import com.MASalmanss.writers_club.repository.ThemeRepository;
import com.MASalmanss.writers_club.service.abstracks.ThemeService;
import com.MASalmanss.writers_club.utils.mappers.ThemeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {
    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;

    @Override
    public Theme findById(Long id) {
        return themeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Theme not found"));
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme save(ThemeDto themeDto) {
        Theme theme = themeMapper.ThemeDtoToTheme(themeDto);
        return themeRepository.save(theme);
    }

    @Override
    public void deleteById(Long id) {
        themeRepository.deleteById(id);
    }
}
