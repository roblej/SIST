<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <meta charset="UTF-8">
  <style>
    #box{
      width: 300px;
      height: 300px;
      border: 1px solid black;
    }
  </style>
</head>
<body>
<h1>비동기식 통신으로 json결과 받기</h1>
<hr/>
<button type="button" id="bt1">연습</button> &nbsp;
<button type="button" id="bt2">사원</button> &nbsp;
<div id="box"></div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  $(function (){
    //이벤트 감지자 등록
    $("#bt1").click(function () {
      //연습1 버튼을 클릭할때마다 수행하는 곳!
      $.ajax({
        url : "/callTest", //컨트롤러의 RequestMapping을 의미함
        type : "post",
        dataType: "json"
      }).done(function (res) {
        //비동기식 통신이 성공했을 때
        console.log(res)
        let code = "<ul>"
        for(let i = 0; i< res.length; i++){
          code += "<li>"
          code += res.ar[i].ename
          code += ","
          code += res.ar[i].email
          code+= "</li>"
        }
        code += "</ul>"
        $("#box").html(code)
      })
    })

    $("#bt2").click(function () {
      //연습2 버튼을 클릭할때마다 수행하는 곳!
      $.ajax({
        url : "/empAll", //컨트롤러의 RequestMapping을 의미함
        type : "post",
        dataType: "json"
      }).done(function (res) {
        //비동기식 통신이 성공했을 때
        console.log(res)
        let code = "<ul>"
        for(let i = 0; i< res.length; i++){
          code += "<li>"
          code += res.ar[i].empno
          code += ","
          code += res.ar[i].ename
          code += ","
          code+= "</li>"
          code += res.ar[i].job
          code += ","
          code+= "</li>"
          code += res.ar[i].mgr
          code += ","
          code+= "</li>"
          code += res.ar[i].hiredate
          code += ","
          code+= "</li>"
          code += res.ar[i].comm
          code += ","
          code+= "</li>"
          code += res.ar[i].deptno
          code+= "</li>"
        }
        code += "</ul>"
        $("#box").html(code)
      })
    })
  })
</script>
</body>
</html>
