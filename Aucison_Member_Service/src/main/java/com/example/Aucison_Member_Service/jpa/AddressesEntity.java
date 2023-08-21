package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "addresses")
public class AddressesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addresses_id")
    private Long id;

    @Column(nullable = false)
    private String zip_num;

    @Column(nullable = false)
    private String addr;

    @Column(nullable = false)
    private String addr_detail;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "members_info_id")
    private MembersInfoEntity membersInfoEntity; // 연관관계 주인
}
