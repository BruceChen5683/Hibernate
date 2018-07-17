<%--
  Created by IntelliJ IDEA.
  User: chenjianliang
  Date: 2018/5/30
  Time: 下午10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table width="80%" align="center" border="1">
        <tr>
            <th>username</th>
            <th>password</th>
            <th>age</th>
            <th>registerDate</th>
            <th>update</th>
            <th>delete</th>
        </tr>

        <%--<s:iterator value="#request['list']"></s:iterator>--%>
        <%--request中的list为HttpServletRequest中属性--%>
        <%--id="person" 当前迭代的对象person--%>
        <s:iterator value="#request.list" id="person">
            <tr>
                <td>
                    <s:a href="getSinglePerson.action?id=%{#person.id}"><s:property value="username"></s:property></s:a>
                </td>
                <td>
                    <s:property value="password"></s:property>
                </td>
                <td>
                    <s:property value="age"></s:property>
                </td>
                <td>
                    <s:property value="registerDate"></s:property>
                </td>

                <td>
                    <s:a href="willupdatePerson.action?id=%{#person.id}"><input type="button" value="Update" align="center"></s:a>
                </td>
                <td>
                    <s:a href="deletePerson.action?id=%{#person.id}"><input type="button" value="Delete" align="center"></s:a>
                </td>
            </tr>

        </s:iterator>

    </table>
</body>
</html>
