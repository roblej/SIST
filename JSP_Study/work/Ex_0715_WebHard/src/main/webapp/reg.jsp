<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <title>Title</title>
    <style>
        .btn {
            width: 70px;
            height: 20px;
            text-align: center;
            padding: 0px;
        }

        .btn a {
            display: block;
            width: 100%;
            padding: 4px;
            height: 20px;
            line-height: 20px;
            background: #27a;
            color: #fff;
            border-radius: 3px;
            text-decoration: none;
            font-size: 12px;
            font-weight: bold;
        }

        .btn a:hover {
            background: #fff;
            color: #27a;
            border: 1px solid #27a;
        }

        #s_id, #s_pw {
            width: 80px;
            border: 1px solid #27a;
            border-radius: 3px;
            padding: 4px;
        }

        div#log_fail, div#log_suc {
            width: 170px;
            border: 1px solid #27a;
            border-radius: 3px;
        }

        .hide {
            display: none;
        }

        .show {
            display: block;
        }

        div#box {
            display: inline-block;
            width: 65px;
            height: 20px;
            padding: 0;
            margin: 0;
            margin-left: 3px;
        }

        .success {
            color: green;
            font-weight: bold;
        }

        .fail {
            color: red;
            font-weight: bold;
        }

        div#my_alert {
            display: none;
        }
    </style>
</head>
<body>
<article>
    <header>
        <h2>회원가입</h2>
    </header>
    <div>
        <form>
            <table>
                <caption>회원가입 테이블</caption>
                <tbody>
                <tr>
                    <td><label for="u_id">아이디:</label></td>
                    <td>
                        <input type="text" id="u_id" name="u_id"/>
                        <%--                        <button type="button" id="chk_btn" onclick="chkID()">중복확인</button>--%>
                        <div id="box"><%--사용가능 또는 사용불가 --%></div>
                    </td>
                </tr>
                <tr>
                    <td><label for="u_pw">비밀번호:</label></td>
                    <td>
                        <input type="password" id="u_pw" name="u_pw"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="u_name">이름:</label></td>
                    <td>
                        <input type="text" id="u_name" name="u_name"/>
                    </td>
                </tr>
                <tr>
                    <td><label for="u_phone">연락처:</label></td>
                    <td>
                        <select id="u_phone" name="u_phone">
                            <option value="02">
                                02
                            </option>
                            <option value="010">
                                010
                            </option>
                            <option value="012">
                                012
                            </option>
                            <option value="017">
                                017
                            </option>
                        </select>
                        <label for="u_phone2">-</label>
                        <input type="text" id="u_phone2" name="u_phone" value="${paramValues.u_phone[1]}"/>
                        <label for="u_phone3">-</label>
                        <input type="text" id="u_phone3" name="u_phone" value="${paramValues.u_phone[2]}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p class="btn">
                            <a href="javascript:send()">
                                저장
                            </a>
                        </p>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</article>
<div id="my_alert" title>
    <p id="str"></p>
    <p class="btn">
        <a href="javascript:closed()">확인</a>
    </p>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    $(function () {
        //아이디를 입력하는 입력란에서 키보드를 누를 때 마다 이벤트 발생
        $("#u_id").bind("keyup", function () {
            //사용자가 입력한 아이디가 u_id에 입력되므로
            //그곳에 있는 값을 가져온다
            let str = $(this).val()
            // console.log(str)
            //str의 값에서 공백이 있는지 없는지 판단하고 유효성 검사를 해야함 ->패스
            //입력한 글자 수의 길이가 4자 이상일 때 비동기식 통신을 수행한다.
            if (str.trim().length >= 4) {
                //jQuery를 이용해서 비동기식 통신을 수행한다.
                $.ajax({
                    url : "idCheck.jsp", //호출할 서버 경로
                    type: "post", //요청방식
                    data: {u_id: str}
                }).done(function (result) {
                    //요청에 성공했을 때
                    $("#box").html(result);
                });
            } else {
                //아이디 입력란에 입력된 글자수가 4자 미만일 때
                //사용자가 입력한 아이디가 4자 미만이므로
                //사용가능 또는 사용불가를 표시하지 않는다.
                $("#box").html("");
            }

        })
    })

    function send() {
        // 아이디,비밀번호, 이름을 입력했는지? 유효성 검사
        let mId = $("#u_id").val().trim();
        let mPw = $("#u_pw").val().trim();
        let mName = $("#u_name").val().trim();
        let chk = $("#chk").hasClass("success");
        if (!chk) {
            $("#str").html("아이디를 체크하세요")
            $("#my_alert").dialog()
            return;
        }
        if (mId.length == 0) {
            alert("아이디를 입력하세요");
            $("#u_id").val("");
            $("#u_id").focus();
            return;
        }
        if (mPw.length == 0) {
            alert("비밀번호를 입력하세요");
            $("#u_pw").val("");
            $("#u_pw").focus();
            return;
        }
        if (mName.length == 0) {
            alert("이름을 입력하세요");
            $("#u_name").val("");
            $("#u_name").focus();
            return;
        }
        let frm = document.forms[0];// 현재문서에서 첫번째 폼객체
        frm.action = "regMember.jsp";
        frm.method = "post";
        frm.submit();//서버로 보낸다.
    }

    function chkID() {
        let mId = $("#u_id").val().trim();

        if (mId.length == 0) {
            alert("아이디를 입력하세요");
            $("#u_id").val("");
            $("#u_id").focus();
            return;
        }
        //비동기식 통신
        $.ajax({
            url : "idCheck.jsp", //호출할 서버 경로
            type: "post", //요청방식
            data: "u_id=" + encodeURIComponent(mId), //서버로 보낼 데이터
        }).done(function (result) {
            // 요청에 성공했을 때 자동으로 수행하는곳
            $("#box").html(result.trim()); //서버에서 응답한 결과를 box에 넣는다.
        }).fail(function () {
            // 요청에 실패했을 때 수행하는 곳
            console.log(err);
        });

    }
</script>
</body>
</html>
