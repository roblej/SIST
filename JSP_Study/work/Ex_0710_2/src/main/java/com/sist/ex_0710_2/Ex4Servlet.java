package com.sist.ex_0710_2;

import mybatis.vo.MemVO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Ex4")
public class Ex4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //응답시 한글처리
        response.setContentType("text/html;charset=UTF-8");
        //응답을 위한 스트림 준비
        PrintWriter out = response.getWriter();
        //로그인 여부 확인! HttpSession관리
        //로그인 체크를 화기위해 요청객체로부터 세션정보를 얻어낸다.
        HttpSession session = request.getSession();

        //로그인을 했는지? 알아내기 위해 얻어낸 세션으로부 값을 하나 검색한다.
        //이름이 "mvo"인 객체를 얻어낸다
        Object obj = session.getAttribute("mvo");
        if(obj == null){
            //로그인이 안된 경우
            response.sendRedirect("/ex1_emp.html");
        }else{
            //로그인이 된 경우
            MemVO mvo = (MemVO) obj;
            out.println("<h2>"+mvo.getM_name()+"님 환영합니다</h2>");
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
