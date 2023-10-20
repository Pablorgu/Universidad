<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.Planeta" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.starwars.entity.Especie" %><%--
  Created by IntelliJ IDEA.
  User: itsso
  Date: 01/06/2023
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Planeta>listaplanetas = (List<Planeta>) request.getAttribute("listaplanetas");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Listado de planetas</h1>
<form:form method="post" modelAttribute="filtro" action="/filtro">
    Características del clima: <form:select path="clima">
                                    <form:option value="" label="------"/>
                                    <form:options items="${listaclimas}"/>
                                </form:select>
    <button>Filtrar</button>
</form:form>
<table border="1">
    <tr>
        <td>PLANETA</td>
        <td>CLIMA</td>
        <td>TERRENO</td>
        <td>ESPECIES(familia)</td>
    </tr>
<%for (Planeta p:listaplanetas){%>
    <tr>
        <td><%=p.getNombre()%></td>
        <td><%=p.getClima() == null ? "" : p.getClima()%> </td>
        <td><%=p.getTerreno()== null ? "" : p.getTerreno()%></td>
        <td><%for (Especie e:p.getEspecieList()) {%>
                <%if(e.getPlaneta().getPlanetaId() == p.getPlanetaId()){%>
            <a href="/editar?id=<%=e.getEspecieId()%>"><%=e.getEspecie()%></a> (<%=e.getClasificacion().getFamilia()%>)
            <%}
            }%></td>
    </tr>
<%}%>
</table>
</body>
</html>
