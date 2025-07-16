<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
파일 첨부가 되는 폼은 반드시 enctype이 multipart/form-data로 지정되어야 한다.
폼에 파일을 첨부하게 되면 무조건 enctype이 위와 같아야 한다.
하지만 이렇게 하면 절대 reqpuest.getParameter()로 다른 파라미터를 얻을 수 없다.
해결책 : MultipartRequest 클래스를 사용하여 파일첨부가 된 폼을 처리한다.
mvnrepository에 있는 cos.servlet >> cos를 선택해 원하는 버전을 다운
--%>
<%
    /*
    전달되는 form의 enctype이 multipart/form-data로 지정되어 있다면 절대로 request를 통해 파라미터를 받을 수 없다.
    session에 파일을 저장할 경로(dir)를 저장했다
    */
    String dir = (String)session.getAttribute("cPath");
    //파일을 업로드할 위치를 절대경로로 바꾼다.
    String realPath = application.getRealPath("/members/"+dir);
    MultipartRequest mr = new MultipartRequest(request,realPath,1024*1024*5,new DefaultFileRenamePolicy());
    //여기까지만 해도 전달되는 첨부파일이  realPath에 저장되었다.
    //폼에 있는 자원들을 받을 수 있음
    String path = mr.getParameter("cPath"); //의미가없어요
    //파일이름을 얻어낸다.
    File f = mr.getFile("upload");
    //파일의 이름이 변경될 수 있으므로 원래 이름을 알아낸다
    String originalFileName = mr.getOriginalFileName("upload");
    //파일의 현재이름
    String fileName = f.getName();

//    response.sendRedirect("myDisk.jsp?cPath="+dir);

%>
<html>
<head>
    <title>Title</title>
</head>
<body onload="movePage()">
<form action="myDisk.jsp" method="post">
    <input type="hidden" name="cPath" value="<%=dir%>"/>
</form>

<script>
    function movePage() {
        document.forms[0].submit();
    }
</script>
</body>
</html>
