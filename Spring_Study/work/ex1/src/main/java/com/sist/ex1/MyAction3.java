package com.sist.ex1;

import ex1.vo.DataVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAction3 {


    @RequestMapping("/ex6")
    public ModelAndView ex3() {
        ModelAndView mv = new ModelAndView("ex6");
        DataVO[] ar = new DataVO[3];
        ar[0] = new DataVO();
        ar[0].setName("일지매");
        ar[0].setPhone("010-1111-2222");

        ar[1] = new DataVO();
        ar[1].setName("마루치");
        ar[1].setPhone("010-2222-3333");

        ar[2] = new DataVO();
        ar[2].setName("금씨");
        ar[2].setPhone("010-3333-4444");

        mv.addObject("ar", ar);
        return mv;
    }
}
