<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="mybatis.vo.DeptVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    #table{
      width: 600px;
      border-collapse: collapse;
    }
    #table th, #table td{
      border: 1px solid black;
      padding: 5px;
    }
  </style>
</head>
<body>
<div id="wrap">
  <header><h2>부서정보</h2></header>
  <article>
    <table id="table">
      <caption>부서정보</caption>
      <thead>
      <tr>
        <th>부서코드</th>
        <th>부서명</th>
        <th>지역코드</th>
      </tr>
      </thead>
      <tbody>
      <%
        Object obj = request.getAttribute("dept");
        DeptVO[] ar = null;
        if(obj !=null){
          ar = (DeptVO[]) obj;
          for(DeptVO vo : ar){
      %>
      <tr>
        <td><%=vo.getDeptno()%></td>
        <td><%=vo.getDname()%></td>
        <td><%=vo.getLoc_code()%></td>
      </tr>
      <%
          }
        }
      %>
      </tbody>
    </table>
  </article>
</div>
</body>
</html>
