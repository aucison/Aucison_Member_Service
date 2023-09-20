package com.example.Aucison_Member_Service.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLoginVo {
    private String email;
}
