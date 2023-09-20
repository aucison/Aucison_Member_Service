package com.example.Aucison_Member_Service.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status { // 경매 상태(응찰/낙찰/패찰) 등등...수정이 필요합니다

    NORM("PROD_NORMAL", "일반 상품"),
    HAND("PROD_HANDMADE", "핸드메이드 상품");

    private final String kind;
    private final String title;
}
