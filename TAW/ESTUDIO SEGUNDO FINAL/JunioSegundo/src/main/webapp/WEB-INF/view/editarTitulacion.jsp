<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 27/06/2023
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Datos de la titulación: </h1>
  <form:form action="/guardar"  modelAttribute="titulacion" method="post" >
    <form:hidden path="idtitulacion"></form:hidden>
  <table border="1">
    <tr>
      <td>NOMBRE: </td>
      <td><form:input path="nombre" size="50" maxlength="50"></form:input></td>
    </tr>
    <tr>
      <td>ASIGNATURAS: </td>
      <td><form:checkboxes path="asignaturaByAsignatura" items="${asignaturas}" itemLabel="nombre" delimiter="<br/>"></form:checkboxes></td>
    </tr>
  </table>
    <form:button>Guardar</form:button>
  </form:form>
</body>
</html>
