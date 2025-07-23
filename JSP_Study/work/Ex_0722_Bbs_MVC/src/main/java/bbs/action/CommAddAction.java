package bbs.action;

import mybatis.dao.CommDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommAddAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String b_idx = request.getParameter("b_idx");
        String cPage =  request.getParameter("cPage");
        String writer =  request.getParameter("writer");
        String content = request.getParameter("content");
        String pwd = request.getParameter("pwd");
        String ip = request.getRemoteAddr();
        System.out.println("test");
        CommDAO.add(writer,content,pwd,ip,b_idx);

        //원래 있던 보기화면으로 이동
        return "Controller?type=view&b_idx="+b_idx+"&cPage="+cPage;
    }
}
