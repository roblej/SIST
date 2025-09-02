package spring.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //반환값 준비
        boolean result = true;

        //로그인 체크를 해서 만약 로그인이 안된 상태이면, result에 false를 저장한다
        //먼저 로그인 체크를 하기 위해 HttpSession을 얻어낸다
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("mvo");

        if(obj == null){
            result = false;
            response.sendRedirect("/login");
        }



        return result;
        //true를 반환하면 원래 가려고 했던 경로로 진행을 계속하지만,
        //false면 원래의 경로로 진행하지 못한다.
    }
}
