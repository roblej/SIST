<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<style>
    #t1{
        border-collapse: collapse;
        width: 400px;
    }
    #t1 caption{
        text-indent: -9999px;
        height: 0;
    }
    #t1 th{
        padding: 6px;
        background-color: grey;
        border: 1px solid black;
      }
    #t1 td{
        padding: 4px;
        border: 1px solid black;
    }
    #t1 .no-border{border:none;}
    #type, #value, #btn1{padding:5px;}
    .w150{width: 150px}

</style>
<body>
    <h1>회원목록</h1>
    <hr/>
    <table id="t1">
        <caption>회원목록테이블</caption>
        <thead>
        <tr>
            <td colspan="3" class="no-border">
                <form id="searchForm" action="search" method="post">
                    <select id="type" name="searchType">
                        <option value="0">이름</option>
                        <option value="1">이메일</option>
                        <option value="2">연락처</option>
                    </select>
                    <input type="text" id="value" name="searchVal" class="w150"/>
                    <button type="submit" id="btn1">검색</button>
                </form>
            </td>
        </tr>
        <tr>
            <th>회원명</th>
            <th>이메일</th>
            <th>연락처</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ar}" var="vo">
            <tr onclick="viewData(this)">
                <td>${vo.name}</td>
                <td>${vo.email}</td>
                <td>${vo.phone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
    $(function () {
        // 폼 submit 이벤트 감지
        $("#searchForm").submit(function (e) {
            // 기본 submit 동작(페이지 이동) 방지
            e.preventDefault();

            // form의 모든 input 값을 직렬화하여 전송
            let data = $(this).serialize();

            $.ajax({
                url: "search", // action과 동일하게 맞춤
                type: "post",
                data: data,
                dataType: "json"
            }).done(function (ar) { // 서버에서 받은 배열(ar)
                // 비동기 통신 성공 시
                console.log(ar);

                let code = "";
                if(ar.length > 0) {
                    // 받은 배열을 반복하면서 테이블 행(tr)을 생성
                    for (let i = 0; i < ar.length; i++) {
                        code += "<tr onclick='viewData(this)'>";
                        code += "<td>" + ar[i].name + "</td>";
                        code += "<td>" + ar[i].email + "</td>";
                        code += "<td>" + ar[i].phone + "</td>";
                        code += "</tr>";
                    }
                } else {
                    code += "<tr><td colspan='3'>검색된 결과가 없습니다.</td></tr>";
                }

                // 기존 테이블의 tbody 내용을 새로운 내용으로 교체
                $("#t1 tbody").html(code);
            }).fail(function(err) {
                // 통신 실패 시 에러 로그 출력
                console.error("AJAX Error:", err);
                alert("검색 중 오류가 발생했습니다.");
            });
        });
    });
    function viewData(info) {

    }
</script>
</body>
</html>
