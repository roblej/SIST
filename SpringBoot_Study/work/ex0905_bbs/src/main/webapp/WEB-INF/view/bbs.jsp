<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        table{
            width: 500px;
            border-collapse: collapse;
        }
        table th, table td{
            border: 1px solid black;
            padding: 5px;
            min-width: 100px;
        }
        table caption{
            text-indent: -9999px;
            height: 0;
        }
        .no-border{ border: none; }
    </style>
</head>
<body>
<div id="wrap">
    <header>
        <h1 onclick="javascript:location.href='/bbs'">게시판</h1>
    </header>
    <article>
        <table>
            <caption>게시판</caption>
            <thead>
            <tr>
                <td colspan="4">
                    <form action="search" method="post">
                        <select name="type">
                            <option value="0">제목</option>
                            <option value="1">작성자명</option>
                            <option value="2">내용</option>
                        </select>
                        <input type="text" name="value"/>
                        <button type="button" onclick="exe(this.form)">검색</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <th>작성자명</th>
                <th>내용</th>

            </tr>
            </thead>
            <tbody>
            <c:if test="${ar ne null}">
                <c:forEach var="vo" items="${ar}">
                    <tr>
                        <td>${vo.subject}</td>
                        <td>${vo.writer}</td>
                        <td>${vo.content}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </article>
</div>

<script>

    function exe(frm){
        let v = frm.value.value;
        if(v.trim().length < 1){
            alert("검색어를 입력하세요");
            frm.value.focus();
            return;
        }
        frm.submit();
    }
</script>
</body>
</html>
