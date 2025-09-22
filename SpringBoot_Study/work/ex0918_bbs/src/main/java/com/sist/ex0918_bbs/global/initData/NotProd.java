package com.sist.ex0918_bbs.global.initData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sist.ex0918_bbs.domain.bbs.service.BbsService;
import com.sist.ex0918_bbs.domain.member.service.MemberService;

@Configuration
@Profile({"dev","test"})
public class NotProd {
    //가짜데이터(개발때만 미리 데이터들 넣어주기 위함

    @Bean
    CommandLineRunner initData(BbsService bbsService, MemberService memberService,PasswordEncoder passwordEncoder) {
 
        return (args) -> {
            bbsService.create("title1", "content1", "writer1");
            bbsService.create("title2", "content2", "writer2");
            bbsService.create("title3", "content3", "writer3");
            memberService.join("user1", passwordEncoder.encode("1111"), "user1");
            memberService.join("user2", passwordEncoder.encode("1234"), "user2");
            memberService.join("user3", passwordEncoder.encode("4321"), "user3");
        };
    }
}
