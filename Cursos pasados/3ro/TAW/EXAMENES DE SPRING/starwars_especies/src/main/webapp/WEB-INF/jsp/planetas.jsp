<%@ page import="java.util.List" %>
<%@ page import="es.taw.starwars.entity.Planeta" %>
<%@ page import="es.taw.starwars.entity.Especie" %>
<%@ page import="es.taw.starwars.entity.FamiliaEspecie" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 16/04/2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Planeta> planetas= (List<Planeta>) request.getAttribute("ListaPlanetas");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>PLANETA</th>
        <th>CLIMA</th>
        <th>TERRENO</th>
        <th>ESPECIES(familia)</th>
    </tr>
<%
    for(Planeta p:planetas) {
%>
    <tr>
        <% if(p.getClima() == null) p.setClima("");
            if(p.getTerreno()==null) p.setTerreno("");%>
        <td><%=p.getNombre()%></td>
        <td><%=p.getClima() != null ? p.getClima() : ""%></td>
        <td><%=p.getTerreno() != null ? p.getTerreno() : ""%></td>
        <td><% for(Especie e : p.getEspecieList()) {%>
        <%= e.getEspecie()%>(<%=e.getClasificacion().getFamilia()%>) </td>
        <%}%>
    </tr>

    <%}%>
</table>
</body>
</html>
