package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "members_info")
public class MembersInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_info_id")
    private Long id;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Float credit;

    @Column(name = "sub_email")
    private String subEmail;

    @OneToOne
    @JoinColumn(name = "members_id")
    private MembersEntity membersEntity; // 연관관계 주인

    @OneToOne(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private MembersImgEntity membersImgEntity;

    @OneToMany(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private AddressesEntity addressesEntity;

    @OneToMany(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private HistoriesEntity historiesEntity;
}
