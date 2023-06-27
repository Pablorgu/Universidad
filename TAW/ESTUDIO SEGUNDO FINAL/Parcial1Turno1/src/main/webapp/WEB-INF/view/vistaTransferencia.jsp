<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 25/06/2023
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="cabecera.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Realizar transferencia entre cuentas: </h1>
  <form:form action="/realizar" modelAttribute="movimiento" method="post">
      <form:hidden path="cuentaByCuentaorigen" ></form:hidden>
    Destinatario:<form:select path="cuentaByCuentadestinatario" items="${restocuentas}" itemLabel="iban" itemValue="cuentaid"></form:select><br/>
    Descripcion:<form:input path="descripcion" size="50" maxlength="50"></form:input><br/>
    Cantidad:<form:input path="cantidad" maxlength="20" size="20"></form:input><br/>
      <form:button>Realizar</form:button>
  </form:form>
</body>
</html>
