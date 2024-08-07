package com.MASalmanss.writers_club.controller;

import com.MASalmanss.writers_club.service.abstracks.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theme")
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeService themeService;
}
