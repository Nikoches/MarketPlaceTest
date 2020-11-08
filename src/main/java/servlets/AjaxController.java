package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Access-Control-Allow-Origin", "*");
           // resp.getWriter().write(cinService.getJsonTable());
        }

}
