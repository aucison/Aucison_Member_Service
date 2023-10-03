package com.example.Aucison_Member_Service.controller;

import com.example.Aucison_Member_Service.config.security.JwtUtils;
import com.example.Aucison_Member_Service.dto.RequestOrderDetailsDto;
import com.example.Aucison_Member_Service.dto.ResponseOrderDetailsDto;
import com.example.Aucison_Member_Service.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member-service")
public class MypageController {

    private final JwtUtils jwtUtils;
    private final MypageService mypageService;

    @GetMapping("/mp/buy")
    public ResponseEntity getOrderInfo(@RequestHeader("accessToken") String accessToken) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.getOrderHistoryList(email));
    }

    @GetMapping("/mp/buy/{historiesId}")
    public ResponseEntity getOrderDetail(@PathVariable("historiesId") Long historiesId, @RequestHeader("accessToken") String accessToken) throws Exception {
        ResponseOrderDetailsDto responseOrderDetailsDto = mypageService.getOrderDetails(RequestOrderDetailsDto.builder().email(jwtUtils.getEmailFromToken(accessToken)).historiesId(historiesId).build());
        return ResponseEntity.status(HttpStatus.OK).body(responseOrderDetailsDto);
    }

    @GetMapping("/mp/sell")
    public ResponseEntity getSellInfo(@RequestHeader("accessToken") String accessToken) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.getSellHistoryList(email));
    }
}
