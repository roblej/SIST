package com.sist.ex0901_bbs;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BbsControl {

    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletContext application;

    @Autowired
    private HttpSession session;

    int numPerPage = 7;
    int pageNumBlock = 5;

    private String upload_path = "/resources/bbs_upload/";

    //에디터에 주입된 이미자파일들이 저장될 곳
    private String editor_path = "/resources/editor_img/";


    @RequestMapping("/list")
    public ModelAndView list(String bname,String cPage) {
        ModelAndView mv = new ModelAndView();
        // 페이징 기법 --------------------------------
        if(bname==null)
            bname = "BBS";
        Paging page = new Paging(numPerPage,pageNumBlock);
        //                       게시물의 수, 블럭당 보여질 페이지 수

        int totalRecord = bbsDAO.getTotalCount(bname);
        page.setTotalCount(totalRecord);
        if(cPage == null) cPage = "1";
        page.setNowPage(Integer.parseInt(cPage));//begin,end,startPage,endPage 구해짐

        // ------------------------------------------
        // 뷰 페이지에서 표현할 게시물 목록 가져오기
        BbsVO[] ar = bbsDAO.getList(bname,page.getBegin(),page.getEnd());
        // 뷰 페이지에서 표현할 정보를 mv에 저장
        mv.addObject("ar",ar);
        mv.addObject("page",page);
        // 뷰 페이지 설정
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/write")
    public String write(){
        return "write";
    }

    @RequestMapping(value = "/write",method = RequestMethod.POST)
    public ModelAndView write(BbsVO vo){
        ModelAndView mv = new ModelAndView();
        MultipartFile f = vo.getUpload();
        if(f!=null&&f.getSize()>0){
            vo.setFile_name(f.getOriginalFilename());
        }
        bbsDAO.add(vo.getSubject(), vo.getWriter(), vo.getContent(),vo.getFile_name(),vo.getOri_name(),request.getRemoteAddr(),"BBS");
        mv.setViewName("redirect:/list");
        return mv;
    }

    @RequestMapping(value = "saveImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveImg(MultipartFile upload){
        //반환객체 준비
        Map<String,Object> map = new HashMap<>();

        // 파라미터로 들어온 이미지 파일이 있는지? 확인
        if(upload.getSize()>0){
            // 넘어온 이미지 파일이 있는 경우이므로 원하는 곳에 저장
            //절대경로가 필요함
            String realPath = application.getRealPath(editor_path);
            String fname = upload.getOriginalFilename();
            //파일을 저장하자
            try{
                upload.transferTo(new File(realPath,fname));
//                map.put("fname",fname);
                String c_path = request.getContextPath()+"/resources/editor_img/"+fname;
                map.put("img_url", c_path);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

    @RequestMapping("view")
    public ModelAndView view(String b_idx,String cPage) {
        ModelAndView mv = new ModelAndView();
        BbsVO vo = bbsDAO.getView(b_idx);
        mv.addObject("vo",vo);
        mv.addObject("cPage",cPage);
        mv.setViewName("view");

        return mv;
    }
}
