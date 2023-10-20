<%@ page import="es.taw.junio2023.entity.TitulacionEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 27/06/2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<TitulacionEntity> titulaciones = (List<TitulacionEntity>) request.getAttribute("titulaciones");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Listado de titulaciones: </h1>
  <table border="1">
    <tr>
      <th>NIVEL</th>
      <th>TITULACIÓN</th>
      <th></th>
    </tr>
    <%for(TitulacionEntity t : titulaciones){%>
    <tr>
      <td><%=t.getNivelEstudiosByNivel().getNombre()%></td>
      <td><%=t.getNombre()%></td>
      <td><a href="/editar?id=<%=t.getIdtitulacion()%>">Editar</a></td>
    </tr>
    <%}%>
  </table>
</body>
</html>
