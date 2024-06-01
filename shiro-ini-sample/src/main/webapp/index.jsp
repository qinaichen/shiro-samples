<%--
  Created by IntelliJ IDEA.
  User: qinaichen
  Date: 2024/5/30
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/shiro.tld" %>
<html>
<head>
    <title>Shiro ini 范例</title>
</head>
<body>
    <h1> hello  <shiro:principal></shiro:principal> </h1>
 <ul>
    <shiro:user>

        <li><a href="/user/index.jsp">用户列表</a></li>
        <shiro:hasPermission name="user:add">
            <li><a href="/user/add.jsp">用户添加</a></li>
        </shiro:hasPermission>
        <shiro:hasRole name="admin">
            <li><a href="/admin/index.jsp">管理页面</a></li>
        </shiro:hasRole>
        <li><a href="/logout">退出系统</a></li>
    </shiro:user>
 </ul>
</body>
</html>
