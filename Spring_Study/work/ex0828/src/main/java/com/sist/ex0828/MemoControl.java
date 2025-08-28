package com.sist.ex0828;

import mybatis.dao.MemoDAO;
import mybatis.vo.MemoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemoControl {
    @Autowired
    private MemoDAO memoDAO;

    

    @RequestMapping("/memo/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        MemoVO[] ar = memoDAO.getTotal();
        mv.addObject("ar",ar);

        //뷰페이지 경로 지정
        mv.setViewName("memo/memoList");
        //web-inf/jsp/memo/list.jsp
        return mv;
    }

    @RequestMapping(value = "/memo/add", method = RequestMethod.POST)
    public ModelAndView add(MemoVO vo, HttpServletRequest request){

        vo.setIp(request.getRemoteAddr());

        memoDAO.add(vo);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/memo/list");
        return mv;
    }
}
