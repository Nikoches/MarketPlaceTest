package servlets;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet(urlPatterns = "/load",name = "load")
public class DownloadServlet extends HttpServlet {
    private String path = "";
    @Override
    public void init() {
        this.path = getServletContext().getInitParameter("upload_path");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = getServletContext().getInitParameter("upload_path");
        String name = req.getParameter("name");
        resp.setContentType("name=" + name);
        resp.setContentType("image/jpeg");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        File file = new File(path + File.separator + name);
        try (FileInputStream in = new FileInputStream(file)) {
            resp.getOutputStream().write(in.readAllBytes());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}