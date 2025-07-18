<%@ page import="mybatis.vo.EmpVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<style>
  .table {
    width: 600px;
    border-collapse: collapse;
  }

  .table th, .table td {
    border: 1px solid black;
    padding: 5px;
  }

  .table caption {
    text-indent: -9999px;
    height: 0;
  }

  .txt_R {
    text-align: right;
  }

  .noBorder {
    border: none !important;
  }
</style>
<body>
<div id="wrap">
  <header>
    <h1>사원목록</h1>
  </header>
  <article>
    <table class="table">
      <caption>사원목록</caption>
      <thead>
      <tr>
        <td colspan="6" class="txt_R noBorder">
          <button type="button" id="total_btn">전체보기</button>
          <button type="button" id="search_btn">검색</button>
          <button type="button" id="add_btn">추가</button>
            <button type="button" id="dept_btn">부서목록</button>
        </td>
      </tr>
      <tr>
        <th>사번</th>
        <th>이름</th>
        <th>직종</th>
        <th>급여</th>
        <th>입사일</th>
        <th>부서코드</th>
      </tr>
      </thead>
      <tbody>
      <%
//        EmpVO[] list = (EmpVO[]) request.getAttribute("ar");
        Object obj = request.getAttribute("ar");
        if(obj != null) {
          EmpVO[] ar = (EmpVO[]) obj;
          for (EmpVO vo : ar) {
      %>
      <tr>
        <td><%=vo.getEmpno()%></td>
        <td><%=vo.getEname()%></td>
        <td><%=vo.getJob()%></td>
        <td><%=vo.getSal()%></td>
        <td><%=vo.getHiredate()%></td>
        <td><%=vo.getDeptno()%></td>
      </tr>
      <%
        }
      }else{
          %>
      <tr>
      <td colspan="6">현재 등록된 정보가 없습니다</td>
      </tr>
      <%
          }
      %>
      </tbody>

    </table>
  </article>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  $("#add_btn").click(function () {
    location.href = "controller?type=add"
  })
  $("#total_btn").click(function () {
    location.href = "controller?type=total"
  })
  $("#dept_btn").click(function () {
      location.href = "controller?type=dept"
  })
</script>
</body>
</html>