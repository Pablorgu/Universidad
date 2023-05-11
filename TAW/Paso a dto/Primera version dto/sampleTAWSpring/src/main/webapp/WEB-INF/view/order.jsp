<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 28/3/23
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo pedido</title>
</head>
<body>

<jsp:include page="cabecera.jsp" />

<h1>Nuevo pedido</h1>

<form:form modelAttribute="pedido" action="/purchaseOrder/guardar">
    <form:hidden path="orderNum" />
    <form:hidden path="customer.customerId" />
  Producto: <form:select path="product.productId" items="${productos}"  itemValue="productId" itemLabel="description"/> <br/>
  Coste de envío: <form:input path="shippingCost" /> <br/>
  Fecha de envío: <form:input path="shippingDate" type="date" />  <br/>
  Compañía de envío: <form:input path="freightCompany" />
    <form:button>Guardar</form:button>
</form:form>
</body>
</html>
