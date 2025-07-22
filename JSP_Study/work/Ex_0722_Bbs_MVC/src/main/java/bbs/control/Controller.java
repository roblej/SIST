package bbs.control;
import bbs.action.Action;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private String myParam = "/WEB-INF/action.properties";
    private Map<String, Action> actionMap;

    public Controller() {
        actionMap = new HashMap<>();
    }

    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        String realPath = application.getRealPath(myParam);


        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(realPath);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Object> it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = (String) properties.get(key);

            try{
                Action obj = (Action) Class.forName(value).newInstance();
                actionMap.put(key, obj);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if(type==null)
            type="list";
        Action action = actionMap.get(type);
        String viewPath = action.execute(request, response);
        if(viewPath==null)
            response.sendRedirect("Controller");
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
