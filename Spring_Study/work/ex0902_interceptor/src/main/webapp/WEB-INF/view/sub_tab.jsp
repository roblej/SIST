<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="nav.jsp" var="nav"/>
<c:import url="foot.jsp" var="foot"/>
<html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>main</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/common.css">
  <link rel="stylesheet" type="text/css" href="/resources/css/sub_tab.css">
</head>
<body>
<article id="wrap">
  <!-- ================= 상단영역 ================== -->
${nav}
  <!-- ================= 상단영역끝 ================== -->
  <!-- ================= 콘텐츠영역 ================== -->
  <div id="contents">
    <p>
      <img src="/resources/img/@img05.png" alt="이미지5">
    </p>
    <div class="tab_type01">
      <ul>
        <li id="t1"><a href="javascript:ex1()">위드유</a></li>
        <li id="t2" class="selected"><a href="javascript:ex2()">위드유 영상</a></li>
        <li id="t3"><a href="javascript:ex3()">위드유 대화</a></li>
      </ul>
    </div>
    <!-- 각 탭에 표현할 내용들 -->
    <div id="tab1" class="tab_cont">
      위드유 내용입니다.!
    </div>
    <div id="tab2" class="tab_cont show">
      CrossOver Mac 25.0.1 download is starting...
      Thank you for downloading CrossOver Mac. Your free trial download should automatically begin in a few seconds.

      If it does not, click here.

      Once your install is complete click CrossOver icon to launch CrossOver. From the CrossOver window click "Install a
      Windows Application" button to start application install. If at any time you are having difficulties with this
      process, please contact support.
    </div>
    <div id="tab3" class="tab_cont">
      위드유 내용입니다.!
    </div>
  </div>
  <!-- ================= 콘텐츠영역끝 ================== -->
  <!-- ================= 하단영역 ================== -->
${foot}
  <!-- ================= 하단영역끝 ================== -->

</article>
<script>
  function ex1() {
    var t1 = document.getElementById("t1");
    var t2 = document.getElementById("t2");
    var t3 = document.getElementById("t3");

    t1.className = "selected";
    t2.className = "";
    t3.className = "";

    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");

    tab1.className = "tab_cont show";
    tab2.className = "tab_cont";
    tab3.className = "tab_cont";
  }

  function ex2() {
    var t1 = document.getElementById("t1");
    var t2 = document.getElementById("t2");
    var t3 = document.getElementById("t3");

    t1.className = "";
    t2.className = "selected";
    t3.className = "";

    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");

    tab1.className = "tab_cont";
    tab2.className = "tab_cont show";
    tab3.className = "tab_cont";
  }

  function ex3() {
    var t1 = document.getElementById("t1");
    var t2 = document.getElementById("t2");
    var t3 = document.getElementById("t3");

    t1.className = "";
    t2.className = "";
    t3.className = "selected";

    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");

    tab1.className = "tab_cont";
    tab2.className = "tab_cont";
    tab3.className = "tab_cont show";
  }
</script>
</body>
</html>
