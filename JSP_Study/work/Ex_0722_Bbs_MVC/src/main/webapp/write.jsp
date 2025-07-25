<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="./css/summernote-lite.css">
  <style type="text/css">
    #bbs table {
      width:580px;
      margin-left:10px;
      border:1px solid black;
      border-collapse:collapse;
      font-size:14px;

    }

    #bbs table caption {
      font-size:20px;
      font-weight:bold;
      margin-bottom:10px;
    }

    #bbs table th {
      text-align:center;
      border:1px solid black;
      padding:4px 10px;
    }

    #bbs table td {
      text-align:left;
      border:1px solid black;
      padding:4px 10px;
    }

    .no {width:15%}
    .subject {width:30%}
    .writer {width:20%}
    .reg {width:20%}
    .hit {width:15%}
    .title{background:lightsteelblue}

    .odd {background:silver}


  </style>
  <script type="text/javascript">
    function sendData(){
      // for(var i=0 ; i<document.forms[0].elements.length ; i++){
      //   if(document.forms[0].elements[i].value == ""){
      //     console.log(document.forms[0].elements[i].name)
      //     alert(document.forms[0].elements[i].name+
      //             "를 입력하세요");
      //     document.forms[0].elements[i].focus();
      //     return;//수행 중단
      //   }
      // }
      if($("#title").val().trim().length<1){
        alert("제목을 입력하세요");
        $("#title").val("")
        $("#title").focus()
        return
      }
      if($("#writer").val().trim().length<1){
        alert("이름을 입력하세요");
        $("#writer").val("")
        $("#writer").focus()
        return
      }
      if($("#content").val().trim().length<1){
        alert("내용을 입력하세요");
        $("#content").val("")
        $("#content").focus()
        return
      }
//		document.forms[0].action = "test.jsp";
      document.forms[0].submit();
    }
  </script>
</head>
<body>
<div id="bbs">
  <form action="Controller?type=write" method="post"
        encType="multipart/form-data">
    <input type="hidden" name="bname" value="BBS"/>
    <table summary="게시판 글쓰기">
      <caption>게시판 글쓰기</caption>
      <tbody>
      <tr>
        <th>제목:</th>
        <td><input type="text" id="title" name="title" size="45"/></td>
      </tr>
      <tr>
        <th>이름:</th>
        <td><input type="text" id="writer" name="writer" size="12"/></td>
      </tr>
      <tr>
        <th>내용:</th>
        <td><textarea id = "content" name="content" cols="50"
                      rows="8"></textarea></td>
      </tr>
      <tr>
        <th>첨부파일:</th>
        <td><input type="file" id="file" name="file"/></td>
      </tr>
      <!--
                      <tr>
                          <th>비밀번호:</th>
                          <td><input type="password" name="pwd" size="12"/></td>
                      </tr>
      -->
      <tr>
        <td colspan="2">
          <input type="button" value="보내기"
                 onclick="sendData()"/>
          <input type="button" value="다시"/>
          <input type="button" value="목록"/>
        </td>
      </tr>
      </tbody>
    </table>
  </form>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="./js/summernote-lite.js"></script>
<script src="./js/lang/summernote-ko-KR.js"></script>
<script>
  $(function () {
    $("#content").summernote({
      lang : "ko-KR",
      height:300,

      callbacks: {
        onImageUpload: function (files,editor){
          //에디터에 이미지를 추가될 때 수행하는 곳
          //이미지는 여러개 추가할 수 있으므로 files는 배열이다.
          for(let i=0;i<files.length;i++)
            sendImage(files[i],editor)
        }
      }
    })
  })
  function sendImage(file,editor) {
    //서버로 비동기식 통신을 수행하기 위해 준비한다.
    //이미지를 서버로 보내기 위해 폼객체를 생성하자
    let frm = new FormData()
    //서버로 보낼 이미지파일을 폼객체에 파라미터로 지정
    frm.append("upload",file)

    $.ajax({
      url:"Controller?type=saveImg",
      type:"post",
      data:frm,
      contentType:false,
      processData: false,
      dataType:"json",
    }).done(function (res) {
      //요청에 성공했을 때 수행
      //분명 서버의 saveImg.jsp에서 응답하는 json이 res로 들어온다.
      console.log(res.img_url)
      //그 json에 img_url이라는 이름으로 이미지의 결로를 보내도록 되어있다.
      //그것을 받아 ㄷditor에 img태그를 넣어주면 된다.
      $("#content").summernote("editor.insertImage",res.img_url)
    }).fail(function (res) {
      console.log("fail")
    })
  }
</script>
</body>
</html>












