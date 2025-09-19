package com.sist.ex0918_bbs.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
@Component
public class jwtAuthorizationFilter extends OncePerRequestFilter {

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
        String accessToken = null;
        if(!accessToken.isBlank()){
            //accessToken이 유효하면 통과
        }
        filterChain.doFilter(request, response);

    }

}
