<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 15.
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  LocalDate now = LocalDate.now();
%>
<jsp:forward page="ex1_1.jsp">
  <jsp:param name="now" value="<%=now.toString()%>"/>
</jsp:forward>
</body>
</html>
