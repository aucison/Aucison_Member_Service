package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "members")
public class MembersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(name = "members_code", nullable = false)
    // 이 값이 꼭 필요할까요?.. PK를 UUID로 만드는 전략보다 나을지 의문
    private String membersCode;

    @OneToOne(mappedBy = "membersEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private MembersInfoEntity membersInfoEntity;

    @OneToMany(mappedBy = "membersEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private WishesEntity wishesEntity;
}
