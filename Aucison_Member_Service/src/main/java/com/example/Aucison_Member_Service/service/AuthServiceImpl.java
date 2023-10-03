package com.example.Aucison_Member_Service.service;

import com.example.Aucison_Member_Service.dto.MemberDto;
import com.example.Aucison_Member_Service.vo.RequestLoginVo;
import com.example.Aucison_Member_Service.dto.MembersInfoDto;
import com.example.Aucison_Member_Service.jpa.*;
import com.example.Aucison_Member_Service.config.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final MembersRepository membersRepository;
    private final MembersInfoRepository membersInfoRepository;
    private final MembersImgRepository membersImgRepository;
    private final JwtUtils jwtUtils;

    @Override
    public MemberDto createMember(MemberDto memberDto) {

        MembersEntity membersEntity = MembersEntity.builder()
                        .email(memberDto.getEmail())
                        .name(memberDto.getName())
//                        .nickname(memberDto.getNickname())
                        .build();

        membersRepository.save(membersEntity);

        return new ModelMapper().map(membersEntity, MemberDto.class);
    }

    @Override
    public ResponseEntity login(RequestLoginVo requestLoginVo) {
        MembersEntity membersEntity = membersRepository.findByEmail(requestLoginVo.getEmail());

        if(membersEntity != null) {
            // MembersEntity -> MemberDto
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            MemberDto memberDto = mapper.map(membersEntity, MemberDto.class);

            String accessToken = jwtUtils.createAccessToken(memberDto);
            String refreshToken = jwtUtils.getRefreshToken(memberDto.getEmail());

            jwtUtils.updateRefreshToken(memberDto, refreshToken);

            HttpHeaders headers = new HttpHeaders();
            headers.add("accessToken", accessToken);
            headers.add("refreshToken", refreshToken);

            return (ResponseEntity) ResponseEntity.ok().headers(headers);

        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void logout(String accessToken) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        jwtUtils.deleteRefreshToken(email);
        jwtUtils.setBlackList(accessToken);
    }

//    @Override
//    public ResponseEntity reissueToken(String refreshToken) { // 토큰 재발행
//
//        String email = jwtUtils.getEmailFromToken(refreshToken);
//        jwtUtils.deleteRefreshToken(email);
//        RequestLoginVo requestLoginVo = RequestLoginVo.builder().email(email).build();
//        return login(requestLoginVo);
//    }

    @Override
    public MembersInfoDto getMember(String accessToken) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        if(email != null) {
            // null 검증 로직 추가하기
            MembersEntity membersEntity = membersRepository.findByEmail(email);
            MembersInfoEntity membersInfoEntity = membersInfoRepository.findByMembersEntity(membersEntity);
            MembersImgEntity membersImgEntity = membersImgRepository.findByMembersInfoEntity(membersInfoEntity);

            return MembersInfoDto.builder()
                    .subEmail(membersInfoEntity.getSubEmail())
                    .name(membersEntity.getName())
                    .nickName(membersEntity.getNickname())
                    .phone(membersInfoEntity.getPhone())
                    .imgUrl(membersImgEntity.getUrl())
                    .build();
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    @Override
    public void patchMember(String accessToken, MembersInfoDto membersInfoDto) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        MembersEntity membersEntity = membersRepository.findByEmail(email);
        MembersInfoEntity membersInfoEntity = membersInfoRepository.findByMembersEntity(membersEntity);
        MembersImgEntity membersImgEntity = membersImgRepository.findByMembersInfoEntity(membersInfoEntity);

        membersImgEntity.updateInfo(
                membersInfoEntity.updateInfo(
                        membersEntity.updateInfo(membersInfoDto),
                        membersInfoDto),
                membersInfoDto);
    }

    @Override
    public Iterable<MembersEntity> getMemberByAll() {
        return null;
    }

//    @Override
//    public MemberDto getMemberDetailsByGoogleEmail(String email) {
//        MembersEntity membersEntity = membersRepository.findByEmail(email);
//
//        if(membersEntity == null) {
//            throw new UsernameNotFoundException(email);
//        }
//
//        MemberDto memberDto = new ModelMapper().map(membersEntity, MemberDto.class);
//
//        return memberDto;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
