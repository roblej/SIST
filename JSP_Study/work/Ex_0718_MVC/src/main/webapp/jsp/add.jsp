<%@ page import="mybatis.vo.EmpVO" %>
<%@ page import="mybatis.dao.EmpDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrap">
    <header>
        <h1>사원목록</h1>
    </header>
    <article>
        <form action="controller" method="post" name="frm">
            <input type="hidden" name="type" value="add"/>
        <table class="table">
            <caption>사원추가 테이블</caption>
            <tbody>
                <tr>
                    <td>사번 :</td>
                    <td><input type="text" id="empno" name="empno"/></td>
                </tr>
                <tr>
                    <td>이름 :</td>
                    <td><input type="text" id="ename" name="ename"/></td>
                </tr>
                <tr>
                    <td>직종 :</td>
                    <td><input type="text" id="job" name="job"/></td>
                </tr>
            <tr>
                <td colspan="2">
                    <button type="button" id="send_btn" onclick="send(this.form)">보내기</button>
                </td>
            </tr>
            </tbody>

        </table>
            </form>
    </article>
</div>
<script>
    function send(Frm){
        frm.submit()
    }
</script>
</body>
</html>
