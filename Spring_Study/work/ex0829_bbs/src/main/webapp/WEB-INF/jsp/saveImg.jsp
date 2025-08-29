<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="f_name" value="${requestScope.f_name}"/>
<c:set var="path" value="${requestScope.getContextPath}"/>

{
  "img_url":"${path}/editor_img/${f_name}"
}
