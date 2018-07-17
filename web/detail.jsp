<%--
  Created by IntelliJ IDEA.
  User: chenjianliang
  Date: 2018/5/31
  Time: 上午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    username:<s:property value="#request.person.username"></s:property><br>
    password:<s:property value="#request.person.password"></s:property><br>
    age:<s:property value="#request.person.age"></s:property><br>
    registerDate:<s:property value="#request.person.registerDate"></s:property><br>
</body>
</html>
