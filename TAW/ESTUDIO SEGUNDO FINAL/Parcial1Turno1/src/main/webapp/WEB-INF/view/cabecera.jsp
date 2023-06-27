<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 25/06/2023
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  MovimientoEntity movimiento = (MovimientoEntity) request.getAttribute("movimiento");
    CuentaEntity cuenta = movimiento.getCuentaByCuentaorigen();%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Nombre: <%=cuenta.getClienteByTitular().getApellidos() + ", " + cuenta.getClienteByTitular().getNombre()%></td>
            <td>NIE: <%=cuenta.getClienteByTitular().getNie()%></td>
            <td>Teléfono: <%=cuenta.getClienteByTitular().getTelefono()%></td>
            <td>Cuenta: <%=cuenta.getIban()%></td>
        </tr>
    </table>
</body>
</html>
