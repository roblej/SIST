package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
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
}
