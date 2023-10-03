package com.example.Aucison_Member_Service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishesRepository extends JpaRepository<WishesEntity, Long> {
    List<WishesEntity> findByMembersEntity(MembersEntity membersEntity);
}
