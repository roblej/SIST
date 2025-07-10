package com.sist.ex_0710_2;

import mybatis.dao.EmpDAO;
import mybatis.vo.MemVO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Ex5")
public class Ex5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mId = request.getParameter("id_tx");
        String mPw = request.getParameter("pw_tx");
        MemVO mvo = EmpDAO.login(mId, mPw);
        if(mvo != null){
            HttpSession session = request.getSession();
            session.setAttribute("mvo",mvo);

            //페이지 이동
            response.sendRedirect("/ex1_emp.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
