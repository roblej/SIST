<%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int num = Integer.parseInt(request.getParameter("s_num"));
%>
입력 값 : <%=num%><br/>
   <% for(int i=1;i<10;i++){ %>
<%=num%>*<%=i%> = <%=(num*i)%><br/>
<%
    }
%>
</body>
</html>
