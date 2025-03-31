<%@ page import="es.taw.starwars.entity.Especie" %>
<%@ page import="es.taw.starwars.entity.Personaje" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 26/06/2023
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Especie e = (Especie) request.getAttribute("Especie");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Datos de la especie: </h1>
  <form:form action="/guardar" modelAttribute="Especie" method="post">
    <form:hidden path="especieId"></form:hidden>
    Nombre: <form:input path="especie" size="30" maxlength="30"></form:input><br/>
    Peso medio: <form:input path="pesoMedio" size="10" maxlength="10"></form:input><br/>
    Esperanza de vida: <form:input path="esperanzaVida" size="10" maxlength="10"></form:input><br/>
    Idioma: <form:input path="idioma" maxlength="40" size="40"></form:input><br/>
    Familia: <form:radiobuttons path="clasificacion" items="${familias}" itemValue="familiaId" itemLabel="familia" ></form:radiobuttons><br/>
    <form:button>Guardar</form:button>
  </form:form>
  <h2>Personajes de esta especie</h2>
  <%for (Personaje p:  e.getPersonajeList()) {%>
      <li><%=p.getNombre()%></li>
  <%}%>
</body>
</html>
