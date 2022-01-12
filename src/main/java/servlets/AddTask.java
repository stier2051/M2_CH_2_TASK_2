package servlets;

import db.DBManager;
import model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddTask", value = "/add-task")
public class AddTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("taskName");
        String description = request.getParameter("taskDescription");
        String status = "no";
        String deadline = request.getParameter("taskDeadline");
        DBManager.addNewTask(new Task(null, name, description, status, deadline));
        response.sendRedirect("/main");
    }
}
