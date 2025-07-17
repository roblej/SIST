package ex3;

import ex2.DateAction;
import ex2.GreetAction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Controller3")
public class Controller3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        Action action = null;

        if(type == null || type.equalsIgnoreCase("emp")){
            action = new EmpAction();
        }else if(type.equalsIgnoreCase("dept")){
            action = new DeptAction();
        }else if(type.equalsIgnoreCase("memo")){
            action = new MemoAction();
        }

        String viewPath = action.execute(request,response);

        //forward를 하기위해 필요한 객체
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
