package com.example.Aucison_Member_Service.controller;

import com.example.Aucison_Member_Service.dto.MemberDto;
import com.example.Aucison_Member_Service.dto.MembersInfoDto;
import com.example.Aucison_Member_Service.vo.RequestLoginVo;
import com.example.Aucison_Member_Service.vo.RequestSignInVo;
import com.example.Aucison_Member_Service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member-service")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody RequestSignInVo request) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        MemberDto memberDto = mapper.map(request, MemberDto.class);
        authService.createMember(memberDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity logIn(@RequestBody RequestLoginVo request) {
        return authService.login(request);
    }

    @PostMapping("/logout")
    public ResponseEntity logOut(@RequestHeader("accessToken") String accessToken) {
        authService.logout(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

//    @PostMapping("/reissue")
//    public ResponseEntity reissue(@RequestHeader("refreshToken") String refreshToken) {
//        return authService.reissueToken(refreshToken);
//    }

    @GetMapping("/mp")
    public ResponseEntity getMemberInfo(@RequestHeader("accessToken") String accessToken) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.getMember(accessToken));
    }

    @PatchMapping("/mp")
    public ResponseEntity patchMemberInfo(@RequestHeader("accessToken") String accessToken, @RequestBody MembersInfoDto membersInfoDto) {
        authService.patchMember(accessToken, membersInfoDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
