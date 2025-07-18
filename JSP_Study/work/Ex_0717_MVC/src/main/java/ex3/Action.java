package ex3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
