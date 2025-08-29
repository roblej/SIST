<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <style>
        #box{
            width: 300px;
            height: 250px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
  <h1>JSON연습입니다</h1>
    <button type="button" id="btn">확인</button>
    <div id="box"></div>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
    $(function (){
        //무조건 수행하는 곳
        $("#btn").click(function () {
            $.ajax({
                url: "test3",
                data : "v1=100&v2=200",
                type: "post",
                dataType:"json"
            }).done(function (res) {
                // console.log(res)
                // let str = "";
                // str += "<tr><td>Name:</td><td>"
                // str += res.name;
                // str += "</td></tr><tr><td>email:</td><td>"
                // str += res.email;
                // str += "</td></tr>"
                $("#box").html("<h2>Name : "+res.name +"</h2><br/>" + "<h2>email : "+res.email +"</h2>")
            })
        })
    })
</script>
</body>
</html>
