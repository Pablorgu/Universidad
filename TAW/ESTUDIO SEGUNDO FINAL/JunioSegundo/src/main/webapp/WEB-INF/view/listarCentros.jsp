<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 27/06/2023
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Listado de centros: </h1>
  <form:form action="/titulacion" modelAttribute="centroSeleccionado" method="get">
    <form:radiobuttons path="idcentro" items="${centros}" itemLabel="nombre" itemValue="idcentro" delimiter="<br>"></form:radiobuttons><br/>
    <form:button>Enviar</form:button>
  </form:form>
</body>
</html>
