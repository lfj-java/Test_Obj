
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-7-25
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script>
        function del() {
            return confirm("del?");
        }
    </script>

</head>
<body>
<c:if test="${sessionScope.user eq null}"><c:redirect url="index.jsp"/> </c:if>
${sessionScope.user.username}
<a href="user_logout">退出</a>
<hr/>

<form action="book_add" method="post">
    title:<input name="book.title"><br>
    author:<input name="book.author"><br>
    amount:<input name="book.amount"><br>
    <input type="submit" value="添加">
</form>
<hr/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>TITLE</th>
        <th>AUTHOR</th>
        <th>AMOUNT</th>
        <th colspan="2">OPERATION</th>
    </tr>
    <c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
    <tr>
        <td>${vs.count}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.amount}</td>
        <td><a href="book_search?book.id=${book.id}">编辑</a></td>
        <td><a href="book_remove?book.id=${book.id}" onclick="return del()">删除</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>