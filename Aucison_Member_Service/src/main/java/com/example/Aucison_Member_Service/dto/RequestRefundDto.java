package com.example.Aucison_Member_Service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestRefundDto {
    private Long ordersId; // 주문 고유 번호
    private Long membersId; // 판매자 고유 번호
}
