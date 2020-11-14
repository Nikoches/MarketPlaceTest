package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebFilter(displayName = "AuthFilter", servletNames = {"index", "test"})
public class AuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log(filterConfig.getFilterName() + " initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = "";
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();
        this.context.log("Requested Resource::" + uri);
        if (cookies != null || uri.endsWith("login.ftl") || uri.endsWith("login")) {
            username = Arrays.stream(req.getCookies())
                    .filter(s -> s.getName().equals("username"))
                    .map(Cookie::getValue)
                    .findFirst().orElse("notfound");
            if (username.equals("adm")) {
                chain.doFilter(request,response);
            }
        }else {
            this.context.log("Unauthorized access request");
            req.getRequestDispatcher("Views/test.ftl").forward(req, res);
        }
    }
}
