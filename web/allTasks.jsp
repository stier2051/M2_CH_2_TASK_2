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
<head>
    <!-- Bootstrap Reboot CSS -->
    <link rel="stylesheet" href="css/bootstrap-reboot.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Main CSS -->
    <link rel="stylesheet" href="css/main.css">
    <title>Main</title>
</head>
<body>
<div class="container">
    <header class="header">
        <div class="heading">
            <div class="row justify-content-start align-items-center">
                <div class="col-lg-3">
                    <a href="main" class="logo">TASK MANAGER</a>
                </div>
                <div class="col-lg-2">
                    <a href="#" class="all-tasks">Все задания</a>
                </div>
            </div>
        </div>
    </header>
    <div class="add">
        <div class="row">
            <div class="col">
                <a href="new-task" class="btn btn-primary add-task">+ Добавить задание</a>
            </div>
        </div>
    </div>
    <div class="tasks-table">
        <div class="table-heading">
            <div class="row">
                <div class="col-lg-1 text-center">
                    <h6>ID</h6>
                </div>
                <div class="col-lg-6">
                    <h6>Наименование</h6>
                </div>
                <div class="col-lg-2 text-center">
                    <h6>Крайний срок</h6>
                </div>
                <div class="col-lg-2 text-center">
                    <h6>Выполнено</h6>
                </div>
                <div class="col-lg-1 text-center">
                    <h6>Детали</h6>
                </div>
            </div>
        </div>

        <%
            ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("tasks");
            for (Task task : tasks) {
                out.println("<div class=\"table-row\">");
                out.println("<div class=\"row align-items-center\">");
                out.println("<div class=\"col-lg-1 text-center\">");
                out.println("<p>" + task.getId() + "</p>");
                out.println("</div>");
                out.println("<div class=\"col-lg-6\">");
                out.println("<p>" + task.getName() + "</p>");
                out.println("</div>");
                out.println("<div class=\"col-lg-2 text-center\">");
                out.println("<p>" + task.getDeadlineDate() + "</p>");
                out.println("</div>");
                out.println("<div class=\"col-lg-2 text-center\">");
                out.println("<p>Да</p>");
                out.println("</div>");
                out.println("<div class=\"col-lg-1 text-center\">");
                out.println("<a href=\"#\" class=\"btn btn-primary details\">Детали</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
            }
        %>


<%--        <div class="table-row">--%>
<%--            <div class="row align-items-center">--%>
<%--                <div class="col-lg-1 text-center">--%>
<%--                    <p>1</p>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6">--%>
<%--                    <p>Сделать ДЗ по Java EE</p>--%>
<%--                </div>--%>
<%--                <div class="col-lg-2 text-center">--%>
<%--                    <p>18.10.2021</p>--%>
<%--                </div>--%>
<%--                <div class="col-lg-2 text-center">--%>
<%--                    <p>Да</p>--%>
<%--                </div>--%>
<%--                <div class="col-lg-1 text-center">--%>
<%--                    <a href="#" class="btn btn-primary details">Детали</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>
