package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wishes")
public class WishesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishes_id")
    private Long id;

    @Column(nullable = false)
    private Boolean status;

    @Column(name = "products_code", nullable = false)
    private String productsCode;

    @ManyToOne
    @JoinColumn(name = "members_id")
    private MembersEntity membersEntity; // 연관관계 주인
}
