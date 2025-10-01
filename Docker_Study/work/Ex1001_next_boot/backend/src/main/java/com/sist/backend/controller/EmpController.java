package com.sist.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.backend.service.EmpService;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/all")
    public Map<String, Object> all() {
        Map<String, Object> map = new HashMap<>();
        map.put("ar", empService.getAll());
        return map;
    }
}