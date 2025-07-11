<%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<article>
    <header>
        <h2>폼 연습</h2>
    </header>
    <div>
        <form action="ex3.jsp" method="post" name="ff">
            <label for="s_id">아이디:</label>
            <input type="text" id="s_id" name="s_id"><br/>
            <label for="s_pw">비밀번호:</label>
            <input type="password" id="s_pw" name="s_pw"><br/>
            <button type="button" onclick="exe()">제출</button>
        </form>
    </div>
</article>

<script>
    function exe(){
        //유효성검사 패스
        // document.forms[0].submit();
        document.ff.submit();//form에 name이 있을떄
    }
</script>
</body>
</html>
