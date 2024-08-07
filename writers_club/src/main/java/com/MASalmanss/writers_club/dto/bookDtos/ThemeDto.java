package com.MASalmanss.writers_club.dto.bookDtos;

import jakarta.validation.constraints.NotNull;

public record ThemeDto(@NotNull String title ,@NotNull String description) {
}
