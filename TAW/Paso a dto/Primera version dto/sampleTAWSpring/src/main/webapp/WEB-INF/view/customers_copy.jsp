<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 15/2/23
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="cabecera.jsp"/>

<h1>Listado de clientes</h1>


<form action="/customer/filtrar" method="post">
Buscar por: <input type="text" name="filtro">
<button>Filtrar</button>
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>EMAIL</th>
        <th>NAME</th>
        <th>CREDIT LIMIT</th>
        <th>DISCOUNT CODE</th>
        <th>CITY</th>
        <th>MICROMARKET</th>
        <th></th>
        <th></th>
    </tr>
<<c:forEach items="${clientes}" var="cliente" >
    <tr>
        <td>${cliente.customerId}</td>
        <td>${cliente.email}</td>
        <td>${cliente.name}</td>
        <td>${cliente.discountCodeByDiscountCode.rate}</td>
        <td>${cliente.creditLimit}</td>
        <td>${cliente.city}</td>
        <td>${cliente.microMarketByZip.zipCode}</td>
        <td><a href="/customer/editar?id=${cliente.customerId}"> Editar</a></td>
        <td><a href="/customer/borrar?id=${cliente.customerId}"> Borrar</a></td>
    </tr>
</c:forEach>

</table border="1">
</body>
</html>
