package com.sist.ex_0717_mvc;

import ex2.DateAction;
import ex2.GreetAction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String viewPath =null;

        if(type == null || type.equalsIgnoreCase("date")){
            DateAction action = new DateAction();
            viewPath = action.execute(request,response);
        } else if (type.equalsIgnoreCase("greet")) {
            GreetAction action = new GreetAction();
            viewPath = action.execute(request,response);
        }
        //forward를 하기위해 필요한 객체
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
