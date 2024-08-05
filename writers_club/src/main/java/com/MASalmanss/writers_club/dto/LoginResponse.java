package com.MASalmanss.writers_club.dto;

import lombok.Builder;

@Builder
public record LoginResponse(String token , Long expresedIn) {
}
