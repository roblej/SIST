<%@ page import="mybatis.dao.MemoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <%
    request.setCharacterEncoding("utf-8");

    String writer = request.getParameter("writer");
    String content = request.getParameter("content");

    String ip = request.getRemoteAddr(); // 접속자 아이피

    int cnt = MemoDAO.Add(writer,content,ip);

    response.sendRedirect("memoList.jsp?cmd="+cnt);
  %>


