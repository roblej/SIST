package com.sist.ex0908_bbs.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.sist.ex0908_bbs.Ex0908BbsApplication;
import com.sist.ex0908_bbs.config.DbConfig;
import com.sist.ex0908_bbs.service.BbsService;
import com.sist.ex0908_bbs.service.CommService;
import com.sist.ex0908_bbs.util.FileRenameUtil;
import com.sist.ex0908_bbs.util.Paging;
import com.sist.ex0908_bbs.vo.BbsVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BbsController {

    private final SqlSessionTemplate getTemplate;

    private final SqlSessionFactory getFactory;

    private final Ex0908BbsApplication ex0908BbsApplication;

    private final DbConfig dbConfig;

    private final CommService commService;

    @Autowired
    private BbsService bbsservice;

    @Autowired
    private ServletContext application;

    @Value("${server.editor.path}")
    private String editor_img;

    @Value("${server.upload.path}")
    private String bbs_upload;

    @Autowired
    private HttpServletRequest request;

    private int numPerPage = 7; // 한 페이지당 보여질 게시물 수
    private int pagePerBlock = 5;

    BbsController(CommService commService, DbConfig dbConfig, Ex0908BbsApplication ex0908BbsApplication, SqlSessionFactory getFactory, SqlSessionTemplate getTemplate) {
        this.commService = commService;
        this.dbConfig = dbConfig;
        this.ex0908BbsApplication = ex0908BbsApplication;
        this.getFactory = getFactory;
        this.getTemplate = getTemplate;
    } // 한 블럭당 표현할 페이지 수

    @GetMapping("/list")
    public ModelAndView getBbsList(@RequestParam String bname,String cPage){
        ModelAndView mv = new ModelAndView();
        mv.setViewName(bname+"/list");

        int nowPage = 1;

        if(cPage!=null&&!cPage.equals("")){
            nowPage = Integer.parseInt(cPage);
        }
        
        if(bname==null||bname.equals("")){
            bname="BBS";
        }

        //페이징객체 생성
        Paging paging = new Paging(nowPage, bbsservice.totalCount(bname), numPerPage, pagePerBlock, bname);

        int total = bbsservice.totalCount(bname);
        BbsVO[] ar = bbsservice.getBbsList(bname, paging.getBegin(), paging.getEnd());

        mv.addObject("total", total);
        mv.addObject("bname", bname);
        mv.addObject("ar", ar);
        mv.addObject("page", paging);
        mv.addObject("pageResult", paging.getPagingHTML());

        return mv;
    }

    @GetMapping("/writeForm")
    public ModelAndView getWriteForm(@RequestParam String bname, @RequestParam String cPage) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(bname+"/write");
        mv.addObject("bname", bname);
        mv.addObject("cPage", cPage);
        return mv;
    }

    @PostMapping("/saveImg")
    public Map<String,Object> saveImg(MultipartFile upload) {
        //반환형 준비
        Map<String,Object> entity = new HashMap<>();
        //첨부파일이 전달되어왔다면 
        if(upload.getSize() > 0){
            //파일을 저장할 위치를 절대경로화 시킨다.
            String realPath = application.getRealPath(editor_img);

            //파일명을 얻어낸다.
            String oname = upload.getOriginalFilename();

            //동일한 파일명이 있을때만 파일명을 변경하자!
            String fname = FileRenameUtil.CheckSameFileName(oname, realPath);
            try{
                upload.transferTo(new File(realPath,fname));//파일저장getFactory
            }catch (Exception e){
                e.printStackTrace();
            }
            //업로드된 파일의 전체경로(파일명이 포함된 경로)를 map에 담자!
            String url_path = request.getContextPath();//localhost:8080/ 까지만 나옴

            //JSON형식으로 반환하기 위해 map에 저장
            entity.put("img_url", url_path+editor_img+fname);
        }
        return entity;
    }
    
    @PostMapping("/write")
    public ModelAndView postMethodName(BbsVO vo) {
        //TODO: process POST request
        ModelAndView mv = new ModelAndView();
        MultipartFile f = vo.getFile();

        String realPath = application.getRealPath(bbs_upload);

        //파일명을 얻어낸다.
        String oname = f.getOriginalFilename();
        vo.setOri_name(oname);

        //동일한 파일명이 있을때만 파일명을 변경하자!
        String fname = FileRenameUtil.CheckSameFileName(oname, realPath);
        vo.setFile_name(fname);

        //아이피주소 저장
        String ip = request.getRemoteAddr();
        vo.setIp(ip);

        bbsservice.add(vo);

        mv.setViewName("redirect:/list?bname=" + vo.getBname() + "&cPage=1");
        return mv;
    }
    
    
}
