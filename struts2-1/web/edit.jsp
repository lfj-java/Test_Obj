<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-7-24
  Time: 下午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="book_update" method="post">
    <input type="hidden" name="book.id" value="${sessionScope.book.id}">
    title:<input name="book.title" value="${sessionScope.book.title}"><br>
    author:<input name="book.author" value="${sessionScope.book.author}"><br>
    amount:<input name="book.amount" value="${sessionScope.book.amount}"><br>
    <input type="submit" value="UPDATE">
</form>

</body>
</html>
