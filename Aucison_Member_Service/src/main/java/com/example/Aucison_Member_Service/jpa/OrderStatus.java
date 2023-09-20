package com.example.Aucison_Member_Service.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus { // 상태 분류(구매/판매)

    BUY("STATUS_BUY", "구매"),
    SELL("STATUS_SELL", "판매");

    private final String status;
    private final String title;
}
