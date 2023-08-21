package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "histories")
public class HistoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "histories_id")
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String info;

    @Column(nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "members_info_id")
    private MembersInfoEntity membersInfoEntity; // 연관관계 주인

    @OneToOne(mappedBy = "historiesEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private HistoriesImgEntity historiesImgEntity;
}
