package com.example.Aucison_Member_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseLoginDto {
    String accessToken;
    String refreshToken;
}
