<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.Planeta" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.starwars.entity.Especie" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 01/06/2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Planeta> planetas = (List<Planeta>) request.getAttribute("planetas");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Listado de planetas: </h1>
  <form:form action="/filtrar" modelAttribute="filtro" method="post">
    <form:select path="clima">
      <form:option value="" label="------"/>
      <form:options items="${climas}"/>
    </form:select>
    <button>Filtrar</button>
  </form:form>
  <table border="1">
      <tr>
        <th>PLANETA</th>
        <th>CLIMA</th>
        <th>TERRENO</th>
        <th>ESPECIES(familia)</th>
      </tr>
    <%for(Planeta p : planetas) { %>
      <tr>
        <td><%=p.getNombre()%></td>
        <td><%=p.getClima() == null ? "" : p.getClima()%></td>
        <td><%=p.getTerreno() == null ? "" : p.getTerreno()%></td>
        <td>
        <% for(Especie e: p.getEspecieList()) { %>
          <a href="/editarespecie?id=<%=e.getEspecieId()%>"> <%=p.getEspecieList().isEmpty() ? "" : e.getEspecie()%></a> <%=" (" + e.getClasificacion().getFamilia() + ")"%>
        <%}%>
        </td>
      </tr>
    <%}%>
  </table>
</body>
</html>
