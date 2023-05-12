<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="es.taw.sampletaw.dto.PurchaseOrderDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 28/3/23
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Purchase order</title>
</head>
<body>
<%
    List<PurchaseOrderDTO> pedidos = (List<PurchaseOrderDTO>) request.getAttribute("pedidos");
%>

<jsp:include page="cabecera.jsp"/>

<h1>Pedidos del cliente: </h1>

<%
    if (pedidos != null && !pedidos.isEmpty()) {
%>

<table border="1">
    <tr>
        <th>ORDER</th>
        <th>PRODUCTO</th>
        <th>COSTE DEL PRODUCTO</th>
        <th>COSTE DE ENVÍO</th>
        <th>FECHA DE VENTA</th>
    </tr>

<%
        for (PurchaseOrderDTO po: pedidos) {
%>
    <tr>
        <td><%= po.getOrderNum() %></td>
        <td><%= po.getProduct().getDescription() %></td>
        <td><%= po.getProduct().getPurchaseCost() %></td>
        <td><%= po.getShippingCost() %></td>
        <td><%= po.getShippingDate() %></td>
    </tr>
    <%
        }
    %>

</table>

<%
    }
%>

<a href="/purchaseOrder/nuevo/${idcliente}">Nuevo pedido ...</a>

</body>
</html>
