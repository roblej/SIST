<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="java.util.List" %>
<%@ page import="mybatis.dao.EmpDAO" %><%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>전체 사원</h1>
<hr/>
    <% List<EmpVO> list = EmpDAO.getAll(); %>
<ul>
    <% for(EmpVO vo : list){ %>
            <li><%=vo.getEmpno()%>,<%=vo.getEname()%></li>
    <%}%>
</ul>
</body>
</html>
