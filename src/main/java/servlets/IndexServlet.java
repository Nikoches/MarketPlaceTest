package servlets;

import service.ServiceMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "index", urlPatterns = "/index")
@ServletSecurity()
public class IndexServlet extends HttpServlet {
    private static final ServiceMain serviceMain = ServiceMain.getServiceMain();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List carsList;
        Optional<String> act = Optional.ofNullable(request.getParameter("action"));
        Optional<String> carNum = Optional.ofNullable(request.getParameter("modelNum"));
        if (act.isPresent()) {
            carsList = serviceMain.getCarsByCriteria(act.get(), carNum.orElse("null"));
        }else {
            carsList = serviceMain.getListGeneral("cars");
        }
        request.setAttribute("cars", carsList);
        request.getRequestDispatcher("Views/index.ftl").forward(request, response);
    }

}
