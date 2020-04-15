<%@ page import="com.lagou.edu.pojo.User" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Title</title>

</head>

<body>



<a href="toInsert" >增加 </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<span>用户：<%=session.getAttribute("sno")%></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<span>浏览量：<%=application.getAttribute("count")%></span>

<table>

    <tr>

        <td>学号</td>

        <td>密码</td>

        <td>姓名</td>

        <td></td>

    </tr>
  <%
      List<User> users = (List<User>) request.getAttribute("userList");
      for(int i = 0;i<users.size();i++) {
          User user = users.get(i);

  %>
    <tr>
        <td><%=user.getId()%></td>

        <td><%=user.getPassword()%></td>

        <td><%=user.getUsername()%></td>

        <td><a href="toUpdate?id=<%=user.getId()%>
        &&password=<%=user.getPassword()%>
        &&username=<%=user.getUsername()%>
        &&phone="<%=user.getPhone()%>>修改</a>
         <a href="toDelete?id=<%=user.getId()%>">删除</a></td>
    </tr>
    <%}%>

</table>



</body>

</html>