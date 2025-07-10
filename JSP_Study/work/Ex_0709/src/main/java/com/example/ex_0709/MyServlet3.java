package com.example.ex_0709;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MyServlet3")
public class MyServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청 시 한글처리
        request.setCharacterEncoding("UTF-8");
        String[] names = request.getParameterValues("m_name");
        //응답을 위한 한글처리
        response.setContentType("text/html;charset=UTF-8");
        //응답을 스트림 생성
        PrintWriter out = response.getWriter();
        //응답 시작
        out.println("<h2>받은값:</h2>");
        out.println("<ul>");
        for(String s: names){
            out.println("<li>"+s+"</li>");
        }
        out.println("</ul>");
        out.close();
    }
}
