<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.dao.MovimientoRepository" %>
<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 31/05/2023
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  List<CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <form:form action="/filtrar" modelAttribute="filtro" method="POST">
            <tr>
                <td>FILTRO</td>
                <td><form:select path="tipocomision" items="${tiposcomision}" itemLabel="comision" itemValue="tipoid"/></td>
            </tr>
            <tr>
                <td>
                Saldo:
            </td>
                <td>
                    <form:input path="cantidad" size="30" maxlength="30"/>
                </td>
            </tr>
    </table>
    <button>Filtrar</button>
    </form:form>
        <br/><button><a href="/">Sin filtro</a> </button>
    <table border="1">
        <tr>
            <th>IBAN</th>
            <th>SALDO ACTUAL</th>
            <th>MOVIMIENTOS</th>
            <th>COMISIÓN APLICADA</th>
        </tr>
        <% for (CuentaEntity c : cuentas) { %>
        <tr>
            <td><a href="/detalles?id=<%=c.getCuentaid()%>"><%=c.getIban()%></a></td>
            <td><%=c.getSaldoactual()%></td>
            <td>
                <%if(c.getMovimientosByCuentaid().isEmpty()){ %>
                Sin movimientos
                <%}else{%>
                    <%for(MovimientoEntity  m : c.getMovimientosByCuentaid()) { %>
                        <%=m.getFecha() + " - " + m.getDescripcion() + " - (" + m.getCantidad() + ")"%><br/>
                    <%}%>
                <%}%>
            </td>
            <td><%=c.getTipocomisionByComision().getComision()%></td>
        </tr>
            <%}%>
    </table>
</body>
</html>
