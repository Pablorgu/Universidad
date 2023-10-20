<%@ page import="es.taw.junio2023.entity.AsignaturaEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 21/06/2023
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<AsignaturaEntity> asignaturas = (List<AsignaturaEntity>) request.getAttribute("asignaturas");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Datos de la titulacion</h1>
    <form:form action="/guardar" modelAttribute="titulacion" method="post">
        <table border="1">
            <form:hidden path="idtitulacion"/>
           <tr>
               <td>NOMBRE:</td>
               <td><form:input path="nombre" size="50" maxlength="50"/> </td>
           </tr>
            <tr>
                <td>CENTRO: </td>
                <td>${titulacion.centroByCentro.nombre}</td>
            </tr>
            <tr>
                <td>NIVEL: </td>
                <td>${titulacion.nivelEstudiosByNivel.nombre}</td>
            </tr>
            <tr>
                <td>ASIGNATURA:</td>
                <td><form:checkboxes path="asignaturaByAsignatura" items="${asignaturas}" itemLabel="nombre" delimiter="<br>"/> </td>
            </tr>
        </table>
        <form:button>Guardar</form:button>
    </form:form>
</body>
</html>
