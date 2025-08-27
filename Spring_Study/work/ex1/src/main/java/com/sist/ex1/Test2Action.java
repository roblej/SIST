package com.sist.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test2Action {
    @RequestMapping("/ex2")
    public ModelAndView execute() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "sist");
        mv.setViewName("ex2");
        return mv; // /web-inf/jsp/ex1.jsp로 forward함
    }
    @RequestMapping("/ex3")
    public ModelAndView execute2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("str", "sist2123");
        mv.setViewName("ex3");
        return mv;
    }
}
