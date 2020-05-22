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
    <title>Title</title>
</head>
<body>
<form method="post" action="Login.action">
    用户名：<input name="username" type="text"><br/>
    密码：<input name="password" type="password"> <br/>
    <input name="Submits" type="submit" value="登录"/>
    <input name="ReSet" type="reset" value="重置"/>
    <a href="regist.jsp"><input type="button"  value="注册"/></a>
</form>

</body>
</html>
