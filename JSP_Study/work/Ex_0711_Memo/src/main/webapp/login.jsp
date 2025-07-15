<%@ page import="mybatis.vo.MemVO" %>

<%@ page import="mybatis.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    String mId = request.getParameter("u_id");
    String mPw = request.getParameter("u_pw");
    if(mId != null && mPw != null) {
      MemVO mvo = MemberDAO.login(mId, mPw);
      int mode = 0;
      if (mvo != null) {
        session.setAttribute("mvo", mvo);
        mode = 1;
      }
      response.sendRedirect("index.jsp?mode=" + mode);
    }else response.sendRedirect("index.jsp");
%>
