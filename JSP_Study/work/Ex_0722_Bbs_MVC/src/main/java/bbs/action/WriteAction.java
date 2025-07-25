package bbs.action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import mybatis.dao.BbsDAO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class WriteAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath = null;
        //list.jsp에 있는 글쓰기 버튼을 클릭하면 get방식으로 현재 객체를 수행한다.
        //이 때 요청 시 contentType을 얻어낸다. 분명 get방식 null을 얻게 된다.
        String enc_type = request.getContentType();
        System.out.println("enc_type = " + enc_type);
        if(enc_type == null)
            viewPath = "write.jsp";
        else if (enc_type.startsWith("multipart")) {
            //여기는 write.jsp에서 내용을 입ㅋ한 후 보내기 버튼을 클릭했을 때 수행하는곳
            //클릭했을 때 수행하는 곳
            // 첨부파일을 받아서 bbs_upload라는 폴더에 저장해야 합니다
            try {
                ServletContext application = request.getServletContext();
                String realPath = application.getRealPath("/bbs_upload");

                //첨부파일과 다른 파라미터들을 받기 위해 MultipartRequest를 생성
                MultipartRequest mr = new MultipartRequest(request,realPath,1024*1024*5, "utf-8",new DefaultFileRenamePolicy());
                //이 떄 첨부파일이 있다면 realPath경로에 저장된 상태다

                //나머지 파라미터 얻기(title,writer,content)
                String title = mr.getParameter("title");
                String writer = mr.getParameter("writer");
                String content = mr.getParameter("content");
                String bname = mr.getParameter("bname");

                //첨부파일이 있다면 fname과 oname을 얻어야한다.
                File f = mr.getFile("file");
                String fname = null;
                String oname = null;
                if(f!=null){
                    fname = f.getName();
                    oname = mr.getOriginalFileName("file"); //원래 이름
                }
                String ip = request.getRemoteAddr();//요청자의 ip
                //DB에 저장
                BbsDAO.add(title,writer,content,fname,oname,ip,bname);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return viewPath;
    }
}
