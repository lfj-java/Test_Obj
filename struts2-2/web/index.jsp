<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form action="user_login" method="post">
      用户名：<input name="user.username"><br>
      密码：<input type="password" name="user.password"><br>
      <input type="submit" value="登录">
      <a href="signup.jsp">注册</a>

  </form>
  <em style="color: red;">${requestScope.message}</em><br>
  </body>
</html>