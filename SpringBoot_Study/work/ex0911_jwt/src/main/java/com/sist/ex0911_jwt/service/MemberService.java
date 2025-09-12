package com.sist.ex0911_jwt.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sist.ex0911_jwt.jwt.JwtProvider;
import com.sist.ex0911_jwt.repository.MemberRepository;
import com.sist.ex0911_jwt.vo.MemVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository mRepository;
    private final JwtProvider jwtProvider;

    public String makeToken(String mid) {
        MemVO mvo = null;

        Optional<MemVO> vo = mRepository.findBymId(mid);
        String token = null;

        if(vo.isPresent()){
        mvo = vo.get();
        //mvo를 map구조로 변환
        Map<String,Object> map = new HashMap<>();
        map.put("mIdx", mvo.getMIdx());
        map.put("mid", mvo.getMId());
        map.put("mname", mvo.getMName());
    
        token = jwtProvider.getToken(map, 3600);
    }
        
        return token;
    }
    
}