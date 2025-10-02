package com.sist.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.sist.backend.service.EmpService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;

    @GetMapping("/all")
    public Object findAll(){
        return empService.findAll();
    }

    @RequestMapping("findByEmpno")
    public Object findByEmpno(@RequestParam Long empno) {
        return empService.findByEmpno(empno);
    }
    
    @RequestMapping("findByJobAndDeptno")
    public Object findByJobAndDeptno(@RequestParam String job, @RequestParam Long deptno) {
        return empService.findByJobAndDeptno(job, deptno);
    }
    
    
}
