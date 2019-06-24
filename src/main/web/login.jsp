<%--
  Created by IntelliJ IDEA.
  User: l1nke
  Date: 2019/4/15
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>绿化员工管理系统</title>
</head>
<body>
<div>
    <h4 style="text-align: center;">绿化员工管理系统-后台登录</h4>
    <form action="/shiro/login" method="post" style="text-align: center">
        用户名 : <input type="text" name="username"/><br><br>
        密码 : &nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" /><br><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
