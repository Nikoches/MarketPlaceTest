package filters;

import service.ServiceMain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(displayName = "AuthFilter", servletNames = {"index", "saveCar"})
public class AuthenticationFilter implements Filter {
    private ServletContext context;
    private final static ServiceMain serviceMain =  ServiceMain.getServiceMain();
    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log(filterConfig.getFilterName() + " initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        boolean allowed = false;
        Cookie[] cookies = req.getCookies();
        this.context.log("Requested Resource::" + uri);
        //TODO сделать валидную авторизацию и добавление user_id
        if (cookies != null || uri.endsWith("login.ftl") || uri.endsWith("login")) {
            String username = Arrays.stream(req.getCookies())
                    .filter(s -> s.getName().equals("username"))
                    .map(Cookie::getValue)
                    .findFirst().orElse("notfound");
            allowed = serviceMain.authentificate(username);
            if(allowed) {
                HttpSession session = req.getSession();
                session.setAttribute("user_id","1");
                session.setAttribute("user_name",username);
                chain.doFilter(request,response);
            }
        }else if(!uri.endsWith("login.ftl") || !uri.endsWith("login")) {
            req.setAttribute("incorrect","nope");
        }
        if(!allowed) {
            this.context.log("Unauthorized access request");
            req.getRequestDispatcher("login").forward(req, res);
        }
    }
}
