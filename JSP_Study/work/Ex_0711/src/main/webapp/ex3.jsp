<%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("s_id");
    String pw = request.getParameter("s_pw");
%>
<h2>아이디 : <%=id%></h2>
<h2>비밀번호 : <%=pw%></h2>
<%--다른 지역에서 왜 지역변수를 사용할 수 있나? 선언문을 제외하고 출력문과 스크립트릿은 같은 지역임.--%>
</body>

</html>
