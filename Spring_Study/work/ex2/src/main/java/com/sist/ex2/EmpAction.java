package com.sist.ex2;

import mybatis.DAO.empDAO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpAction {
    @Autowired
    private empDAO empDAO;

    @RequestMapping("emp")
    public ModelAndView emp(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("list");
        EmpVO[] ar = empDAO.getTotal();
        mv.addObject("ar",ar);

        return mv;
    }
}
