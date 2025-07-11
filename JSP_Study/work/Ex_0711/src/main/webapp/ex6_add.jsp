<%@ page import="mybatis.dao.EmpDAO" %><%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 14:29
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

    String empno = request.getParameter("empno");
    String ename = request.getParameter("ename");
    String job = request.getParameter("job");
    String hiredate = request.getParameter("hdate");
    String ip = request.getRemoteAddr(); // 접속자 아이피

    int cnt = EmpDAO.addEmp(empno, ename, job, hiredate);
    if (cnt > 0) {%>
alert("저장완료!");
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
