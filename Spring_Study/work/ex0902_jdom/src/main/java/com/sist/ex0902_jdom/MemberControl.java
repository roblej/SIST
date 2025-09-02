package com.sist.ex0902_jdom;

import data.vo.MemberVO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberControl {
    /*
        openAPI서비스의 url같은 경로가 멤버변수로 선언되어야 하지만
        우리는 내부에 있는 XML문서를 접근하여 마치 openAPI에서 결과를
        받는것 처럼 가정하자!
    */

    @Autowired
    private ServletContext application;

    @RequestMapping("t1")
    public ModelAndView t1() throws IOException, JDOMException {
        ModelAndView mv = new ModelAndView();

        String realPath = application.getRealPath("/resources/pm/data/member.xml");
        //JDOM파서를 이용하여 로드(파싱)하자!
        SAXBuilder builder = new SAXBuilder();
        //준비된 builder를 통해 결과인 xml자원을 문서화(Document)시킨다.
        Document doc = builder.build(realPath);

        //메모리상에 존재하는 xml문서(Document객체)의 루트를 얻어낸다.
        Element root = doc.getRootElement();
//        System.out.println("ROOT: "+root.getName());
        //루트의 자식들중 태그명이 member인 자식들 모두 가져와야함
        List<Element> list = root.getChildren("member");

        //위에서 얻은 list를 배열로 만들어보자!
        MemberVO[] ar = null;
        if (list != null && list.size() > 0) {
            ar = new MemberVO[list.size()];
            int i = 0;
            for (Element e : list) {
                MemberVO m = new MemberVO();
                m.setPhone(e.getChildText("phone"));
                m.setName(e.getChildText("name"));
                m.setEmail(e.getChildText("email"));
                ar[i] = m;
                i++;
            }
        }

        mv.addObject("ar", ar);
        mv.setViewName("member");
        return mv;
    }

    @PostMapping("/search")
    @ResponseBody
    public List<MemberVO> search(int searchType, String searchVal) throws IOException, JDOMException {
        String realPath = application.getRealPath("/resources/pm/data/member.xml");
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(realPath);
        Element root = doc.getRootElement();
        List<Element> list = root.getChildren("member");

        // 결과를 담을 ArrayList 생성
        List<MemberVO> resultList = new ArrayList<>();

        if (list != null && !list.isEmpty() && searchVal != null && !searchVal.trim().isEmpty()) {
            for (Element e : list) {
                String value = null;
                if(searchType == 0) {
                    value = e.getChildText("name");
                } else if(searchType == 1) {
                    value = e.getChildText("email");
                } else if(searchType == 2) {
                    value = e.getChildText("phone");
                }

                // 검색어가 포함되어 있는지 확인 (대소문자 무시)
                if (value != null && value.toLowerCase().contains(searchVal.toLowerCase())) {
                    MemberVO m = new MemberVO();
                    m.setName(e.getChildText("name"));
                    m.setEmail(e.getChildText("email"));
                    m.setPhone(e.getChildText("phone"));
                    resultList.add(m);
                }
            }
        }

        // JSON으로 변환될 List<MemberVO> 반환
        return resultList;
    }
}
