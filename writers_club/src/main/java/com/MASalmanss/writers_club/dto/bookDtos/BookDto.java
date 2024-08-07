package com.MASalmanss.writers_club.dto.bookDtos;

import jakarta.validation.constraints.NotNull;

public record BookDto(
        @NotNull String title
        ,@NotNull String description
        ,@NotNull Long pageSize
        ,@NotNull Boolean isComplicated
        ,@NotNull Long admin_id)
{
}
