<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <meta charset="UTF-8">
</head>
<body>
  <h1>파일첨부연습</h1>
  <form action="write" method="post" enctype="multipart/form-data">
    <label for="title">제목 : </label>
    <input type="text" id="title" name="title"><br/>

    <label for="content">내용 : </label>
    <textarea id="content" name="content" rows="8" cols="50"></textarea><br/>

    <label for="s_file">첨부파일 : </label>
    <input type="file" id="s_file" name="s_file"><br/>

    <button type="button" onclick="exe(this.form)">보내기</button>
  </form>

<script>
  function exe(frm) {
    //유효성검사 생략
    frm.submit()
  }
</script>
</body>
</html>
