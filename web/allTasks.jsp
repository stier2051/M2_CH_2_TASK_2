<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.10.2021
  Time: 0:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@ include file="header.html"%>
    <div class="add">
        <div class="row">
            <div class="col">
                <a href="" class="btn btn-primary add-task" data-bs-toggle="modal" data-bs-target="#addNewTask">+ New Task</a>
            </div>
        </div>
    </div>
    <div class="tasks-table">
        <div class="row">
            <div class="col">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Task Name</th>
                        <th scope="col">Deadline</th>
                        <th scope="col">Status</th>
                        <th scope="col" class="text-center">Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("tasks");
                        for (Task task : tasks) {
                    %>
                    <tr>
                        <th scope="row"><%=task.getId()%></th>
                        <td><%=task.getName()%></td>
                        <td><%=task.getDeadlineDate()%></td>
                        <td><%=task.getStatus()%></td>
                        <td class="text-center">
                            <a href="edit-task?id=<%=task.getId()%>" class="btn btn-primary details">Details</a>
                            <a href="delete-task?id=<%=task.getId()%>" class="btn btn-danger details">Delete</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="addNewTask">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add new task</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/add-task" method="post">
                        <div class="mb-3">
                            <label for="taskName" class="form-label">Name</label>
                            <input type="text" name="taskName" class="form-control" id="taskName">
                        </div>
                        <div class="mb-3">
                            <label for="taskDescription" class="form-label">Description</label>
                            <textarea name="taskDescription" id="taskDescription" cols="30" rows="5"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="taskDeadline" class="form-label">Deadline</label>
                            <input type="date" name="taskDeadline" class="form-control" id="taskDeadline">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Add Task</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
