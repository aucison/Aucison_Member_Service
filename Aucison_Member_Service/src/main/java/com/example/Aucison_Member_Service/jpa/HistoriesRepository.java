package com.example.Aucison_Member_Service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriesRepository extends JpaRepository<HistoriesEntity, Long> {
    List<HistoriesEntity> findByMembersInfoEntity(MembersInfoEntity membersInfoEntity);
}
