<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="es.taw.sampletaw.dao.CuentaclienteRepository" %>
<%@ page import="es.taw.sampletaw.entity.CuentaclienteEntity" %>
<%@ page import="es.taw.sampletaw.dao.ClienteRepository" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 31/05/2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% CuentaEntity cuenta = (CuentaEntity) request.getAttribute("cuenta");
   List<ClienteEntity> clientes = (List<ClienteEntity>) request.getAttribute("clientes");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
        <% for(ClienteEntity cl: clientes){
            for(CuentaclienteEntity cu : cuenta.getCuentaclientesByCuentaid()){
                if(cl.getCuentaclientesByClienteid() == cu.getClienteByClienteid().getCuentaclientesByClienteid()) {%>
        <%=cl.getNie() + " - " + cl.getNombrecompleto() + " - ("%><a href="/cambiarRol?id=<%=cu.getCuentaclienteid()%>"><%=cu.getRolclienteByRolid().getDescripcion()%></a> <%=") "%><a href="/eliminarcliente?id=<%=cu.getCuentaclienteid()%>">X</a><br/>
                <%}
            }
        }%>
      </td>
    </tr>
  </table>
<a href="/">Volver al listado</a>
</body>
</html>
