<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
<h2>이름 : ${param.u_name}</h2>
<h2>전화번호 : ${param.u_phone}</h2>

<%-- for(String str : ar) --%>
<c:forEach items="${paramValues.u_phone}" var="item">
    <h3>${item}</h3>
</c:forEach>
</body>
</html>
