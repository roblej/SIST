<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>JSP 첫 예제</h2>
<hr/>
<h3>1.스크립트 요소</h3>
<ol>
  <li>선언문:</li>
  <li>출력문:</li>
  <li>스크립트 릿:</li>
</ol>
<p>스크립트 요소는 각 문들이 겹쳐서 사용할 수 없다.</p>
<%!// 선언문 정의 ------------------자바영역
  String msg = "쌍용교육센터"; // 멤버변수
  int value = 10000;

  public String test(){
    LocalDate now = LocalDate.now();
    return msg+":"+now.toString();
  };
%>
<h1><%=msg%>,<%=value%></h1>
<h1><%=test()%></h1>

</body>
</html>
