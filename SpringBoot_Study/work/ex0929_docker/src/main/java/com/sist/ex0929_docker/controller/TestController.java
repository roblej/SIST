package com.sist.ex0929_docker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @RequestMapping("/t1")
    public Map<String, Object> t1(@RequestParam String param){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "도커 연습");
        map.put("str", param);
        
        return map;
    }

}
