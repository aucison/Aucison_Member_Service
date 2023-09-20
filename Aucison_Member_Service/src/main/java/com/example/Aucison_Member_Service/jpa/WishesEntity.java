package com.example.Aucison_Member_Service.jpa;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "wishes")
public class WishesEntity { // 찜

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishes_id")
    private Long id; // 찜 id

    @ManyToOne
    @JoinColumn(name = "email") // 연관관계 주인
    private MembersEntity membersEntity; // 사용자

    @Column(name = "products_id", nullable = false)
    private Long productId; // products-server: products entity의 products_id
}
