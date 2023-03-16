package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/mundoTaco")
public class Servlet2 extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write("Hello" + name + "!");
            responseWriter.flush();
            resp.setContentType("text/html");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
