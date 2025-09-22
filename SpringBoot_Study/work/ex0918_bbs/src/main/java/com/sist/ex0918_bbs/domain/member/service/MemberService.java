package com.sist.ex0918_bbs.domain.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.ex0918_bbs.domain.member.entity.Member;
import com.sist.ex0918_bbs.domain.member.repository.MemberRepository;
import com.sist.ex0918_bbs.global.jwt.JwtProvider;
import com.sist.ex0918_bbs.global.result.ResultData;
import com.sist.ex0918_bbs.global.security.JwtUser;

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
    public boolean validateToken(String token){
        return jwtProvider.verify(token);
    }

    public Member authAndMakeToken(String mid, String mpw) {
        Member member = null;
        String accessToken = null;
        try {
            member = memberRepository.findByMid(mid).orElseThrow(() -> new RuntimeException("Member not found"));
            //위는 mid값만 가지고 검색한 멤버이므로 다시 비밀번호를 확인해야한다.
            if(passwordEncoder.matches(mpw, member.getMpw())) {
                //여기는 위의 runtimeException이 발생하지 않을 떄만 수행함!
                //회원정보를 가지고 토큰 생성
                Map<String, Object> map = new HashMap<>();
                map.put("idx", member.getB_idx());
                map.put("mid", member.getMid());
                
                map.put("mname", member.getMname());
                map.put("write_date", member.getWrite_date());
                
                accessToken = jwtProvider.getAccessToken(map);
                String refreshToken = jwtProvider.getRefreshToken(map);
                member.setAccessToken(accessToken);
                member.setRefreshToken(refreshToken);
                //DB에 업데이트할거면 여기서 해도 됨
                memberRepository.updateRefreshToken(member.getB_idx(),refreshToken);
            }else {//비밀번호가 일치하면 토큰 생성
                member = null;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("accessToken: " + accessToken);
        return member;
    }

    public ResultData<String> refreshAccessToken(String refreshtoken) {
        Member member = null;

        member = memberRepository.findByRefreshToken(refreshtoken).orElseThrow(() -> new RuntimeException("Member not found"));

        //토큰 생성할 때 넣을 Payload값 준비
        Map<String, Object> map = new HashMap<>();
        map.put("idx", member.getB_idx());
        map.put("mid", member.getMid());
        map.put("mname", member.getMname());
        map.put("write_date", member.getWrite_date());
        
        String accessToken = jwtProvider.getAccessToken(map);

        int cnt = 0;
        String msg = "failed";
        if(accessToken != null) {
            cnt = 1;
            msg = "success";
        }

        return ResultData.of(cnt, msg, accessToken);
    }

    public JwtUser getUserFromAccessToken(String accessToken) {
        Map<String, Object> payload = jwtProvider.getClaims(accessToken);

        String mid = (String) payload.get("mid");
        String mname = (String) payload.get("mname");
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new JwtUser(mid, mname, "", authorities);
    }

    public Optional<Member> login(String mid){
        return null;
    }
}
