package com.sist.ex0829_json;

import mybatis.dao.DataDAO;
import mybatis.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.input.ImgVO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class JsonControl {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletContext application;

    @Autowired
    private DataDAO dataDAO;

    private String editor_img = "/resources/editor_img/";

    @RequestMapping("test1")
    public ModelAndView test1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ex1");
        return modelAndView;
    }

    @RequestMapping("test2")
    public String test2(){


        return "ex2";
    }
    @RequestMapping(value = "test3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> test3(){
        Map<String,String> map = new HashMap<>();
        map.put("name","마루치");
        map.put("email","test@naver.com");
        return map;
    }

    @RequestMapping("/editor")
    public String editor(){

        return "editor";
    }

    @RequestMapping(value = "saveImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveImg(ImgVO VO){
            //json처리가 용이한 map구조를 미리 선언
        Map<String, Object> map = new HashMap<>();

        //전달되ㅓ 오는 이미지파일은 vo라는 인자에 저장되어있다/
        MultipartFile f = VO.getUpload();
        if(f.getSize() > 0){
            //넘어온 파일이 있는 경우
            //파일을 저장할 위치(editor_img)를 절대경로화 시킨다.
            String realPath = application.getRealPath(editor_img);
            // 저장할 위치를 준비했으니 파일을 저장하자!
            try{
                f.transferTo(new File(realPath,f.getOriginalFilename()));
                map.put("fname",f.getOriginalFilename());
            }catch (Exception e){
                e.printStackTrace();
            }

            //현재 파일이 저장된 서버경로(url)를 문자열로 만들자
            // ex) localhost:8080/resources/editor_img/...
            String c_path = request.getContextPath(); // localhost:8080/
            map.put("url",c_path+editor_img);

        }
        return map;
        //JSON으로 보내기 위해 현재 메서드 위에 @ResponseBody 를 지정했다,
        // {"fname" : "test.gif","url":"localhost:8080/resources/editor_img/"}
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView write(DataVO vo){
        ModelAndView mv = new ModelAndView();
        //폼에 enctype이 milipart로 시작한다면
        String c_type = request.getContentType();
        if(c_type.startsWith("multipart")){
            //파일첨부됨
            MultipartFile f= vo.getSss();
            String fname = null;
            if(f.getSize() > 0){
                //첨부된 파일을 원하는 위치에 저장
                String realPath = application.getRealPath("resources/upload");
                fname=f.getOriginalFilename();
                try{
                    f.transferTo(new File(realPath,fname));
                    //DB에 저장할 수 있도록 파일명을 vo에 저장해야한다.
                    vo.setFile_name(fname);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
                vo.setIp(request.getRemoteAddr());

                dataDAO.add(vo);
        }
        mv.setViewName("redirect:/editor");
        return mv;
    }
}
