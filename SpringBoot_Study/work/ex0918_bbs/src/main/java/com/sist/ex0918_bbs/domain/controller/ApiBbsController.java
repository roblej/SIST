package com.sist.ex0918_bbs.domain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0918_bbs.domain.bbs.entity.Bbs;
import com.sist.ex0918_bbs.domain.bbs.service.BbsService;
import com.sist.ex0918_bbs.global.result.ResultData;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bbs")
public class ApiBbsController {
    private final BbsService bbsService;

    @GetMapping("")
    public ResultData<List<Bbs>> getList() {
        List<Bbs> list = bbsService.getList();
        String msg = "failed";
        if(list.size() > 0) {
            msg = "success";
        }
        return ResultData.of(list.size(), msg, list);
    }

    @GetMapping("/{b_idx}")
    public ResultData<Bbs> getBbs(@PathVariable Long b_idx) {
        Bbs bbs = bbsService.getBbs(b_idx);
        String msg = "failed";
        if(bbs != null) {
            msg = "success";
        }
        return ResultData.of(1, msg, bbs);
    }

    @PostMapping("/write")
    public ResultData<Bbs> writeBbs(@RequestBody Bbs bbs) {
       Bbs bvo = bbsService.create(bbs.getTitle(), bbs.getContent(), bbs.getWriter());
       //저장된 결과가 bvo이고 그 안에는 b_idx라는 기본키도 가지고 있다.
       //b_idx값을 다른 테이블에도 저장할 수 있다.
       String msg = "failed";
       if(bvo != null) {
            msg = "success";
       }
        return ResultData.of(1, msg, bvo);
    }
}
