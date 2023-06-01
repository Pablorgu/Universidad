<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.controller.CuentaController" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 31/05/2023
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<CuentaEntity> lista = (List<CuentaEntity>) request.getAttribute("cuentas");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Lista de cuentas de clientes</h1>
    <table border="1">
        <tr>
            <th>CLIENTE</th>
            <th>NIE</th>
            <th>IBAN</th>
            <th>SALDO ACTUAL</th>
            <th></th>
            <th></th>
        </tr>

        <%
            for(CuentaEntity cuenta:lista) {
                String estado;
                if(cuenta.getActiva()==1) {
                    estado="Desactivar";
                } else {
                    estado="Activar";
                }
        %>
        <tr>
            <td><%=cuenta.getClienteByTitular().getApellidos()%></td>
            <td><%=cuenta.getClienteByTitular().getNie()%></td>
            <td><%=cuenta.getIban()%></td>
            <td><%=cuenta.getSaldoactual()%></td>
            <td><a href="/cambiarestado?id=<%=cuenta.getCuentaid()%>"><%=estado%></a></td>
            <td><a href="/realizartransferencia?id=<%=cuenta.getCuentaid()%>">Realizar trasferencia</a></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
