package com.sist.ex0918_bbs.domain.member.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.ex0918_bbs.domain.member.entity.Member;
import com.sist.ex0918_bbs.domain.member.repository.MemberRepository;
import com.sist.ex0918_bbs.global.jwt.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;


    public Member join(String mid, String mpw, String mname) {
        Member mem = Member.builder()
            .mid(mid)
            .mpw(mpw)
            .mname(mname)
            .build();
        return memberRepository.save(mem);
    }

    public Member authAndMakeToken(String mid, String mpw) {
        Member member = null;
        String accessToken = null;
        try {
            member = memberRepository.findByMid(mid).orElseThrow(() -> new RuntimeException("Member not found"));
            //위는 mid값만 가지고 검색한 멤버이므로 다시 비밀번호를 확인해야한다.
            if(passwordEncoder.matches(mpw, member.getMpw())) {
               System.out.println("mpw: " + mpw);
               System.out.println("member.getMpw(): " + member.getMpw());
                //여기는 위의 runtimeException이 발생하지 않을 떄만 수행함!
                //회원정보를 가지고 토큰 생성
                Map<String, Object> map = new HashMap<>();
                map.put("idx", member.getB_idx());
                map.put("mid", member.getMid());
                
                map.put("mname", member.getMname());
                map.put("write_date", member.getWrite_date());
                
                accessToken = jwtProvider.getToken(map, 3600);
                String refreshToken = jwtProvider.getToken(map, 3600*3);
                member.setAccessToken(accessToken);
                member.setRefreshToken(refreshToken);
            }//비밀번호가 일치하면 토큰 생성

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("accessToken: " + accessToken);
        return member;
    }

}
