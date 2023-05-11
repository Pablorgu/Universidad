<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 1/3/23
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autenticación</title>
</head>
<body>
<h1>Bienvenido al sistema:</h1>


<c:if test="${error != null}" >
    <p style="color:red;">
            ${error}
    </p>
</c:if>

<h6> Accediendo con el siguiente sessionid: <%= session.getId() %> </h6>
<form action="/" method="post">
<table>
    <tr>
        <td>Usuario:</td> <td><input type="text" name="usuario"></td>
    </tr>
    <tr>
        <td>Clave:</td> <td><input type="password" name="clave"> </td>
    </tr>
    <tr>
        <td colspan="2"> <button>Enviar</button></td>
    </tr>
</table>
</form>
</body>
</html>
