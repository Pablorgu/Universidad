<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 20/2/23
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Datos del cliente:</h1>
<form:form action="/guardar" modelAttribute="cliente" method="post">
    <form:hidden path="customerId"/>
    Nombre: <form:input path="name" size="30" maxlength="30"  /><br/>
    Email: <form:input path="email" size="40"  maxlength="40"/> <br/>
    Dirección: <form:input path="addressline1"  size="30" maxlength="30" />
                <form:input path="addressline2" size="30" maxlength="30" /><br/>
    Ciudad: <form:input path="city" maxlength="25" /> <br/>
    Estado: <form:input path="state" maxlength="2" size="2" /><br/>
    Límite de crédito: <form:input path="creditLimit" size="4" /><br/>
    Telefóno: <form:input type="phone" path="phone" maxlength="12" size="12" /><br/>
    Fax: <form:input type="phone" path="fax" maxlength="12" size="12" /><br/>
     Código de descuento: <form:select path="discountCodeByDiscountCode"
                                      items="${descuentos}"
                                      itemLabel="rate"
                                      itemValue="discountCode"  /> <br/>
    Supermercado: <form:select path="microMarketByZip" items="${supermercados}" /><br/>
    <form:button>Guardar</form:button>

</form:form>
</body>
</html>
