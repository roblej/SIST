package emp.action;

import mybatis.dao.DeptDAO;
import mybatis.dao.EmpDAO;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptAction implements Action {
        @Override
        public String execute(HttpServletRequest request, HttpServletResponse response) {
            String viewPath = "jsp/dept.jsp";
            DeptVO[] ar = DeptDAO.getAll();

            request.setAttribute("ar", ar);

            return viewPath;
        }
    }
