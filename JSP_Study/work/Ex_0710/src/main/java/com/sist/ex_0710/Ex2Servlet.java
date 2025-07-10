package com.sist.ex_0710;

import mybatis.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Ex2")
public class Ex2Servlet extends HttpServlet {
    SqlSessionFactory factory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Reader r = Resources.getResourceAsReader("mybatis/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno_tx");

        response.setContentType("text/html;charset=UTF-8");
        SqlSession ss = factory.openSession();
        EmpVO vo = ss.selectOne("emp.getEcode", empno);

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
        ss.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
