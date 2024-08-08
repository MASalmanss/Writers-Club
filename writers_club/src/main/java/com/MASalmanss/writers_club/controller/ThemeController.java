package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.dto.bookDtos.ThemeDto;
import com.MASalmanss.writers_club.entity.Theme;
import com.MASalmanss.writers_club.repository.ThemeRepository;
import com.MASalmanss.writers_club.service.abstracks.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping("/{id}")
    public Theme findById(@PathVariable Long id) {
        return themeService.findById(id);
    }

    @GetMapping("")
    public List<Theme> findAll() {
        return themeService.findAll();
    }

    @PostMapping("")
    public Theme create(@RequestBody ThemeDto themeDto) {
       return themeService.save(themeDto);
    }

    @PutMapping("")
    public Theme update(@RequestBody ThemeDto themeDto) {
        return themeService.save(themeDto);
    }

}
