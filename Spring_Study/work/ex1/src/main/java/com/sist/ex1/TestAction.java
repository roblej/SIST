package com.sist.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestAction {
    @RequestMapping("/ex1")
    public ModelAndView execute() {
        ModelAndView mv = new ModelAndView("ex1");
        return mv; // /web-inf/jsp/ex1.jsp로 forward함
    }
}
