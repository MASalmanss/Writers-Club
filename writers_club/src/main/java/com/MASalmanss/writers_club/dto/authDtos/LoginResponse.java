package com.MASalmanss.writers_club.dto.authDtos;

import lombok.Builder;

@Builder
public record LoginResponse(String token , Long expresedIn) {
}
