package com.sist.ex0905_dept.controller;

import com.sist.ex0905_dept.service.DeptService;
import com.sist.ex0905_dept.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DeptController {

    //사용할서비스
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    public ModelAndView dept() {
        ModelAndView mv = new ModelAndView("dept");
        DeptVO[] ar = deptService.getTotal();
        mv.addObject("ar", ar);
        return mv;
    }
}
