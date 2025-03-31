<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaclienteEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 22/06/2023
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% CuentaEntity cuenta = (CuentaEntity) request.getAttribute("cuenta");%>
            <html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Datos de la cuenta corriente:</h1>
  <table border="1">
    <tr>
      <td>IBAN:</td>
      <td><%=cuenta.getIban()%></td>
    </tr>
    <tr>
      <td>FECHA CREACIÓN:</td>
      <td><%=cuenta.getFechacreacion()%></td>
    </tr>
    <tr>
      <td>SALDO:</td>
      <td><%=cuenta.getSaldoactual()%></td>
    </tr>
    <tr>
      <td>CLIENTES:</td>
      <td>
      <% for(CuentaclienteEntity c : cuenta.getCuentaclientesByCuentaid()) { %>
        <%=c.getClienteByClienteid().getNie()%> - <%=c.getClienteByClienteid().getNombrecompleto()%> (<a href="/cambiarRol?id=<%=c.getCuentaclienteid()%>"><%=c.getRolclienteByRolid().getDescripcion()%></a>)<a href="/eliminar?id=<%=c.getCuentaclienteid()%>">X</a><br/>
      <%}%>
      </td>
    </tr>
  </table>
  <a href="/">Volver al listado</a>
</body>
</html>
