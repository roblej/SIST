<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보</title>
    <style>
        table {
            width: 500px;
            border-collapse: collapse;
        }
        table th, table td {
            border:1px solid #ddd;
            padding:5px;
        }
        table caption{
            text-indent: -9999px;
            height: 0;
        }
        thead th { background:#f5f5f5; }
        .empty { color:#888; text-align:center; }

    </style>
</head>
<body>

<table>
    <caption>회원 정보</caption>

    <thead>
    <tr>
        <td colspan="4">
            <form action="search" method="post">
                <select name="type">
                    <option value="0">사번</option>
                    <option value="1">이름</option>
                    <option value="2">직종</option>
                    <option value="3">부서</option>
                </select>
                <input type="text" name="value"/>
                <button type="button" onclick="exe(this.form)">검색</button>
            </form>
        </td>
    </tr>
    <tr class="title">
        <th class="no">사번</th>
        <th class="subject">이름</th>
        <th class="writer">직종</th>
        <th class="hit">부서</th>
    </tr>
    </thead>

    <tbody>
    <c:choose>
        <c:when test="${not empty ar}">
            <c:forEach items="${ar}" var="vo" varStatus="vs">
                <tr>
                    <td>${vo.empno}</td>
                    <td>${vo.ename}</td>
                    <td>${vo.job}</td>
                    <td>${vo.deptno}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td class="empty" colspan="5">데이터가 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
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
