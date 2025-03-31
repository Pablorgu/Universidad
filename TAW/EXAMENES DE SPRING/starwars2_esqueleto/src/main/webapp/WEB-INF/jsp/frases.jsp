<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.starwars.entity.FraseCelebre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 12/04/2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<FraseCelebre> lista =(List<FraseCelebre>) request.getAttribute("ListaFrase");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="filt" action="/filtrar">
    Ordenar por: <form:checkbox path="pelicula" label="Pelicula"></form:checkbox>
    <form:checkbox path="personaje" label="Personaje"></form:checkbox>
    <form:button>Filtrar</form:button>
</form:form>
<table border="1">

    <tr>

        <th>Personaje</th>

        <th>Frases</th>

        <th>Película</th>

    </tr>
    <%for(FraseCelebre f : lista){%>
    <tr>

        <td><%=f.getPersonaje().getNombre()%></td>

        <td><%=f.getFrase()%></td>

        <td> <a href="/pelicula?id=<%= f.getPelicula().getPeliculaId()%>"> <%=f.getPelicula().getTitulo()%></a></td>

    </tr>
    <%}%>

</table border="1">
</body>
</html>
