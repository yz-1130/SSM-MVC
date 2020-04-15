<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Title</title>

</head>

<body>

<form action="LoginServlet" method="post">

    <div class="log">

        <h2>登录</h2>

        学号：<input type="text" name="sno"><br>

        密码：<input type="password" name="password"> <br>

        <input type="submit" value="确认登录">

        <a href="register.jsp" >注册</a>

    </div>

</form>

</body>

</html>