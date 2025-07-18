<%@ page import="mybatis.vo.EmpVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
<style>
    .table {
        width: 600px;
        border-collapse: collapse;
    }

    .table th, .table td {
        border: 1px solid black;
        padding: 5px;
    }

    .table caption {
        text-indent: -9999px;
        height: 0;
    }

    .txt_R {
        text-align: right;
    }

    .noBorder {
        border: none !important;
    }
</style>
<body>
<div id="wrap">
    <header>
        <h1>사원목록</h1>
    </header>
    <article>
        <table class="table">
            <caption>사원목록</caption>
            <thead>
            <tr>
                <td colspan="6" class="txt_R noBorder">
                    <button type="button" id="all_btn" onclick="fetchAllEmployees()">전체보기(AJAX)</button>
                    <button type="button" id="total_btn">전체보기</button>
                    <button type="button" id="search_btn" onclick="">검색</button>
                    <button type="button" id="add_btn">추가</button>
                    <button type="button" id="dept_btn">부서목록</button>
                </td>
            </tr>
            <tr>
                <th>사번</th>
                <th>이름</th>
                <th>직종</th>
                <th>급여</th>
                <th>입사일</th>
                <th>부서코드</th>
            </tr>
            </thead>
            <tbody>

            </tbody>

        </table>
    </article>
    <div id="searchDialog">
            <select id="searchType" name="searchType">
                <option id="searchEmpno" value="empno">사번</option>
                <option id="searchEname" value="ename">이름</option>
                <option id="searchJob" value="job">직종</option>
                <option id="searchDept" value="deptno">부서번호</option>
            </select>
            <input type="text" id="searchValue" name="seasrchValue"/>
            <button type="button" onclick="searchEmp()">보내기</button>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    function fetchAllEmployees() {
        $.ajax({
            url : "controller",
            type: "post",
            data: {type: "all"}
        }).done(function (res) {//
            console.log(res)
            $("table.table>tbody").html(res)
        });
    }

    function searchEmp() {
        $.ajax({
            url : "controller",
            type: "post",
            data: {
                type      : "search",
                searchType : $("#searchType").val(),
                searchValue : $("#searchValue").val()
            }
        }).done(function (res) {//
            $("table.table>tbody").html(res)
            $("#searchDialog").dialog("close")
        });
    }

    $(function () {
        $("#searchDialog").dialog({
            title    : "검색",
            autoOpen : false,
            modal    : true,
            resizable: false
        })
        $("#search_btn").click(function () {
            $("#searchDialog").dialog("open")
        })
        $("#add_btn").click(function () {
            location.href = "controller?type=add"
        })
        $("#total_btn").click(function () {
            location.href = "controller?type=total"
        })
        $("#dept_btn").click(function () {
            location.href = "controller?type=dept"
        })
        // $("#all_btn").click(function () {
        //     $.ajax({
        //         url : "controller",
        //         type: "post",
        //         data: {type: "all"}
        //     }).done(function (res) { //res는 allAction이 실행된 후 응답되는 all.jsp에서 반복 수행된 tr들
        //         console.log(res)
        //         $("table.table>tbody").html(res)
        //     })
        // })
    })

</script>
</body>
</html>