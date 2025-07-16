<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String cPath = request.getParameter("cPath");
    String f_name = request.getParameter("f_name");


    //받은 파라미터들과 함께 절대경로가 필요하다.
    String realPath = application.getRealPath("/members/" + cPath + "/" + f_name);
    //절대경로를 가지고 FIle객체를 생성한다
    File f = new File(realPath);
    if (!f.exists()) {
        f.mkdirs(); //폴더가 존재하지 않으면 폴더를 생성한다.
        response.sendRedirect("myDisk.jsp?cPath=" + cPath);
    } else {

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button type="button" onclick="goBack()">돌아가기</button>
<script>
    alert("폴더가 이미 존재합니다.");
    function goBack() {
        // 현재 페이지의 cPath를 가지고 myDisk.jsp로 이동한다.
        window.location.href = "myDisk.jsp?cPath=<%=cPath%>";
    }
</script>
</body>
</html>

<%
    }
%>