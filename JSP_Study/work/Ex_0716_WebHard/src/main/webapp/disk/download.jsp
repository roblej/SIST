<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //요청 시 한글 처리
    request.setCharacterEncoding("utf-8");

    //인자 받기
    String cPath = request.getParameter("cPath"); //현재 경로(서버)
    String f_name = request.getParameter("f_name"); //파일명

    //절대경로 만들기
    String realPath = application.getRealPath("/members/" + cPath + "/" + f_name);

    //파일 객체 생성
    File f = new File(realPath);
    if (f.exists()) { //파일이 존재하면
    /*
    다운로드는 사용자 입장에서는 받기만 하면 되지만 서버입장에서는
    읽기 후 보내야 하므로 InputStream과 OutputStream을 모두 사용해야한다.
    */
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        BufferedOutputStream bos = null;
        ServletOutputStream sos = null; // 중요!!
//     요청자에게 응답으로 스트림을 줘야 다운로드가 된다. - response로 얻을수 있는 outputStream이
//     ServletOutputStream이다.
        byte[] buf = new byte[2048]; //읽기 버퍼
        int size = -1; //읽은 크기
        try {
            //접속자 화면에 다운로드창을 보여준다.
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(f_name.getBytes(), "8859_1"));
            //---------------------------------------------------------------------------
            //다운로드할 파일과 연결되는 스트림 생성
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);

            //응답스트림 생성
            sos = response.getOutputStream();
            bos = new BufferedOutputStream(sos);
            //파일의 자원들을 읽어서 바로 보내기 함녀 된다.
            while ((size = bis.read(buf)) != -1) {
                //읽은 자원은 buf에 저장되며, 읽은 byte 수는 size가 기억한다.
                bos.write(buf, 0, size);
                bos.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) bos.close();
                if (bis != null) bis.close();
                if (fis != null) fis.close();
                if (sos != null) sos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

%>
