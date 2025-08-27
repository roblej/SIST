package com.sist.ex1;

import ex1.vo.Test3VO;
import ex1.vo.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAction2 {

    private TestVO t1;

    public TestVO getT1() {
        return t1;
    }

    public void setT1(TestVO t1) {
        this.t1 = t1;
    }

    @RequestMapping("/ttt")
    public ModelAndView ex4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ex5");
        mv.addObject("t1",t1);
        return mv;
    }


}
