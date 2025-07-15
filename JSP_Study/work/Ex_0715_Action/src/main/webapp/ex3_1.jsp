<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //요청시 한글처리
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="pvo" class="test.vo.ParamVO" scope="session"/>
<%-- ParamVO pvo = new ParamVO();와 같다 --%>
<jsp:setProperty name="pvo" property="*"/>
<%-- 모든 파라미터를 pvo에 저장--%>
<%--
<jsp:setProperty name="pvo" property="s_name" param="s_name"/>
&lt;%&ndash;param과 property의 이름이 같으면 paramd을 생략 가능&ndash;%&gt;
<jsp:setProperty name="pvo" property="s_age" param="s_age"/>
<jsp:setProperty name="pvo" property="s_email" param="s_email"/>
--%>
<h3><%=pvo.getS_name()%></h3>
<h3><%=pvo.getS_email()%></h3>
<h3><%=pvo.getS_age()%></h3>
<button type="button" onclick="javascript:location.href='ex3_2.jsp'">다음페이지</button>
</body>
</html>
