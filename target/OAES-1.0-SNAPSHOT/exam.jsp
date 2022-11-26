<%@ page import="com.oaes.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: sanch
  Date: 26-11-2022
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div align="center">
    <h3><% if (((Student)request.getSession().getAttribute("student")).getTestStatus() == 0) { %>
        Please wait while exam coordinator starts your test
        <% } else { %>
        <p> Test has been started... </p>
    <% } %></h3>
  </div>
</body>
</html>
