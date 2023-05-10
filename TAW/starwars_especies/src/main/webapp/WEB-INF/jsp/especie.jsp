<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 16/04/2023
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Datos de la especie</h1>
<form:form action="/guardar" modelAttribute="especie" method="post">
  <form:input path="especie" size="30" maxlength="30"/><br/>
  <form:input path="pesoMedio" size="30" maxlength="30" /><br/>
  <form:input path="esperanzaVida" size="30" maxlength="30"/><br/>
  <form:input path="idioma" size="30" maxlength="30"/><br/>
  <form:radiobuttons path="familia" items=""
</form:form>
</body>
</html>
