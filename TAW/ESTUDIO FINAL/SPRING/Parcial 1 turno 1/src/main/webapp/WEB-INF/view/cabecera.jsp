<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 31/05/2023
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
    CuentaEntity cuenta = (CuentaEntity) request.getAttribute("cuenta");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Nombre: <%=cliente.getNombre() + ", " + cliente.getApellidos()%></td>
        <td>NIE: <%=cliente.getNie()%></td>
        <td>Teléfono: <%=cliente.getTelefono()%></td>
        <td>Cuenta: <%=cuenta.getIban()%></td>
    </tr>
</table>
</body>
</html>
