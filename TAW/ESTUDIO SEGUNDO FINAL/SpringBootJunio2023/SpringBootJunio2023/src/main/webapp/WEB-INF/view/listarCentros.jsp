<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.junio2023.entity.CentroEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 14/06/2023
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Listado de centros</h1>
    <form:form action="/titulaciones" modelAttribute="centroSeleccionado" method="get">
        <table>
            <tr>
                <td>
                    <form:radiobuttons path="idcentro" items="${centros}" itemValue="idcentro" itemLabel="nombre" /><br/>
                </td>
            </tr>
        </table>
        <input type="submit" value="Enviar" />
    </form:form>
</body>
</html>