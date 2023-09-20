package com.example.Aucison_Member_Service.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<MembersEntity, Long> {
    MembersEntity findByEmail(String email);
}
