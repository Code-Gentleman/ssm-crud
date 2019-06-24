<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: l1nke
  Date: 2019/4/2
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <style>
        body {
            text-align: center;
        }
    </style>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <br><br><br><br>
    <h2>后台管理系统</h2>
    <br>
    <form action="${pageContext.request.contextPath}/user/checkLogin" method="post">
        用户名：<input type="text" name="username"/>
        <br>密码 ： &nbsp; <input type="password" name="password">
        <br><input type="submit" value="登录"><br>
    </form>
    <form action="${pageContext.request.contextPath}/user/toRegist" method="post">
        <input type="submit" value="注册">
    </form>

</div>
</body>
</html>
