package com.sist.ex0918_bbs.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sist.ex0918_bbs.domain.member.service.MemberService;
import com.sist.ex0918_bbs.domain.member.service.RequestService;
import com.sist.ex0918_bbs.global.result.ResultData;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
@Component
@RequiredArgsConstructor
public class jwtAuthorizationFilter extends OncePerRequestFilter {

    private final RequestService requestService;
    private final MemberService memberService;

    @Override
    @SneakyThrows // try-catch 처리를 자동으로 해줌
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if(request.getRequestURI().equals("/api/members/login")||request.getRequestURI().equals("/api/members/logout")) {
            filterChain.doFilter(request, response);
            return;
        }//로그인 또는 로그아웃은 통과시킴
        //accessToken검증과 refreshToken을 발급
        String accessToken = requestService.getCookie("accessToken");
        if(!accessToken.isBlank()){
            //accessToken이  만료 시 refreshToken을 사용해서 새로운 accessToken을 발급
            if(!memberService.validateToken(accessToken)){
                String refreshToken = requestService.getCookie("refreshToken");

                ResultData<String> resultData = memberService.refreshAccessToken(refreshToken);

                requestService.setHeaderCookie("accessToken", resultData.getData());

                accessToken = resultData.getData();
            }
                JwtUser jwtUser = memberService.getUserFromAccessToken(accessToken);
                //인가 처리---매우 중요
                requestService.setMember(jwtUser);
        }
        filterChain.doFilter(request, response);

    }

}
