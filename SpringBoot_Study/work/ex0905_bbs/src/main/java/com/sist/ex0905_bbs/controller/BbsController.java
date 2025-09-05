package com.sist.ex0905_bbs.controller;

import com.sist.ex0905_bbs.mybatis.mapper.BbsMapper;
import com.sist.ex0905_bbs.mybatis.service.BbsService;
import com.sist.ex0905_bbs.mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/bbs")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        BbsVO[] ar = bbsService.getAll();
        mv.setViewName("bbs");
        mv.addObject("ar",ar);
        return mv;
    }

    @PostMapping("/search")
    public ModelAndView search(String type,String value){
        ModelAndView mv = new ModelAndView();
        BbsVO[] ar = bbsService.search(type,value);
        mv.setViewName("bbs");
        mv.addObject("ar",ar);
        return mv;
    }
}
