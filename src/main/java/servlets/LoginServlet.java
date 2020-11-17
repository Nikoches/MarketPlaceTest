package servlets;

import service.ServiceMain;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    final ServiceMain serviceMain = ServiceMain.getServiceMain();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Views/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> userlogin = Optional.ofNullable(req.getParameter("username"));
        Optional<String> act = Optional.ofNullable(req.getParameter("act"));
        if ((act.orElse("undefined").equals("login"))) {
            if (userlogin.orElse("undefined").equals("adm")) {
                Cookie userName = new Cookie("username", req.getParameter("username"));
                userName.setMaxAge(30 * 60);
                resp.addCookie(userName);
                req.getRequestDispatcher("Views/index.ftl").forward(req,resp);
            }
        } else {
            if(!(req.getCookies() == null)) {
                Arrays.stream(req.getCookies()).peek(cookie -> cookie.setMaxAge(0)).close();
            }
            req.getRequestDispatcher("Views/login.ftl").forward(req,resp);
        }
    }
}
