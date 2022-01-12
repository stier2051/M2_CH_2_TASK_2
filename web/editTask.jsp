<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.10.2021
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@ include file="header.html"%>
    <div class="tasks">
        <div class="row">
            <div class="col">
                <%
                    Task task = (Task) request.getAttribute("task");
                %>
                <form action="/edit-task?id=<%=task.getId()%>" method="post">
                    <div class="mb-3">
                        <label for="taskName" class="form-label">Name</label>
                        <input type="text" value="<%=task.getName()%>" name="taskName" class="form-control" id="taskName">
                    </div>
                    <div class="mb-3">
                        <label for="taskDescription" class="form-label">Description</label>
                        <textarea name="taskDescription" id="taskDescription" cols="30" rows="5"><%=task.getDescription()%></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="taskDeadline" class="form-label">Deadline</label>
                        <input type="date" value="<%=task.getDeadlineDate()%>" name="taskDeadline" class="form-control" id="taskDeadline">
                    </div>
                    <div class="mb-3">
                        <label for="taskStatus" class="form-label">Status</label>
                        <select name="taskStatus" id="taskStatus">
                            <option value="<%=task.getStatus()%>"><%=task.getStatus()%></option>
                            <option value="<%=task.getStatus().equals("yes")?"no":"yes"%>"><%=task.getStatus().equals("yes")?"no":"yes"%></option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="main" class="btn btn-secondary">Close</a>
                        <button type="submit" class="btn btn-primary">Save Task</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
