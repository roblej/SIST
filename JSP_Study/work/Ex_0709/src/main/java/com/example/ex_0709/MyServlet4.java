package com.example.ex_0709;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MyServlet4")
public class MyServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 한글로
        request.setCharacterEncoding("UTF-8");

        String mId = request.getParameter("m_id");
        String mPw = request.getParameter("m_pw");
        String[] mPhone = request.getParameterValues("m_phone");
        String[] mHobby = request.getParameterValues("m_hb");

        /*  ========== 기존 로직 시작 ==========
        //반환 한글로
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("반환");
        out.println("<ul>");
        out.println("<li>"+mId+"</li>");
        out.println("<li>"+mPw+"</li>");
        out.print("<li>");
        for(int i=0;i<mPhone.length;i++){
            out.print(mPhone[i]);
            if(i!=mPhone.length-1){
            out.print("-");
            }
        }
        out.print("</li>");
        out.print("<li>");
        for(String str : mHobby){
            out.print(str+" ");
        }
        out.print("</li>");
        ========== 기존 로직 끝 ========== */

        // 개선된 로직
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String phoneString = String.join("-", mPhone);
        String hobbyString = String.join(" ", mHobby);

        java.util.List<String> items = new java.util.ArrayList<>();
        items.add(mId);
        items.add(mPw);
        items.add(phoneString);
        items.add(hobbyString);

        out.println("반환");
        out.println("<ul>");
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");

    }
}
