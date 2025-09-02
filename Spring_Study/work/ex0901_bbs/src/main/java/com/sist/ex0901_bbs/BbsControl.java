package com.sist.ex0901_bbs;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BbsControl {

    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

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
        System.out.println(bname+cPage);
        ModelAndView mv = new ModelAndView();
        // 페이징 기법 --------------------------------
        if(bname==null)
            bname = "BBS";
        Paging page = new Paging(numPerPage,pageNumBlock);
        //                       게시물의 수, 블럭당 보여질 페이지 수

        int totalRecord = bbsDAO.getTotalCount(bname);
        page.setTotalCount(totalRecord);
        if(cPage == null || cPage.isEmpty()) cPage = "1";
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

    @GetMapping("view")
    public ModelAndView view(String bname, String b_idx,String cPage) {
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
        BbsVO vo = bbsDAO.getView(b_idx);
        if(vo != null){
            //임 읽었던 게시불인지 확인
            boolean chk = false;
            for(BbsVO bbsVO : list){
                if(vo.getB_idx().equalsIgnoreCase(b_idx)){
                    chk = true;
                }
            }//for의 끝

            //chk가 ㄹalse를 유지하고 있다면 한번도 읽지 않은 게시물이고,
            //true로 변경되었따면 이전에 한번 읽었던 게시물이다.
            if(!chk){
                int hit = Integer.parseInt(vo.getHit());
                vo.setHit(String.valueOf(hit+1));
                bbsDAO.hit(b_idx);

                //세션에 read_list라는 이름으로 저장된 list를 vodㅔ 저장한다
                list.add(vo);
            }

            mv.addObject("vo",vo);
            mv.addObject("banme",bname);
            mv.addObject("cPage",cPage);
        }//if의 끝
        mv.setViewName("view");

        return mv;
    }

    @PostMapping("download")
    public ResponseEntity<Resource> download(String f_name){
        //파일들이 저장되어 있는 곳
        String realPath = application.getRealPath(upload_path+f_name);
        File f = new File(realPath);
        if(!f.exists()){
            byte[] buf = new byte[4096];
            int size = -1;

            //파일을 다운로드에 필요한 스트림 준비
            BufferedInputStream bis = null;
            FileInputStream fis = null;

            BufferedOutputStream bos = null;
            ServletOutputStream sos = null; // 응답을 하는 것이 접속자의
            //컴퓨터로 다운로드르르 시켜야 하기 때문에 ㄱㄷsponse를 통해
            //outputStream을 얻어내야 응답으로 다운로드가 되는것이다.
            //그래서 ㄱesponse로 얻어내는 스트림이 ServletOutputStream이므로 sos를 선언

            try{
                //접속자 화면에 다운로드 창 보여주기
                response.setContentType("application/x-msdownload");
                response.setHeader("Content-Disposition", "attachment; filename="+new String(f_name.getBytes(),"8859_1"));
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);

                //response를 통해 다운로드할 스트림을 얻어낸다.
                sos = response.getOutputStream();
                bos = new BufferedOutputStream(sos);

                while((size = bis.read(buf))!=-1){
                    bos.write(buf,0,size);
                    bos.flush();
                }//while문의 끝
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                if(fis!=null)
                    fis.close();
                if(bis!=null)
                    bis.close();
                if(sos!=null)
                    sos.close();
                if(bos!=null)
                    bos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
}
