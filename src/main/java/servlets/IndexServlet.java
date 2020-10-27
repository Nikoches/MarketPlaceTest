package servlets;



import persistence.implementation.PersistenceCars;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "default",urlPatterns = "/context")
public class IndexServlet extends HttpServlet {
    private static final PersistenceCars pers = new PersistenceCars();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("users", pers.findlAll());
        request.getRequestDispatcher("Views/index.ftl").forward(request, response);

    }


}
