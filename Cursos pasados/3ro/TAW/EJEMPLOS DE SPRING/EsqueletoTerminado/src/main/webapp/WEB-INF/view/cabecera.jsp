<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="es.taw.sampletaw.entity.Administrador" %><%--
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 15/04/2023
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty admin}">
  <jsp:forward page="/" />
</c:if>


<table style="...">
  <tr>
    <td>${pageContext.session.id}</td>
    <td>Bienvenido, ${admin.email}</td>
    <td><a href="/logout">Salir</a></td>
  </tr>
</table>