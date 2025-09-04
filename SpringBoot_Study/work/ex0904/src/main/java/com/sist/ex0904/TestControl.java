package com.sist.ex0904;

import data.vo.DataVO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControl {

    @GetMapping("/index")
    public ModelAndView index(String code) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("code", code);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/")
    public String main(Model model, String code) {
        //request에 저장도니 Model의 주소를 model로 받는다.
        if(code != null) {
            DataVO vo = new DataVO();
            vo.setStr(code);
            model.addAttribute("vo", vo);
        }
        return "test";
    }
}
