package com.example.Aucison_Member_Service.service;

import com.example.Aucison_Member_Service.dto.RequestDeleteZzimDto;
import com.example.Aucison_Member_Service.dto.ResponseZzimHistoryDto;

import java.util.List;

public interface ZzimService {
    // 찜 내역 조회
    List<ResponseZzimHistoryDto> getZzimHistoryList(String accessToken);
    // 찜 내역 취소
    void deleteZzim(Long wishesId) throws Exception;
}
