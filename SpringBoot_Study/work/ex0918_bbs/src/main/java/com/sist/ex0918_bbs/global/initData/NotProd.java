package com.sist.ex0918_bbs.global.initData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sist.ex0918_bbs.domain.bbs.entity.service.BbsService;

@Configuration
@Profile({"dev","test"})
public class NotProd {
    //가짜데이터(개발때만 미리 데이터들 넣어주기 위함

    @Bean
    CommandLineRunner initData(BbsService bbsService) {
        return (args) -> {
            bbsService.save("title1", "content1", "writer1");
            bbsService.save("title2", "content2", "writer2");
            bbsService.save("title3", "content3", "writer3");
        };
    }
}
