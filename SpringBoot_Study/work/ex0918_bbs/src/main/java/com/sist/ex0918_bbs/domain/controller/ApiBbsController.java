package com.sist.ex0918_bbs.domain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0918_bbs.domain.bbs.entity.Bbs;
import com.sist.ex0918_bbs.domain.bbs.entity.service.BbsService;
import com.sist.ex0918_bbs.global.result.ResultData;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
        return ResultData.of(1, "success", bbs);
    }
}
