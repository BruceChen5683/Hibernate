<%--
  Created by IntelliJ IDEA.
  User: chenjianliang
  Date: 2018/5/31
  Time: 上午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="updatePerson">
        username:<s:textfield name="username" value="%{#request.person.username}" readonly="true"></s:textfield><br>
        password:<s:textfield name="password" value="%{#request.person.password}" ></s:textfield><br>
        age:<s:textfield name="age" value="%{#request.person.age}"></s:textfield><br>
        registerDate:<s:textfield name="registerDate" value="%{#request.person.registerDate}" readonly="true"></s:textfield><br>
        <%--<s:textfield name="id" value="%{#request.person.id}" ></s:textfield><br>--%>
        <s:hidden name="id" value="%{#request.person.id}" ></s:hidden>
        <input type="submit" value="submit">
    </form>

</body>
</html>
