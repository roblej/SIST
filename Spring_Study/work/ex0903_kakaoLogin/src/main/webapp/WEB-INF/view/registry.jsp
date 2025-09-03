<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        .readOnly{
            background-color: #cdcdcd;
        }
    </style>
</head>
<body>
    <header>
        <h1>추가정보 입력</h1>
    </header>
    <article>
        <form action="" method="post">
            <img src="${mvo.p_img}" width="100"/><br/>
            이름 : <input type="text" name="m_name"/><br/>
            별칭 : <input type="text" name="nickname" readonly value="${mvo.nickname}" class="readOnly"/><br/>
            이메일 : <input type="text" name="email" value="${mvo.email}" class="readOnly" readonly/><br/>
            연락처 : <input type="text" name="phone"/><br/>
            <button type="button">저장</button>
        </form>
    </article>
</body>
</html>
