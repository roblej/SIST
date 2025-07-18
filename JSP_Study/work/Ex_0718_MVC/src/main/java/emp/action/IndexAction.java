package emp.action;

import mybatis.dao.EmpDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        EmpDAO.getAll();
        return "jsp/index.jsp";
    }
}
