package com.MASalmanss.writers_club.utils.mappers;

import com.MASalmanss.writers_club.dto.bookDtos.ThemeDto;
import com.MASalmanss.writers_club.entity.Theme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ThemeMapper {
    Theme ThemeDtoToTheme(ThemeDto themeDto);
}
