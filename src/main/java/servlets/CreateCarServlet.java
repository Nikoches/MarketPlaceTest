package servlets;

import models.auto.Car;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ServiceMain;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/saveCar", name = "saveCar")
public class CreateCarServlet extends HttpServlet {
    private ServletFileUpload uploader = null;
    private String path = "";
    private ServiceMain serviceMain;

    @Override
    public void init() {
        serviceMain = ServiceMain.getServiceMain();
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = new File(getServletContext().getInitParameter("upload_path"));
        path = getServletContext().getInitParameter("upload_path");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("Views/createCar.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (!ServletFileUpload.isMultipartContent(req)) {
            throw new ServletException("Content type is not multipart/form-data");
        }
        try {
            String username = Arrays.stream(req.getCookies())
                    .filter(s -> s.getName().equals("username"))
                    .map(Cookie::getValue)
                    .findFirst().orElse("notfound");
            serviceMain.createCar(uploader.parseRequest(req), getServletContext().getInitParameter("upload_path"), username);
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        resp.sendRedirect("index");
    }
}
