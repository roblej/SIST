<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>페이지2</h1>
<%--request에 v1이라고 저장한 값을 출력--%>
<%--<h2>${requestScope.v1}</h2>--%>

<h2>${v1}</h2>

<%--<%String v1 = (String)request.getAttribute("v1");%>--%>
<%--<h2><%=v1%></h2>--%>
</body>
</html>
