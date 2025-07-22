package bbs.action;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction   implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //DAO를 호출하여 원하는 게시글 목록을 받아야 한다.
        String bname = request.getParameter("bname");
        String cPage = request.getParameter("cPage");
        if(bname == null){
            bname = "BBS";
        }
        BbsVO[] ar = BbsDAO.getList(bname,1,10);
        // JSP에서 표현하기 위해서 request에 저장!
        request.setAttribute("ar",ar);

        return "list.jsp";
    }
}
