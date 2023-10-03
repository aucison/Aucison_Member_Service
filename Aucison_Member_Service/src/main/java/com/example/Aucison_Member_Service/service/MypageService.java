package com.example.Aucison_Member_Service.service;

import com.example.Aucison_Member_Service.dto.*;

import java.util.List;

public interface MypageService {
    // 기본 구매 내역 조회
    List<ResponseOrderHistoryDto> getOrderHistoryList(String email);
    // 기본 구매 내역 조회 -> 상세 조회
    ResponseOrderDetailsDto getOrderDetails(RequestOrderDetailsDto requestOrderDetailsDto) throws Exception;
    // 판매 내역 조회
    List<ResponseSellHistoryDto> getSellHistoryList(String email);
    // 회원 정보 조회
    //MemberInfoDto getMemberDetails(Long membersId) throws Exception;
    // 회원 정보 수정
    //void patchMemberDetails(RequestMembersInfoDto requestMembersInfoDto);
}
