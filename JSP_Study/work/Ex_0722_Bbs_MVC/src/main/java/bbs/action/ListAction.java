package bbs.action;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction   implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //DAO를 호출하여 원하는 게시글 목록을 받아야 한다.
        String bname = request.getParameter("bname");
        if(bname == null)
            bname = "BBS";
        //총 게시물의 수를 얻어낸다
        int totalCount = BbsDAO.getTotalCount(bname);
        //페이징 처리를 위한 객체 생성
        Paging page = new Paging(5,3);
        page.setTotalCount(totalCount);// 총 페이지 수까지 구함
        //현재 페이지 값을 파라미터로 받는다.
        String cPage = request.getParameter("cPage");
        if(cPage == null)
            page.setNowPage(1);
        else {
            int nowPage = Integer.parseInt(cPage); // "2" => 2
            page.setNowPage(nowPage); // 이때!!!
            //게시물을 추출할 때 사용되는 begin과 end가 구해지고,
            // startPage와 endPage도 구해졌다.
        }
        BbsVO[] ar = BbsDAO.getList(bname,page.getBegin(),page.getEnd());
        // JSP에서 표현하기 위해서 request에 저장!
        request.setAttribute("ar",ar);
        request.setAttribute("paging",page);
        request.setAttribute("nowPage",page.getNowPage());
        return "list.jsp";
    }
}
