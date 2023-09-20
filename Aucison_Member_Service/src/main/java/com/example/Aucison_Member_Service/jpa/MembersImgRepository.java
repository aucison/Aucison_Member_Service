package com.example.Aucison_Member_Service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersImgRepository extends JpaRepository<MembersImgEntity, Long> {
    MembersImgEntity findByMembersInfoEntity(MembersInfoEntity membersInfoEntity);
}
