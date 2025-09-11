package com.sist.ex0911_secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.ex0911_secure.mapper.MemberMapper;
import com.sist.ex0911_secure.vo.MemVO;

@Service
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //회원가입
    public int regMember(MemVO vo){
        //reg.jsp에서 전달되는 m_id,m_pw,m_name등이 컨트롤러에서
        //vo를 받은것을 그대로 현재 메서드에 vo라는 인자로 넘어온다.
        //이중 비밀번호를 암호화하자!

        String pw = passwordEncoder.encode(vo.getM_pw());
        vo.setM_pw(pw);
        return mapper.reg(vo);
    }
    
    //로그인
    public MemVO login(MemVO vo){
        //DB로부터 vo에 있는 m_id를 보내어
        //해당 MemVO를 받아온다.
        MemVO mvo = mapper.login(vo.getM_id());
        //이 때 비밀번호가 일치하는지는 passwordEncoder에게 물어봐야한다.
        if(mvo != null){
            if(passwordEncoder.matches(vo.getM_pw(), mvo.getM_pw())){
                return mvo;
            }
        }
        return null;
    }

}
