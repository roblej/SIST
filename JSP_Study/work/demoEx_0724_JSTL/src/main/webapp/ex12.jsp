<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  <c:set var="now" value="<%=new Date(System.currentTimeMillis())%>"/>--%>
  <c:set var="now" value="<%=new Date()%>"/>
<h2>${now}</h2>
<h2><fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/></h2>
<h2><fmt:formatDate value="${now}" pattern="(a)hh:mm:ss"/></h2>
<h2><fmt:formatDate value="${now}" pattern="HH:mm:ss"/></h2>
<hr/>
<h2>------------숫자형식---------------</h2>
<h2><fmt:formatNumber value="12000000000"/></h2>
<h2><fmt:formatNumber value="12000000000" groupingUsed="false"/></h2>
<h2><fmt:formatNumber value="12000000000" pattern="#,##0"/></h2>
<h2><fmt:formatNumber value="0000000.00" pattern="#,##0"/></h2>
<h2><fmt:formatNumber value="00012000000" pattern="#,###.00"/></h2>
<h2><fmt:formatNumber value="0.195" type="percent" pattern="#,##0.00%"/></h2>
<h2><fmt:formatNumber value="10000000" type="currency" currencySymbol="$"/></h2>


</body>
</html>
