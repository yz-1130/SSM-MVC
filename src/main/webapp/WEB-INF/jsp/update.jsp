<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    <table>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone" value="<%=request.getParameter("phone")%>"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="<%=request.getParameter("password")%>"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="username" value="<%=request.getParameter("username")%>"></td>
        </tr>
        <tr>
            <td>id</td>
            <td disabled="true"><input type="text" name="id" value="<%=request.getParameter("id")%>"></td>
        </tr>

    </table>
    <input type="submit" value="确认修改">
</form>
</body>
</html>