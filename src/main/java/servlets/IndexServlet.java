package servlets;


import models.auto.Car;
import persistence.implementation.PersistenceCars;
import service.ServiceMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "default", urlPatterns = "/context")
public class IndexServlet extends HttpServlet {
    private static final ServiceMain serviceMain = ServiceMain.getServiceMain();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List carsList =  serviceMain.getListGeneral("cars");
        request.setAttribute("cars", carsList);
        request.getRequestDispatcher("Views/index.ftl").forward(request, response);
    }
}
