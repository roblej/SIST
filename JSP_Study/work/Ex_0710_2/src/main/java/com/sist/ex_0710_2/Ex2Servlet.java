package com.sist.ex_0710_2;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Ex2")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청 시 한글 처리
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //파라미터 값
        String empno = request.getParameter("empno_tx");
        EmpVO vo = EmpDAO.getEmp(empno);

        StringBuffer sb = new StringBuffer();
        if(vo!=null) {
            sb.append("<ol>");
            sb.append("<li>");
            sb.append(vo.getEmpno());
            sb.append(",");
            sb.append(vo.getEname());
            sb.append(",");
            sb.append(vo.getJob());
            sb.append(",");
            sb.append(vo.getDeptno());
            sb.append("</li>");
            sb.append("</ol>");
        }
        //응답을 위한 스트림 생성
        PrintWriter out = response.getWriter();
        out.println("<h2>검색된 사원</h2>");
        out.println("<hr>");
        if(vo!=null) {
            out.println(sb.toString());
        }else {
            out.println("<h2>검색 결과가 없습니다.</h2>");
        }
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
