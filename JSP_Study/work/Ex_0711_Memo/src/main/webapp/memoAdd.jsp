<%@ page import="mybatis.dao.MemoDAO" %><%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<script>
  <%
      request.setCharacterEncoding("utf-8");

      String writer = request.getParameter("writer");
      String content = request.getParameter("content");

      String ip = request.getRemoteAddr(); // 접속자 아이피

      int cnt = MemoDAO.Add(writer,content,ip);
      if (cnt > 0) {%>
  // alert("저장완료!");
location.href="memoList.jsp"
  <%
  } else {
  %>
  alert("저장실패");
  <%
      }
  %>
</script>
</body>
</html>

