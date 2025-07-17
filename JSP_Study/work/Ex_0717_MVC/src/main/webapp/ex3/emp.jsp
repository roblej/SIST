<%@ page import="mybatis.vo.EmpVO" %>
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
  <header><h2>사원목록</h2></header>
  <article>
    <table id="table">
      <caption>사원목록</caption>
      <thead>
      <tr>
        <th>사번</th>
        <th>이름</th>
        <th>직종</th>
        <th>부서코드</th>
      </tr>
      </thead>
      <tbody>
      <%
        Object obj = request.getAttribute("emp");
        EmpVO[] ar = null;
        if(obj !=null){
          ar = (EmpVO[]) obj;
          for(EmpVO vo : ar){
            %>
      <tr>
      <td><%=vo.getEmpno()%></td>
      <td><%=vo.getEname()%></td>
      <td><%=vo.getJob()%></td>
      <td><%=vo.getDeptno()%></td>
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
