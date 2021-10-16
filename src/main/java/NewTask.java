import db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "new-task", value = "/new-task")
public class NewTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addTaskForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connectToDb();

        String taskName = request.getParameter("taskName");
        String taskDescription = request.getParameter("taskDescription");
        String taskDeadlineDate = request.getParameter("deadlineDate");

        DBManager.addNewTask(taskName, taskDescription, taskDeadlineDate);
        request.getRequestDispatcher("/addTaskForm.jsp").forward(request, response);
    }
}
