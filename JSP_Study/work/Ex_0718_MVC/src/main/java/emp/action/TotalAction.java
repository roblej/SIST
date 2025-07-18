package emp.action;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TotalAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath = "jsp/total.jsp";
        EmpVO[] ar = EmpDAO.getAll();

        request.setAttribute("ar", ar);

        return viewPath;
    }
}
