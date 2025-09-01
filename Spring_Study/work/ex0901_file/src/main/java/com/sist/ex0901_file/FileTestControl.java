package com.sist.ex0901_file;

import file.input.ParamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileTestControl {

    //파일첨부에  필요한 멤버변수들

    @Autowired
    private ServletContext application;

    @Autowired
    private HttpServletRequest request;


    //파일이 저장될 위치 - ~webap/resources/file_upload라는 폴더로 지정
    //위치지정에 앞서 dispatcher-servlet.xml에서 webap/resources/file_upload를 등록해야함
    private String upload_path  = "/resources/file_upload";

    @RequestMapping("/write")
    public String write() {
        return "write";
    }
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public ModelAndView write(ParamVO pvo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/write");

        MultipartFile f = pvo.getS_file();

        //파일이 저장될 위치를 절대경로화 한다.
        String real_path = application.getRealPath(upload_path);
        String fname = null;
        if(f.getSize() > 0) {
            fname = f.getOriginalFilename();
            pvo.setFile_name(fname);
//            pvo.setIp(request.getRemoteAddr());
            try{
                //파일 업로드가 일어나는곳
                f.transferTo(new File(real_path,fname));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
//        paramDAO.add(pvo);

        return mv;
    }
}
