package bbs.action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class SaveImgAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath = "saveImg.jsp";
        ServletContext application = request.getServletContext();
        String realPath = application.getRealPath("/editor_img");
        System.out.println(realPath);
        try{
            MultipartRequest mr = new MultipartRequest(request,realPath,1024*1024*5, new DefaultFileRenamePolicy());
            File f = mr.getFile("upload");
            System.out.println(f.getAbsolutePath());
            String f_name = null;
            if(f!=null){
                f_name = f.getName();
                System.out.println(f_name);
                request.setAttribute("f_name",f_name);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return viewPath;
    }
}
