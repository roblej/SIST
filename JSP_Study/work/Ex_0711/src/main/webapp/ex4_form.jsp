<%--
  Created by IntelliJ IDEA.
  User: ten
  Date: 2025. 7. 11.
  Time: 11:32
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
            <form action="ex4.jsp" method="post" name="ff">
                <label for="s_num">숫자입력 :</label>
                <input type="text" id="s_num" name="s_num"><br/>
                <button type="button" onclick="exe()">제출</button>
            </form>
        </div>
    </article>
<script>
    function exe(){
        let num = document.getElementById("s_num").value
        if(num.trim().length ==0){
            alert("숫자를 입력하세요")
            num=""
            num.focus()
            return
        }else{
        document.ff.submit();//form에 name이 있을떄
        }
    }
</script>
</body>
</html>
