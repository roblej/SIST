<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
  현재 페이지는 money라는 파라미터를 받는다. money에 따라 과일을 선택할 수 있다.
  사과 : 100  /  배 : 1700  /  샤인머스캣 : 2500
 --%>
<c:choose>
    <c:when test="${param.money >= 2500}">
        사과, 배, 샤인머스캣 중 하나를 선택!
    </c:when>
    <c:when test="${param.money >= 1700}">
        사과, 배 중 하나를 선택!
    </c:when>
    <c:when test="${param.money >= 100}">
        사과 선택!
    </c:when>
    <c:otherwise>
        돈벌어와라
    </c:otherwise>
</c:choose>
<hr/>
<%--if로도 가능--%>
<c:if test="${param.money >= 2500}">사과, 배, 샤인머스캣 중 하나를 선택!</c:if>
<c:if test="${param.money >= 1700 and param.money < 2500}">사과, 배 중 하나를 선택!</c:if>
<c:if test="${param.money >= 100 and param.money < 1700}">사과 선택!</c:if>
<c:if test="${param.money < 100}">돈벌어와라</c:if>
</body>
</html>
