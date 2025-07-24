<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--현재 페이지는 str이라는 파라미터가 넘어온다. 받은 값의 길이를 알아내자!--%>
<h2>str파라미터 값 : ${param.str}</h2>
<h2>str.length 값 : ${param.str.length()}</h2>
<h2>str.substring 값 : ${param.str.substring(1,3)}</h2>
<h2>str.indexof("k") 값 : ${param.str.indexOf("k")}</h2>
<h2>str.replaice k->h 값 : ${param.str.replace("k","h")}</h2>
<hr/>
 <c:set var="s1" value="${param.str}"/>
<h2>fn:length(s1):${fn:length(s1)}</h2>
<h2>fn:substring(s1,0,3):${fn:substring(s1,0,3)}</h2>
<h2>fn:indexOf(s1,"k"):${fn:indexOf(s1,"3")}</h2>
<h2>fn:replace(s1,"k","h"):${fn:replace(s1,"k","h")}</h2>
<h2>fn:toUpperCase(s1):${fn:toUpperCase(s1)}</h2>

</body>
</html>
