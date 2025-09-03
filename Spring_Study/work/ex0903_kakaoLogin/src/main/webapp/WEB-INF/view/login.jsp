<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
  <header>
    <h1>로그인</h1>
  </header>
  <article>
<%--    세션에 mvo라는 이름으로 값이 없다면 로그인화면을 보여줘야함--%>
    <c:if test="${sessionScope.mvo eq null}">
      <form method="post" action="">
        ID : <input type="text" name="m_id"/><br/>
        PWD : <input type="password" name="m_pw"><br/>
        <button type="button">LOGIN</button>
        <br/>
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=ff54feae9f11b6b20bce9ab7bfd86bf0&redirect_uri=http://localhost:8080/login/kakao&response_type=code">
          <img src="resources/images/kakao_login.png">
        </a>
      </form>
    </c:if>
  </article>
</body>
</html>
