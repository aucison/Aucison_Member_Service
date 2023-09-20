package com.example.Aucison_Member_Service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestMembersInfoDto {
    private Long membersId;
    private Long membersInfoId;
}
