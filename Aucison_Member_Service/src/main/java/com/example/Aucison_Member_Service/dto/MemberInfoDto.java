package com.example.Aucison_Member_Service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberInfoDto {
    private String subEmail; // 수신 이메일
    private String nickName; // 별명
    private String phone; // 전화번호
    private String imgUrl; // 프로필 사진 URL////////////수정필요
    /////////////////////////이미지 관련 정보... 논의 필요할 듯 일단 냅둡니다
}
