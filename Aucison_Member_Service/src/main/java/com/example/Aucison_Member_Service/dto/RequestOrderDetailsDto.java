package com.example.Aucison_Member_Service.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RequestOrderDetailsDto {
    private String email;
    //private Long ordersId; // 이거 수정이 필요합니다..없애야할듯..
    private Long historiesId;
}
