package am;

import emp.action.Action;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.servlet.annotation.WebServlet;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    //Properties파일의 경로를 저장하자
    private String myParam = "/WEB-INF/action.properties";

    //위의 myParam이라는 값이 action.properties의 경로를 가지고
    // 그 파일의 내용(클래스의 경로)( =기호 앞이 key 뒤가 value)들을 가져와서 객체로 생성한 후
    //생성된 객체의 주소를 아래의 Map구조에 저장한다.
    private Map<String, Action> actionMap;

    public Controller() {
        actionMap = new HashMap<String, Action>();

    }
    @Override
    public void init() throws ServletException {
    //생성자 다음 딱 한번 수행하는 함수
        //천 요청자에 의해 단 한번만 수행하는 곳이다.
        //현재 서블릿이 생성될 때 멤버변수인 myParam갑ㅅ이 존재한다.
        // 그 myParam이 가지고 있는 값을 절대경로로 만들어야 한다
        // jspd에선 application이라는 내장객체 존재했지만 서블릿에선 직접 얻어야함.
        ServletContext application = this.getServletContext();
        String realPath = application.getRealPath(myParam);
//        System.out.println("realPath: " + realPath);
        //해당 파일의 내용(클래스 경로)을 스트림을 이용하여
        //읽어와서 Prpperties 객체에 담기 위함이다.
        Properties prop = new Properties();
//        prop.setProperty("index","emp.action.IndexAction");
        //위처럼 저장을 해야하지만, 이렇게 하면 기능이 하나 생길때마다 소스를 수정해야함

        //Properties의 load함수를 이용하여 내용들을 읽게하자 필요한 객체: inputStream
        FileInputStream fis = null;
        try{
            //action.properties파일과 연결되는 스트림 준비
            fis = new FileInputStream(realPath);
            prop.load(fis);//action.properties파일의 내용들을
            //읽어서 비어있던 Properties객체에 키와 값을 쌍으로 저장한다. ex) index -> emp.action.indexAction
        }catch(Exception e){
            e.printStackTrace();
        }
        //생성할 객체들의 경로가 모두 propertiesrㅐㄱ체로 저장됨
        //하지만 현재 컨트롤러 입장에선 생성할 개체가 몇개이며 어떤 객체인지 모름
        //Properties에 저장된 key를 모두 가져와서 반복자(interator)로 수행해야 한다.
        Iterator<Object> it = prop.keySet().iterator();

        //키들을 모두 얻었으니 키에 연결된 클래스경로들을 하나씩 얻어내어 객체를 생성한 후 actionMap에 저장하자
        while(it.hasNext()){
            //먼저 키 하나를 얻어내어 문자열로 변환
            String key = (String)it.next();
            //위에서 얻어낸 키와 연결된 값(value:클래스의경로)를 얻어내자
            String value = prop.getProperty(key);
            try{
                Action obj = (Action) Class.forName(value).newInstance();
                //쉽게 말해서 Class를 통해 정확한 클래스의 경로가 있다면 위와 같이 객체를 생성할 수 있다.

                //생성된 객체를 Action으로 형 변환시켜서
                // actionMap에 저장핮
                actionMap.put(key, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //type이라는 파라미터 받기
        String type = request.getParameter("type");
        //type이 전달되지 않아 null을 가지면 index로 초기화
        if(type == null)
            type = "index";
        //type으로 받은 값이 actionMap의 key로 사용되고 있으므로
        //원하는 객체를 얻어내자
        Action action = actionMap.get(type);

        String viewPath = action.execute(request, response);

        //viewPath가 null이면 현재 컨트롤러를 sendRedirect한다
        if(viewPath == null)
            response.sendRedirect("controller");
        else {
            //포워드로 이동
            RequestDispatcher disp = request.getRequestDispatcher(viewPath);
            disp.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
