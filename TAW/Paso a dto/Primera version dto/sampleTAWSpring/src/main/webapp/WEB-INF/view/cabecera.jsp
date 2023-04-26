<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="es.taw.sampletaw.dto.AdministradorDTO" %><%--
  Created by IntelliJ IDEA.
  User: guzman
  Date: 15/3/23
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty admin}">
  <jsp:forward page="/" />
</c:if>


<table style="border: 0px; width: 100% ">
  <tr>
    <td>${pageContext.session.id}</td>
    <td>Bienvenido, ${admin.email} </td>
    <td><a href="/logout">Salir</a></td>
  </tr>
</table>
<p>


</p>