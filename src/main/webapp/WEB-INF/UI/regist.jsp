<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/5/20
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My JSP 'regist.jsp' starting page</title>
</head>
<body>
<body>
    註冊
    <br>
    <form action="regist.action" method="post">
        邮箱:<input type="text" id="email" name="email" οnblur="checkEmail()"><p id="emailMes"></p>
        <br />用户名:<input type="text" id="userName" name="userName" οnblur="checkUserName()"><p id="nameMes"></p>
        <br /> 密码:<input type="text" name="pass" value="">
        <br /> <input type="submit" name="submit" value="注册">
</form>

</body>
</html>
