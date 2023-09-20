package com.example.Aucison_Member_Service.dto;

import com.example.Aucison_Member_Service.jpa.Category;
import com.example.Aucison_Member_Service.jpa.Kind;
import lombok.Data;

@Data
public class HistoryDto {
    private Long ordersId;
    private String name;
    private String info;
    private String img_name; /// 논의 필요
    private Category category;
}
