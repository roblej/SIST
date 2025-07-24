<%@ page import="ex9.vo.TestVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  TestVO t1 = new TestVO("마루차","010","ten@korea.com");
  TestVO t2 = new TestVO("아라","011","ten2@korea.com");
  TestVO t3 = new TestVO("이도","012","ten3@korea.com");
  List<TestVO> list = new ArrayList<>();
  list.add(t1);
  list.add(t2);
  list.add(t3);
  request.setAttribute("list",list);
%>
  <jsp:forward page="ex9_for.jsp"/>
</body>
</html>
