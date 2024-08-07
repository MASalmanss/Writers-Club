package com.MASalmanss.writers_club.dto.bookDtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookDto(
        @NotNull String title
        ,@NotNull String description
        ,@NotNull Long pageSize
        ,@NotNull Boolean isComplicated )
{
}
