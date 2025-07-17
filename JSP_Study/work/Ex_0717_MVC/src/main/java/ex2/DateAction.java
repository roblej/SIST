package ex2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class DateAction {
    public String execute(HttpServletRequest request, HttpServletResponse response){
        LocalDate date = LocalDate.now();

        request.setAttribute("date",date.toString());
        //forward될 request에 date라는 이름으로 저장!

        //보여질 jsprㅕㅇ로를 반환하자
        return "/ex2/page1.jsp";
    }
}
