package bbs.action;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath = "view.jsp";
        String b_idx = request.getParameter("b_idx");
        String cPage = request.getParameter("cPage");

        BbsVO vo = BbsDAO.getView(b_idx);
        BbsDAO.hit(b_idx);

        request.setAttribute("vo",vo);
//        request.setAttribute("nowpage",cPage);

        return viewPath;
    }
}
