<%@ page import="es.taw.starwars.entity.Personaje" %>
<%@ page import="es.taw.starwars.entity.Especie" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 01/06/2023
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Especie e = (Especie) request.getAttribute("Especie"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Datos de la especie</h1>
  <form:form action="/guardar" modelAttribute="Especie" method="post">
    <form:hidden path="especieId"/>
    <form:hidden path="idioma"/>
    <form:hidden path="planeta"/>
    Nombre: <form:input path="especie" maxlenght="30" size="30"  /><br/>
    Peso Medio:<form:input path="pesoMedio" maxlenght="30" size="30"/><br/>
    Esperanza de vida:<form:input path="esperanzaVida" maxlenght="30" size="30"/><br/>
    Familia: <form:radiobuttons path="clasificacion" items="${familias}" itemValue="familiaId" itemLabel="familia"/><br/>
    <button>Guardar</button>
  </form:form>

  <h1>Personajes de esa especie</h1>
  <%for(Personaje p: e.getPersonajeList()) { %>
      <li><%=p.getNombre()%></li>
  <%}%>
</body>
</html>
