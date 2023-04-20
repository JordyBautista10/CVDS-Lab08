package edu.eci.cvds.servlet.servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;
import edu.eci.cvds.servlet.servlets.Service;

@WebServlet(urlPatterns = "/mundoTaco")
public class ServletTwo extends HttpServlet {
    static final long serialVersionUID = 35L;
    ArrayList<Todo> todosList = new ArrayList<Todo>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            int idNumber = Integer.valueOf(req.getParameter("id"));
            Todo todo = Service.getTodo(idNumber);
            todosList.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            String mensajeTodos = Service.todosToHTMLTable(todosList);
            responseWriter.write(mensajeTodos);
            responseWriter.flush();
            resp.setContentType("text/html");
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: id no encontrado");
            } else if (e instanceof NumberFormatException) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: Valor no valido");
            } else if (e instanceof MalformedURLException) {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: " + e.getMessage());
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        try {
            int idNumber = Integer.valueOf(req.getParameter("id"));
            Todo todo = Service.getTodo(idNumber);
            ArrayList<Todo> todosList = new ArrayList<Todo>();
            todosList.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            String mensajeTodos = Service.todosToHTMLTable(todosList);
            responseWriter.write(mensajeTodos);
            responseWriter.flush();
            resp.setContentType("text/html");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof FileNotFoundException) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: id no encontrado");
            } else if (e instanceof NumberFormatException) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: Valor no valido");
            } else if (e instanceof MalformedURLException) {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: " + e.getMessage());
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseWriter.write("Numero de error: " + resp.getStatus() + "\n Localizacion: "
                        + e.getLocalizedMessage() + "\n Menssaje: " + e.getMessage());
            }
        }
    }
}
