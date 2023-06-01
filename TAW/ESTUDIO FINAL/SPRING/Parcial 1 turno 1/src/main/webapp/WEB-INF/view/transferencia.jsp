<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 31/05/2023
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="cabecera.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Realizar transferencia entre cuentas:</h1>
<form:form action="/guardar" method="post" modelAttribute="movimiento">
    <form:hidden path="operacionid"/>
    <form:hidden path="cuentaByCuentaorigen"/>
    Destinatario: <form:select path="cuentaByCuentadestinatario" itemValue="cuentaid" itemLabel="iban" items="${ibanes}"/><br/>
    Descripcion: <form:input path="descripcion" size="30" maxlength="30"/><br/>
    Cantidad: <form:input path="cantidad" size="30" maxlength="30"/><br/>
    <form:button>Guardar</form:button>
</form:form>
</body>
</html>