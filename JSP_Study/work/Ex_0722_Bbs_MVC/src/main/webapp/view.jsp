<%@ page import="mybatis.vo.BbsVO" %>
<%@ page import="mybatis.vo.CommVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
  <style type="text/css">
    #bbs table {
      width:580px;
      margin-left:10px;
      border:1px solid black;
      border-collapse:collapse;
      font-size:14px;

    }

    #bbs table caption {
      font-size:20px;
      font-weight:bold;
      margin-bottom:10px;
    }

    #bbs table th {
      text-align:center;
      border:1px solid black;
      padding:4px 10px;
      width: 100px;
    }

    #bbs table td {
      text-align:left;
      border:1px solid black;
      padding:4px 10px;
    }

    .no {width:15%}
    .subject {width:30%}
    .writer {width:20%}
    .reg {width:20%}
    .hit {width:15%}
    .title{background:lightsteelblue}

    .odd {background:silver}
    .hide{display: none}

  </style>

</head>
<body>
<%
    Object obj = request.getAttribute("vo");
    if(obj!=null){
        BbsVO vo = (BbsVO) obj;


%>
<div id="bbs">
  <form method="post" >
    <table summary="게시판 글쓰기">
      <caption>게시판 글쓰기</caption>

      <tbody>
      <tr>
        <th>제목</th>
        <td>${vo.subject}</td>
      </tr>

      <tr>
        <th>첨부파일</th>
        <td>
          <% if(vo.getFile_name() == null){%>
          첨부파일없음
          <%}else{%>
          <a href="#">
          <%=vo.getFile_name()%>
        </a>
          <%}%>
        </td>
      </tr>

      <tr>
        <th>이름</th>
        <td><%=vo.getWriter()%></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><%=vo.getContent()%></td>
      </tr>

      <tr>
        <td colspan="2">
          <input type="button" value="수정" onclick="goRewrite()"/>
<%--          <input type="button" value="수정" onclick="javascript:href='Controller?type=rewrite'"/>--%>
          <input type="button" value="삭제" onclick="godel()"/>
<%--          <input type="button" value="목록" onclick="javascript:location.href='Controller?type=list&cPage=<%=request.getParameter("cPage")%>'"/> get방식--%>
            <input type="button" value="목록" onclick="goList()"/> <!-- 포스트 -->
        </td>
      </tr>
      </tbody>

    </table>
    <br/>
  </form>
    <form name="ff" method="post">
        <input type="hidden" name="type"/>
        <input type="hidden" name="b_idx" value="<%=vo.getB_idx()%>"/>
        <input type="hidden" name="cPage" value="${param.cPage}"/>

    </form>

  <form method="post" action="Controller">
    이름:<input type="text" name="writer"/><br/>
    내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
    비밀번호:<input type="password" name="pwd"/><br/>


    <input type="hidden" name="b_idx" value="<%=vo.getB_idx()%>">
    <input type="hidden" name="cPage" value="${param.cPage}"/>
    <input type="hidden" name="type" value="commadd"/>
    <input type="submit" value="저장하기"/>
  </form>
<%--삭제시 뜨는 팝업--%>
    <div id="del_dialog" title="삭제" class="hide">
        <form action="Controller" method="post">
        <p>정말로 삭제하시겠습니까?</p>
            <input type="hidden" name="type" value="delete"/>
            <input type="hidden" name="b_idx" value="<%=vo.getB_idx()%>">
            <input type="hidden" name="cPage" value="${param.cPage}"/>
            <button type="button" onclick="del(this.form)">삭제</button>
        </form>
    </div>
  댓글들<hr/>
<%
    for(CommVO cvo : vo.getC_list()){
%>
  <div>
    이름:<%=cvo.getWriter()%>
    날짜:<%=cvo.getWrite_date()%><br/>
    내용:<%=cvo.getContent()%>
  </div>
<%
    }
%>

</div>
<%
    }
%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    $(function () {
        let option = {
            modal : true,
            autoOpen : false,
            resizable : false,
        };
        $("#del_dialog").dialog(option)
    })
    function goList(){
        document.ff.action = "Controller"
        document.ff.type.value = "list"
        document.ff.submit();
    }
    function godel() {
        // document.ff.action = "Controller"
        // document.ff.type.value = "delete"
        // document.ff.submit();
        $("#del_dialog").dialog("open")
    }
    function del(frm) {
        frm.submit()
    }
    function goRewrite() {
        document.ff.action = "Controller"
        document.ff.type.value = "rewrite"
        document.ff.submit();
    }
</script>
</body>
</html>