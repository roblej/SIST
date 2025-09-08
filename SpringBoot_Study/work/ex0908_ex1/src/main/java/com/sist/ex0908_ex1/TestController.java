package com.sist.ex0908_ex1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {
    
    @GetMapping("/t1")
    public String test1() {
        return "연습1입니다";
    }
    
    @GetMapping("/t2")
    public String test2() {
        return "Hello Boot!";
    }

}
