package com.sist.ex0908_bbs.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletResponse response;

    private int numPerPage = 7; // 한 페이지당 보여질 게시물 수
    private int pagePerBlock = 5;

    BbsController(CommService commService, DbConfig dbConfig, Ex0908BbsApplication ex0908BbsApplication, SqlSessionFactory getFactory, SqlSessionTemplate getTemplate) {
        this.commService = commService;
        this.dbConfig = dbConfig;
        this.ex0908BbsApplication = ex0908BbsApplication;
        this.getFactory = getFactory;
        this.getTemplate = getTemplate;
    } // 한 블럭당 표현할 페이지 수

    @RequestMapping("/list")
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
    public ModelAndView write(BbsVO vo) {
        ModelAndView mv = new ModelAndView();
        if(vo.getFile() != null){
            MultipartFile f = vo.getFile();
            String oname = f.getOriginalFilename();

            // 파일명이 비어있지 않을 때만 처리
            if(oname != null && !oname.isEmpty()){
                String realPath = application.getRealPath(bbs_upload);
                String fname = FileRenameUtil.CheckSameFileName(oname, realPath);

                try{
                    f.transferTo(new File(realPath, fname));
                }catch(Exception e){
                    e.printStackTrace();
                }

                vo.setOri_name(oname);
                vo.setFile_name(fname);
            }
        }

        String ip = request.getRemoteAddr();
        vo.setIp(ip);

        bbsservice.add(vo);

        mv.setViewName("redirect:/list?bname=" + vo.getBname() + "&cPage=1");
        return mv;
    }
    //게시물 보기 기능
    @GetMapping("/view")
    public ModelAndView getView(String bname, String cPage, String b_idx) {
        ModelAndView mv = new ModelAndView();
//세션에 read_list라는 이름으로 저장된 객체를 언덩낸다.
        Object obj = session.getAttribute("read_list");
        ArrayList<BbsVO> list = null;

        //obj가 null이 아니면 obj를 현변환해서 list에 저장하자
        if(obj!=null){
            list = (ArrayList<BbsVO>)obj;
        }else{
            list = new ArrayList<>();
            session.setAttribute("read_list",list);
        }
        BbsVO vo = bbsservice.getBbs(b_idx);
        if(vo != null){
            //임 읽었던 게시불인지 확인
            boolean chk = false;
            for(BbsVO bbsVO : list){
                if(bbsVO.getB_idx().equalsIgnoreCase(b_idx)){
                    chk = true;
                }
            }//for의 끝

            //chk가 ㄹalse를 유지하고 있다면 한번도 읽지 않은 게시물이고,
            //true로 변경되었따면 이전에 한번 읽었던 게시물이다.
            if(!chk){
                int hit = Integer.parseInt(vo.getHit());
                vo.setHit(String.valueOf(hit+1));
                bbsservice.hit(b_idx);

                //세션에 read_list라는 이름으로 저장된 list를 vodㅔ 저장한다
                list.add(vo);
            }

            mv.addObject("vo",vo);
            mv.addObject("bname",bname);
            mv.addObject("cPage",cPage);
        }//if의 끝
        mv.setViewName(bname+"/view");

        return mv;
    }
    
    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam String bname, String b_idx, String cPage, BbsVO vo) {
        ModelAndView mv = new ModelAndView();

        if(request.getContentType().toLowerCase().startsWith("multipart/")){
            MultipartFile f = vo.getFile();
            if(f != null && f.getSize() > 0){
                String oname = f.getOriginalFilename();
                if(oname != null && !oname.isEmpty()){
                    String realPath = application.getRealPath(bbs_upload);
                    String fname = FileRenameUtil.CheckSameFileName(oname, realPath);

                    try{
                        f.transferTo(new File(realPath, fname));
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    vo.setOri_name(oname);
                    vo.setFile_name(fname);
                }
            }

            String ip = request.getRemoteAddr();
            vo.setIp(ip);

            int n = bbsservice.edit(vo);
            System.out.println(n);

            mv.setViewName("redirect:/list?bname=" + vo.getBname() + "&cPage=1");
        }else{
            vo = bbsservice.getBbs(b_idx);

            mv.addObject("bname", bname);
            mv.addObject("cPage", cPage);
            mv.addObject("vo", vo);

            mv.setViewName(bname+"/edit");
        }
        return mv;
    }
    @PostMapping("/download")
    public void downloadFile(@RequestParam String f_name) {
        if(f_name != null && !f_name.equals("")) {
            String realPath = application.getRealPath(bbs_upload);
            File f = new File(realPath, f_name);
            if (f.exists()) {
                try (
                    FileInputStream fis = new FileInputStream(f);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ServletOutputStream sos = response.getOutputStream();
                    BufferedOutputStream bos = new BufferedOutputStream(sos)
                ) {
                    // 이미지 파일의 Content-Type 지정 (예시: png, jpg 등)
                    response.setContentType("application/x-msdownload");
                    response.setHeader("Content-Disposition",
                            "attachment;filename=" + new String(f_name.getBytes(), "8859_1"));

                    byte[] buf = new byte[2048];
                    int size;
                    while ((size = bis.read(buf)) != -1) {
                        bos.write(buf, 0, size);
                    }
                    bos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
