package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "addresses")
public class AddressesEntity { // 주소

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addresses_id")
    private Long id; // 주소 id

    @Column(nullable = false)
    private String addr_name; // 배송지명(사용자 지정값)

    @Column(nullable = false)
    private String zip_num; // 우편번호

    @Column(nullable = false)
    private String addr; // 주소

    @Column(nullable = false)
    private String addr_detail; // 상세주소(동, 호수)

    @Column(nullable = false)
    private String name; // 받는 분 성함
    
    @Column(nullable = false)
    private String tel; // 받는 분 전화번호

    @ManyToOne
    @JoinColumn(name = "members_info_id") // 연관관계 주인
    private MembersInfoEntity membersInfoEntity; // 사용자 추가 정보
}
