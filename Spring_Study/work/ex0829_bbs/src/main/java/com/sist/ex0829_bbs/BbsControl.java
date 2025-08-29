package com.sist.ex0829_bbs;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BbsControl {

    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletContext application;

    @RequestMapping("/list")
    public ModelAndView list(String cPage, String bname) {
        if (bname == null || bname.equals("")) bname = "BBS";
        Paging p = new Paging(5, 5);

        int totalCount = bbsDAO.getTotalCount(bname);

        p.setTotalCount(totalCount);
        if (cPage == null) cPage = "1";
        p.setNowPage(Integer.parseInt(cPage));

        ModelAndView mv = new ModelAndView();
        BbsVO[] ar = bbsDAO.getList(bname, p.getBegin(), p.getEnd());
        mv.addObject("ar", ar);
        mv.addObject("page", p);
        mv.addObject("nowPage", p.getNowPage());
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("view")
    public ModelAndView view(String b_idx,String cPage) {
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
        mv.addObject("vo", vo);
        mv.addObject("cPage", cPage);
        mv.setViewName("view");
        return mv;
    }

    @RequestMapping("write")
    public ModelAndView write(String cPage) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cpage",cPage);
        mv.setViewName("write");
        return mv;
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public ModelAndView write(BbsVO vo) {
        ModelAndView mv = new ModelAndView();

        String c_type = request.getContentType();
        if(c_type.startsWith("multipart")){
            //파일 첨부됨
            MultipartFile f = vo.getFile();
            if(f.getSize()>0){
                //파일이 존재하면 원하는곳에 저장
                String realPath = application.getRealPath("/resources/bbs_upload");
                String fname = f.getOriginalFilename();
                try{
                    f.transferTo(new File(realPath,fname));
                    //DB에 저장할 수 있도록 파일명을 vo에 저장해야함
                    vo.setFile_name(fname);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
                vo.setIp(request.getRemoteAddr());

                bbsDAO.add(vo);

        }
        mv.addObject("vo", vo);
        mv.setViewName("redirect:/list");
        return mv;
    }
}
