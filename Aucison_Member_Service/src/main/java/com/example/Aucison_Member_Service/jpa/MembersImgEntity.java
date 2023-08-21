package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "members_img")
public class MembersImgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_imgs_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String size; // type 수정이 필요합니다.

    @Column(name = "h_w", nullable = false)
    private String hW; // type 수정이 필요합니다.

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "members_info_id")
    private MembersInfoEntity membersInfoEntity; // 연관관계 주인
}
