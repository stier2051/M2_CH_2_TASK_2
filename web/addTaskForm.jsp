<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.10.2021
  Time: 1:08
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
    <%@ include file="header.html"%>
    <div class="tasks">
        <div class="row">
            <div class="col">
                <form method="post" class="newForm">
                    <h5 class="task-name">Новое задание</h5>
                    <p class="label">Наименование:</p>
                    <input type="text" name="taskName" class="title" placeholder="Наименование" class="new-post">
                    <p class="label">Описание:</p>
                    <textarea name="taskDescription" cols="30" rows="10" placeholder="Описание"></textarea>
                    <p class="label">Крайний срок:</p>
                    <input type="date" name="deadlineDate" class="title" placeholder="Author" class="new-post">
                    <button type="submit" class="btn btn-primary submit-btn">Добавить</button>
                    <a href="main" class="btn btn-primary submit-btn">Отмена</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
