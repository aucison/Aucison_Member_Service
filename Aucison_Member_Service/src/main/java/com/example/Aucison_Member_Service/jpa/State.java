package com.example.Aucison_Member_Service.jpa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum State { // 주문 상태(뭐뭐있는지...추후 수정 필요합니다)

    PAID("PROD_PAID", "결제 완료"),
    SHIP("PROD_SHIPPED", "배송 완료");

    private final String kind;
    private final String title;
}
