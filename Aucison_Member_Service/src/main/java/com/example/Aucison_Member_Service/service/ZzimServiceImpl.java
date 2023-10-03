package com.example.Aucison_Member_Service.service;

import com.example.Aucison_Member_Service.config.security.JwtUtils;
import com.example.Aucison_Member_Service.dto.ResponseZzimHistoryDto;
import com.example.Aucison_Member_Service.jpa.MembersRepository;
import com.example.Aucison_Member_Service.jpa.WishesEntity;
import com.example.Aucison_Member_Service.jpa.WishesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZzimServiceImpl implements ZzimService {

    private final JwtUtils jwtUtils;
    private final MembersRepository membersRepository;
    private final WishesRepository wishesRepository;

    @Override
    public List<ResponseZzimHistoryDto> getZzimHistoryList(String accessToken) {
        String email = jwtUtils.getEmailFromToken(accessToken);
        return wishesRepository.findByMembersEntity(membersRepository.findByEmail(email))
                .stream()
                .map(wishesEntity -> {
                    return ResponseZzimHistoryDto.builder()
                            .wishesId(wishesEntity.getId())
//                            .name()
//                            .summary()
//                            .imgUrl()
//                            .category()
//                            .price()
//                            .nowPrice()
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteZzim(Long wishesId) throws Exception {
        Optional<WishesEntity> wishesEntity = wishesRepository.findById(wishesId);
        if(wishesEntity == null) {
            throw new RuntimeException("error");
        }
        wishesRepository.deleteById(wishesId);
    }
}
