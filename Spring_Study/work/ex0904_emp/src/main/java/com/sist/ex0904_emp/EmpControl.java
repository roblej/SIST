package com.sist.ex0904_emp;

import mybatis.service.EmpService;
import mybatis.vo.BbsVO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpControl {


    @Autowired
    private EmpService empService;

    @RequestMapping("/")
    public String emp(Model model){
        EmpVO[] ar =empService.list();
        model.addAttribute("ar",ar);

        return "emp";
    }

    @PostMapping("/search")
    public ModelAndView search(String type, String value){
        System.out.println(type);
        System.out.println(value);
        ModelAndView mv = new ModelAndView();

        EmpVO[] ar = empService.search(type, value);
        System.out.println(ar.length);
        mv.addObject("ar", ar);
        mv.setViewName("emp");
        return mv;
    }
}
