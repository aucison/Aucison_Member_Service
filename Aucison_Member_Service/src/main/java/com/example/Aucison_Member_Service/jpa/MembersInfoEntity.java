package com.example.Aucison_Member_Service.jpa;

import com.example.Aucison_Member_Service.dto.MembersInfoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "members_info")
public class MembersInfoEntity { // 사용자 추가 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "members_info_id")
    private Long id; // 사용자 추가 정보 id

    @Column(nullable = false)
    private String phone; // 전화번호

    @Column(nullable = false)
    private Float credit; // 사용자 자산

    @Column(name = "sub_email")
    private String subEmail; // 수신 이메일

    @OneToOne
    @JoinColumn(name = "email") // 연관관계 주인
    private MembersEntity membersEntity; // 사용자

    @OneToOne(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private MembersImgEntity membersImgEntity;

    @OneToMany(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private List<AddressesEntity> addressesEntity;

    @OneToMany(mappedBy = "membersInfoEntity", fetch = FetchType.LAZY) // 양방향 매핑
    private List<HistoriesEntity> historiesEntity;

    public MembersInfoEntity updateInfo(MembersEntity membersEntity, MembersInfoDto membersInfoDto) {
        this.phone = membersInfoDto.getPhone();
        this.subEmail = membersInfoDto.getSubEmail();
        this.membersEntity = membersEntity;

        return this;
    }
}
