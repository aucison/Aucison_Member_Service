package com.example.Aucison_Member_Service.dto;

import com.example.Aucison_Member_Service.jpa.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseBidsHistoryDto {
    private Status status;
    private Date bidsAt; // 응찰 시간(수정이 필요합니다)
}
