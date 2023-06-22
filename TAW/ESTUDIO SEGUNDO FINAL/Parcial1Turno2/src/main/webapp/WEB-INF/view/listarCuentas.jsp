<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 22/06/2023
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Cuentas del banco:</h1>

    <form:form method="get" action="/filtrar" modelAttribute="filtro">
        <table border="1">
            <tr>
                <td>Comisión: <form:select path="comision" items="${comisiones}" itemValue="tipoid" itemLabel="comision"/> </td>
                <td>Saldo > <form:input path="cantidad" maxlength="30" size="30"/></td>
                <td><form:button>Filtrar</form:button></td>
            </tr>
        </table>
    </form:form>
    <button><a href="/">Sin Filtro</a></button>

    <table border="1">
        <tr>
            <th>IBAN</th>
            <th>SALDO ACTUAL</th>
            <th>MOVIMIENTOS</th>
            <th>COMISIÓN APLICADA</th>
        </tr>
        <%for(CuentaEntity c: cuentas) {%>
        <tr>
            <td><a href="/cuenta?id=<%=c.getCuentaid()%>"><%=c.getIban()%></a></td>
            <td><%=c.getSaldoactual()%></td>
            <td>
                <%if(c.getMovimientosByCuentaid().isEmpty()){%>
                    Sin movimientos
                <%}else{ for(MovimientoEntity m: c.getMovimientosByCuentaid()) { %>
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
