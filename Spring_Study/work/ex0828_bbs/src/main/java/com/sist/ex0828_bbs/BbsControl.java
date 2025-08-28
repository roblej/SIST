package com.sist.ex0828_bbs;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BbsControl {

    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpSession session;

    int numPerPage = 7; //한 페이지에 보여질 게시물 수
    int pagePerBlock = 5;//한 블럭당 5페이지씩 보여줌


    @RequestMapping("/bbs/list")
    public ModelAndView list(String bname, String cPage){
        //페이징 처리 ------------------------
        if(bname==null|| bname.equals("")) bname = "BBS";

        Paging page = new Paging(numPerPage,pagePerBlock);

        //총 페이지 수를 구하기 위해 총 게시물 수를 알아야함
        int totalCount = bbsDAO.getTotalCount(bname);

        //이제 총 페이지수 구하기
        page.setTotalCount(totalCount);
        if(cPage==null) cPage = "1";
        page.setNowPage(Integer.parseInt(cPage));
        //----------------------------------
        ModelAndView mv = new ModelAndView();
        BbsVO[] ar = bbsDAO.getList(bname,page.getBegin(),page.getEnd());
        mv.addObject("ar",ar);
        mv.addObject("page",page);
        mv.addObject("nowPage",page.getNowPage());
        mv.setViewName("/bbs/list");
        return mv;
    }

    @RequestMapping("bbs/view")
    public ModelAndView view(String b_idx,String cPage, String bname){
        ModelAndView mv = new ModelAndView();

        List<BbsVO> list = null;
        Object obj = session.getAttribute("r_list");
        if(obj!=null){ list = (List<BbsVO>) obj;}
        else{
            list = new ArrayList<BbsVO>();
            session.setAttribute("r_list",list);
        }
        //이제 list에서 인자로 받은 b_idx갑소가 같은 값을 가진 BbsVO를 list에서 검색한다.
        boolean check = false; // 이 false가 계속 유지된다면 찾지 못한 경우 - hit수가 증가
        for(BbsVO bvo : list){
            if(bvo.getB_idx().equals(b_idx)){
                check = true;
                break;
            }
        }//for의 끝
        //check의 값이 false라면 조회수 증가
        if(!check){
            bbsDAO.hit(b_idx);
        }
        BbsVO vo = bbsDAO.getView(b_idx);
        if(vo!=null){
            list.add(vo); // 다음에 같은 게시물을 클릭하면 조회수 증가를 하지 않는다.
        }

        mv.addObject("vo",vo);
        mv.setViewName("/bbs/view");
        return mv;
    }

    @RequestMapping("bbs/write")
    public ModelAndView write(String b_idx){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bbs/write");
        return mv;
    }

    @RequestMapping(value = "bbs/write", method = RequestMethod.POST)
    public String write(MultipartRequest multipartRequest, BbsVO vo){
        vo.setFile_name(String.valueOf(multipartRequest.getFileNames()));
        System.out.println(vo.getFile_name());
        System.out.println(vo.getBname());
        System.out.println(vo.getContent());
        System.out.println(vo.getWriter());

        return "redirect:/bbs/list";
    }
}
