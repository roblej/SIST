package emp.action;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        EmpVO[] ar = EmpDAO.getAll();
        System.out.println(ar.length);
        request.setAttribute("ar", ar);

        return "jsp/all.jsp";
    }
}
