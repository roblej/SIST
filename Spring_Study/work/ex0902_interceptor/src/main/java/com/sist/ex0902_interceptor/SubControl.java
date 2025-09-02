package com.sist.ex0902_interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubControl {

    @GetMapping("/sub/bravo")
    public String subControl() {
        return "sub_tab";
    }
}
