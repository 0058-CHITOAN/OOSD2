<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="vn.edu.hcmuaf.fit.demo3.User" %>
<html>
<head>
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="alert alert-success text-center">
        <h1>Chào mừng bạn đã đăng nhập thành công!</h1>
        <%
            User user = (User) session.getAttribute("user");
            if (user != null) {
        %>
        <p>Xin chào, <strong><%= user.getUsername() %></strong>!</p>
        <p>Vai trò: <strong><%= user.getRole() %></strong></p>
        <%
            }
        %>
    </div>
</div>
</body>
</html>