package com.sist.ex0911_secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sist.ex0911_secure.service.MemberService;
import com.sist.ex0911_secure.vo.MemVO;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class MemberController {
    //db활용을 위해 service객체 준비
    @Autowired
    private MemberService mService;

    //로그인 처리를 위한 세션 준비
    @Autowired
    private HttpSession session;
    
    @RequestMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/reg")
    public ModelAndView reg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reg");
        return mv;
    }
    @PostMapping("/reg")
    public ModelAndView reg(MemVO vo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        //서비스를 이용하여 회원등록
        int cnt = mService.regMember(vo);
        //기본키를 저장할 때 바로 어덩내는 방법은
        //맵퍼<insert....>에 다음의 속성을 지정한다. useGeneratedKeys="true" keyProperty="m_idx"
        System.out.println("멤버기본키:"+vo.getM_idx());
        
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/reqLogin")
    public ModelAndView reqLogin(MemVO vo) {
        ModelAndView mv = new ModelAndView("redirect:/");
        MemVO mvo = mService.login(vo);
        if(mvo != null){
            //로그인 성공
            session.setAttribute("mvo", mvo);
        }else{
            mv.addObject("status", "1");

            
        }
        
        return mv;
    }
    
    
}
