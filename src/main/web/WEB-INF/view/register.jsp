<%--
  Created by IntelliJ IDEA.
  User: l1nke
  Date: 2019/4/2
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
