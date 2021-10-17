<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.10.2021
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900&amp;subset=cyrillic" rel="stylesheet">
    <!-- Bootstrap Reboot CSS -->
    <link rel="stylesheet" href="css/bootstrap-reboot.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Main CSS -->
    <link rel="stylesheet" href="css/main.css">
    <title>Document</title>
</head>
<body>
<div class="container">
    <header class="header">
        <div class="heading">
            <div class="row justify-content-start align-items-center">
                <div class="col-lg-3">
                    <a href="#" class="logo">TASK MANAGER</a>
                </div>
                <div class="col-lg-2">
                    <a href="main" class="all-tasks">Все задания</a>
                </div>
            </div>
        </div>
    </header>
    <div class="tasks">
        <div class="row">
            <div class="col">
                <form action="/edit-task" method="post" class="newForm">
                    <%
                        String id = (String) request.getAttribute("id");
                        String name = (String) request.getAttribute("taskName");
                        String description = (String) request.getAttribute("taskDescription");
                        String deadlineDate = (String) request.getAttribute("taskDeadlineDate");
                    %>
                    <p class="label">Наименование:</p>
                    <%
                        out.println("<input type=\"text\" name=\"taskTitle\" class=\"title\" class=\"new-post\" value=\"" + name + "\">");
                    %>
                    <p class="label">Описание:</p>
                    <%
                        out.println("<textarea name=\"taskDescription\" cols=\"30\" rows=\"10\">" + description + "</textarea>");
                    %>
                    <p class="label">Крайний срок:</p>
                    <%
                        out.println("<input type=\"date\" name=\"deadlineDate\" class=\"title\" placeholder=\"Author\" class=\"new-post\" value=\"" + deadlineDate + "\">");
                    %>
                    <p class="label">Выполнено:</p>
                    <select name="status">
                        <option value="no">Нет</option>
                        <option value="yes">Да</option>
                    </select>
                    <button type="submit" class="btn btn-success edit-btn">Сохранить</button>
                    <%
                        out.println("<a href=\"delete-task?id=" + id + "\"class=\"btn btn-danger edit-btn\">Удалить</a>");
                    %>

<%--                    <button type="button" class="btn btn-danger edit-btn">Удалить</button>--%>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
