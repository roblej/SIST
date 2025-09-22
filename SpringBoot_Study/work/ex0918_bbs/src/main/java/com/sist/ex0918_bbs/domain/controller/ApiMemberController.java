package com.sist.ex0918_bbs.domain.controller;

import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0918_bbs.domain.member.entity.Member;
import com.sist.ex0918_bbs.domain.member.input.MemVO;
import com.sist.ex0918_bbs.domain.member.service.MemberService;
import com.sist.ex0918_bbs.domain.member.service.RequestService;
import com.sist.ex0918_bbs.global.result.ResultData;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class ApiMemberController {
    private final MemberService memberService;
    private final RequestService requestService;
    private final HttpServletResponse response;
    
    @PostMapping("/login")
    public ResultData<Member> login(@RequestBody MemVO mvo){
        int cnt = 0;
        Member mem = memberService.authAndMakeToken(mvo.getMid(), mvo.getMpw());
        String msg = "failed";
        if(mem != null) {
            ResponseCookie cookie = ResponseCookie.from(
                "accessToken", mem.getAccessToken())
                .path("/")//특정 도메인에서 사용하도록
                .sameSite("None")// CSRF 관련 문제를 해결
                .httpOnly(true)// 클라이언트 등을 통해 쿠키가 탈취되는것을 방지
                .secure(true)// 쿠키가 탈취당해도 암호화가 되어있어서 안전함
                .build();
            response.addHeader("Set-Cookie", cookie.toString());
            cookie = ResponseCookie.from(
                "refreshToken", mem.getRefreshToken())
                .path("/")//특정 도메인에서 사용하도록
                .sameSite("None")// CSRF 관련 문제를 해결
                .httpOnly(true)// 클라이언트 등을 통해 쿠키가 탈취되는것을 방지
                .secure(true)// 쿠키가 탈취당해도 암호화가 되어있어서 안전함
                .build();
            response.addHeader("Set-Cookie", cookie.toString());
            msg = "success";
            cnt = 1;
        }

        return ResultData.of(cnt, msg, mem);
    }

    @PostMapping("/logout")
    public ResultData<Member> logout() {
    requestService.removeHeaderCookie("accessToken");
    requestService.removeHeaderCookie("refreshToken");
    return ResultData.of(0, "logout", null); //json전달
    }
}
