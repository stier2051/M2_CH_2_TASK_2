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

        DBManager.connectToDb();
        System.out.println(request.getParameter("id"));
        Task editTask = DBManager.getTask(id);

        String taskName = editTask.getName();
        String taskDescription = editTask.getDescription();
        String taskStatus = editTask.getStatus();
        String taskDeadlineDate = editTask.getDeadlineDate();

        request.setAttribute("id", id.toString());
        request.setAttribute("taskName", taskName);
        request.setAttribute("taskDescription", taskDescription);
        request.setAttribute("taskStatus", taskStatus);
        request.setAttribute("taskDeadlineDate", taskDeadlineDate);

        request.getRequestDispatcher("/editTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskName = request.getParameter("taskTitle");
        System.out.println(taskName);
        String taskDescription = request.getParameter("taskDescription");
        String taskStatus = request.getParameter("taskStatus");
        String taskDeadlineDate = request.getParameter("deadlineDate");

        DBManager.connectToDb();
        DBManager.updateTask(id, taskName, taskDescription, taskStatus, taskDeadlineDate);
        request.setAttribute("tasks", DBManager.getAllTasks());
        request.getRequestDispatcher("/allTasks.jsp").forward(request, response);
    }
}
