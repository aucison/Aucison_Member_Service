package com.example.Aucison_Member_Service.dto;

import com.example.Aucison_Member_Service.jpa.Category;
import com.example.Aucison_Member_Service.jpa.HistoriesEntity;
import com.example.Aucison_Member_Service.jpa.State;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseSellHistoryDto {
    //private Long ordersId; // 주문 고유 번호//////수정필요
    private Long historiesId;
    private String name; // 상품명
    private String info; // 상품 상세 정보
    private String imgUrl; // 이미지//////////////수정필요?
    private Category category; // 경매 여부(경매/비경매)
    private State state; // 주문 상태(결제/배송)
    private Float price; // 비경매 상품일 때 등록 가격
    private Float nowPrice; // 경매 상품일 때 실시간 가격

    public ResponseSellHistoryDto(HistoriesEntity historiesEntity) {
        this.historiesId = historiesEntity.getId();
        this.name = historiesEntity.getName();
        this.info = historiesEntity.getInfo();
        this.category = historiesEntity.getCategory();
        this.price = historiesEntity.getPrice(); ////경매/비경매 개선 필요
        this.nowPrice = historiesEntity.getPrice(); ////경매/비경매 개선 필요
    }
}
