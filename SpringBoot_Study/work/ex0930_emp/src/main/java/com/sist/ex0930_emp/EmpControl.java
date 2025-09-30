package com.sist.ex0930_emp;

import com.sist.ex0930_emp.mybatis.service.EmpService;
import com.sist.ex0930_emp.mybatis.vo.EmpVO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpControl {
    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    public Map<String, Object> empList(){

        //뷰페이지에서 표현할 데이터 받기
        EmpVO[] ar = empService.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("list", ar);
        return map;
    }
}
