package com.example.Aucison_Member_Service.dto;

import com.example.Aucison_Member_Service.jpa.Category;
import lombok.Builder;

@Builder
public class ResponseZzimHistoryDto {

    private Long wishesId; // 찜 ID
    private String name; // 상품명
    private String summary; // 상품 한 줄 설명
    private String imgUrl; // 상품 대표 이미지
    private Category category; // 경매 여부(경매/비경매)
    private Float price; // 등록 가격(비경매)
    private Float nowPrice; // 실시간 가격(경매)
}
