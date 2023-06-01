<%@ page import="es.taw.starwars.entity.Personaje" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 01/06/2023
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Personaje> listapersonajes = (java.util.List<Personaje>) request.getAttribute("listapersonajes");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/guardar" modelAttribute="especieat" method="post">
  <form:hidden path="especieId"/>
  <form:hidden path="planeta"/>
  Nombre:<form:input path="especie"/><br><!--Nombre de la especie-->
  Peso medio:<form:input path="pesoMedio"/><br>
  Esperanza de vida:<form:input path="esperanzaVida"/><br>
  Idioma:<form:input path="idioma"/><br>
  Familia: <form:radiobuttons path="clasificacion" items="${familiaEspecie}" itemLabel="familia" itemValue="familiaId"/><br>
  <form:button>Guardar</form:button>
</form:form>
<h1>Personajes de esa especie</h1>
<ul>
  <%for (Personaje p:listapersonajes) {%>
  <li><%=p.getNombre()%></li>
  <%}%>
</ul>
</body>
</html>
