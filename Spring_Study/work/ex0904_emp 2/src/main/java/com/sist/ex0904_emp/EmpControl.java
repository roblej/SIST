package com.sist.ex0904_emp;

import mybatis.service.EmpMapper;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpControl {

    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/list")
    public String list(Model model){
        EmpVO[] ar = empMapper.list();

        model.addAttribute("ar", ar);
        return "list";
    }

    @PostMapping("/search")
    public ModelAndView search(String type, String value){
        ModelAndView mv = new ModelAndView();

        EmpVO[] ar = empMapper.search(type, value);

        mv.addObject("ar", ar);
        mv.setViewName("search");
        return mv;
    }
}
