package servlets;

import db.DBManager;
import model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "edit-task", value = "/edit-task")
public class EditTask extends HttpServlet {

    Long id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        id = Long.parseLong(request.getParameter("id"));
        Task task = DBManager.getTask(id);
        request.setAttribute("task", task);
        request.getRequestDispatcher("/editTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("taskName");
        String description = request.getParameter("taskDescription");
        String status = request.getParameter("taskStatus");
        String deadline = request.getParameter("taskDeadline");
        DBManager.updateTask(new Task(id, name, description, status, deadline));
        response.sendRedirect("/main");
    }
}
