<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 25/06/2023
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Lista de cuentas de clientes: </h1>
    <table border="1">
        <tr>
            <th>CLIENTE</th>
            <th>NIE</th>
            <th>IBAN</th>
            <th>SALDO ACTUAL</th>
            <th></th>
            <th></th>
        </tr>
        <%for(CuentaEntity c: cuentas) { %>
        <tr>
            <td><%=c.getClienteByTitular().getNombre() + " " +c.getClienteByTitular().getApellidos()%></td>
            <td><%=c.getClienteByTitular().getNie()%></td>
            <td><%=c.getIban()%></td>
            <td><%=c.getSaldoactual()%></td>
            <td><a href="/cambiarestado?id=<%=c.getCuentaid()%>"><%=c.getActiva()==1 ? "Desactivar" : "Activar"%></a></td>
            <td><a href="/transferencia?id=<%=c.getCuentaid()%>">Realizar transferencia</a></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
