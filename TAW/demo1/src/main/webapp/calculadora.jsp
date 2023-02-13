<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 13/2/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String resultado="";
  if (request.getAttribute("result") != null){
    double res = (double) request.getAttribute("result");
    resultado = res + "";
  }
%>
<h1> Introduzca los datos</h1>

<%
  if (request.getAttribute("result") != null) {
%>
  El resultado es: <%= resultado%>
</body>
</html>
