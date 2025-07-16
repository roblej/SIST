<%@ page import="mybatis.vo.MemVO" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public int useSize(File f) {
        //인자로 전달된 File 객체가 폴더여야 한다.
        //이 폴더의 하위요소들의 File용량을 모두 더해야한다. 우선 하위요소를 모두 얻어낸다
        File[] list = f.listFiles();
        int size = 0;
        //파일인 경우엔 용량을 size에 누적시키고, 폴더(디렉토리)일 경우엔 현재함수를 재귀호출함
        for (File sf : list) {
            if (sf.isFile()) {
                size += sf.length();
            } else {
                size += useSize(sf);//재귀호출
            }
        }
        return size;
    }
%>
<html>
<head>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
    <title>Title</title>
</head>
<style>
    table {
        width: 600px;
        border-collapse: collapse;
    }

    table th, table td {
        border: 1px solid #27a;
        padding: 5px;
    }

    table th {
        background-color: #bcbcbc;
    }

    .title {
        background-color: #bcbcbc;
        width: 25%;
    }

    .w50 {
        width: 50px;
    }

    .w80 {
        width: 80px;
    }

    .btn {
        width: 70px;
        height: 20px;
        text-align: center;
        padding: 0px;
        display: inline-block;
        margin: 10px;
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

    div#my_alert , #upload_win, #folder_win{
        display: none;
    }
</style>
<body>
<%
    int totalSize = 1024 * 1024 * 10; // 10MG
    int usedSize = 0; // 사용량
    // 로그인을 수행한 상태들만 허용하는 페이지이므로 로그인 검증하자!
    Object obj = session.getAttribute("mvo");
    if (obj != null) {// 로그인을 수행한 경우
        MemVO mvo = (MemVO) obj;

        String rpath = application.getRealPath("/members/" + mvo.getM_id());
        //로그인한 사용자의 디렉토리의 절대경로를 얻어낸다.
        usedSize = useSize(new File(rpath));

        //현재 페이지로 올때 파라미터 하나 받는다. cPath다.
        //만약 없으면 null을 받는다는 것을 기억하자!
        String dir = request.getParameter("cPath");//위치값

        String fname = request.getParameter("f_name"); //폴더명
        //만약 dirdㅣ null이면 현재 로그인한 사용자의 디렉토리로 설정한다.
        if (dir == null) dir = mvo.getM_id();
        else {
            //이미 myDisk에 들어왔다가 다른작업(폴더)를 클릭하여 요청한 경우
            if (fname != null && fname.trim().length() > 0) {
                dir = dir + "/" + fname;
            }
        }
        //dir이 구해진 후 나중에 파일 올리기를 할 때 upload.jsp에서 필요하므로
        //세션에 미리 저장해두자
        session.setAttribute("cPath", dir);
%>
<h1>My Disk Service</h1>
<hr/>
<%=mvo.getM_name()%>(<span class="m_id"><%=mvo.getM_id()%>)</span>님의 디스크
&nbsp; [<a href="javascript:home()">Home</a>]
<hr/>
<table>
    <caption>디스크사용량테이블</caption>
    <tbody>
    <tr>
        <th class="title">전체용량</th>
        <td><%=totalSize/1024%> KB</td>
    </tr>
    <tr>
        <th class="title">사용량</th>
        <td><%=usedSize/1024%> KB</td>
    </tr>
    <tr>
        <th class="title">잔여용량</th>
        <td><%=(totalSize-usedSize)/1024%> KB</td>
    </tr>
    </tbody>
</table>
<hr/>
<div id="btn_area">
    <p class="btn"><a href="javascript:selectFile()">파일올리기</a></p>
    <p class="btn"><a href="javascript:DialogFolder()">폴더만들기</a></p>
    <p class="btn"><a href="javascript:exe()">파일생성</a></p>
</div>
<hr/>
<label for="dir">현재위치 :</label>
<span id="dir"><%=dir%></span>
<table>
    <caption>위치폴더 안애 내용을 표현하는 테이블</caption>
    <thead>
    <tr>
        <th class="w50">구분</th>
        <th>폴더 및 파일명</th>
        <th class="w80">삭제여부</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(!dir.equalsIgnoreCase(mvo.getM_id())){
            int idx = dir.lastIndexOf("/");
            String parentDir = dir.substring(0, idx);
    %>
    <tr>
        <td></td>
        <td colspan="2"><a href="javascript:backback('<%=parentDir%>');">상위로...</a></td>
    </tr>
    <%
        }//상위로 기능 구현
    %>

    <%
        //현재위치값(dir)을 가지고 File객체를 만들기 위해 절대경로를 생성
        String realpath = application.getRealPath("/members/" + dir);
        //절대경로를 만든 이유 : File객체를 생성하여 하위에 있는 파일 또는 폴더를 얻기위해
        File s_file = new File(realpath);//  ~/members/로그인한아이디
        //위에서 만든 filerㅐㄱ체 안에 있는 하위요소(파일 및 폴더들) 얻기
        File[] sub_list = s_file.listFiles();
        for (File f : sub_list) {
    %>
    <tr>
        <td><%if (f.isFile()) out.print("파일");%></td>
        <td><% if (f.isDirectory()) { %>
            <a href="javascript: gogo('<%=f.getName()%>')">
                <%=f.getName()%>
            </a>

            <%
            } else {
            %>
            <a href="javascript:down('<%=f.getName()%>')">
            <%=f.getName()%>
            </a>
            <%
                }
            %>
        </td>
        <td></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<form name="ff" method="post">
    <input type="hidden" name="f_name">
    <input type="hidden" name="cPath" value="<%=dir%>">
</form>

<div id="upload_win" title="파일올리기">
    <form action="upload.jsp" method="post" enctype="multipart/form-data" name="frm2">
        <label for="selectFile">첨부파일 :</label>
        <input type="file" id="selectFile" name="upload"/><br/>
        <input type="hidden" name="cPath" value="<%=dir%>"><%-- 필요없음. MultipartRequest를 생성할 떄 들어감. --%>

        <p class="btn"><a href="javascript:upload()">보내기</a></p>
        <p class="btn"><a href="javascript:closeUpload()">닫기</a></p>
    </form>
</div>
<div id="folder_win" title="폴더만들기">
    <form action="makeFolder.jsp" method="post" name="frm3">
        <input type="hidden" name="cPath" value="<%=dir%>"><%-- 필요없음. MultipartRequest를 생성할 떄 들어감. --%>
        <label for="f_name">폴더명 :</label>
        <input type="text" id="f_name" name="f_name"/><br/>
        <p class="btn"><a href="javascript:makefolder()">만들기</a></p>
        <p class="btn"><a href="javascript:closeFolder()">닫기</a></p>
    </form>
</div>
<%
    } else {
        response.sendRedirect("../index.jsp");
    }
%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
<script>
    function home() {
        // 현재 로그인한 사용자의 디렉토리로 이동
        location.href = "../index.jsp";
    }

    function gogo(folderName) {
        //폴더를 클릭했을 때 해당 폴더명을 인자로 전달하여 수행하는 함수
        // alert(folderName);
        // f_name인 폴더를 클릭했을떄 그 값을 가져옴

        document.ff.f_name.value = folderName;
        document.ff.action = "myDisk.jsp";
        document.ff.submit();
    }

    function backback(parentDir) {
        document.ff.cPath.value = parentDir;
        document.ff.action = "myDisk.jsp";
        document.ff.submit();

    }
    function selectFile() {
        $("#upload_win").dialog({
            title: "파일올리기",
            width: 350,
            // height: 200,
            modal: true,
            resizable: false,
            // closeOnEscape: true,
        });
    }
    function closeUpload() {
        $("#upload_win").dialog("close");
    }
    function upload(){
        document.frm2.submit();
    }
    function makefolder() {
        document.frm3.submit();
    }
    function DialogFolder() {
        $("#folder_win").dialog({
            title: "폴더만들기",
            width: 350,
            // height: 200,
            modal: true,
            resizable: false,
            // closeOnEscape: true,
        });
    }
    function closeFolder() {
        $("#folder_win").dialog("close");
    }
    function down(fname){
        //인자로 받은 파일명을 현재문서 안에 있는 ff라는 이름으로 폼 객체 안에 이름이 f_name이라는 intput type = hidden에 값(value)로 설정
        document.ff.f_name.value = fname;
        document.ff.action = "download.jsp";
        document.ff.submit();

        //다운로드가 진행되면서 현재페이지가 유지될 때 파일명이 지정되어있으면 오류가 발생할 수 있음 -> 파일명 삭제
        document.ff.f_name.value = "";
    }
</script>
</body>
</html>
