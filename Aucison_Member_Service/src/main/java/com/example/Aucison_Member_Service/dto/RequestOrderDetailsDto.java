package com.example.Aucison_Member_Service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestOrderDetailsDto {
    private String email;
    //private Long ordersId; // 이거 수정이 필요합니다..없애야할듯..
    private Long historiesId;
}
