<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  table{
    width: 600px;
    border-collapse: collapse;
  }
  table th, table td{
    border: 1px solid black;
  }
  table caption{
    text-indent: -9999px;
    height: 0;
  }
</style>
<body>
  <h1>JSTL연습</h1>
  <table>
    <thead>
  <caption>회원목록테이블</caption>
    <tr>
      <th>번호</th>
      <th>이름</th>
      <th>전화</th>
      <th>이메일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vo" items="${requestScope.list}" varStatus="vs">
    <tr>
      <td>${vs.index}</td>
      <td>${vo.name}</td>
      <td>${vo.phone}</td>
      <td>${vo.email}</td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</body>
</html>
