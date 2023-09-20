package com.example.Aucison_Member_Service.service;

import com.example.Aucison_Member_Service.dto.MemberDto;
import com.example.Aucison_Member_Service.vo.RequestLoginVo;
import com.example.Aucison_Member_Service.dto.MembersInfoDto;
import com.example.Aucison_Member_Service.jpa.MembersEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    MemberDto createMember(MemberDto memberDto);
    ResponseEntity login(RequestLoginVo requestLoginVo);
    void logout(String accessToken);
    ResponseEntity reissueToken(String refreshToken);
    MembersInfoDto getMember(String accessToken);
    void patchMember(String accessToken, MembersInfoDto membersInfoDto);

    Iterable<MembersEntity> getMemberByAll();
//    MemberDto getMemberDetailsByGoogleEmail(String email);
}
