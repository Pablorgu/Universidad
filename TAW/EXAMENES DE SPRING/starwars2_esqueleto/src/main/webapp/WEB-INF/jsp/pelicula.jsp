<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>Datos de la pelicula</h1>
        <table>
            <tr>
                <td>
                <form:form  action="/pelicula/guardar" modelAttribute="peli" method="post">
                    <form:hidden path="peliculaId"/>
                    Título:<form:input path="titulo" size="50" maxlenght="50"/><br/>
                    Año:<form:input path="anyo" size="30" maxlenght="40"/><br/>
                    Texto inicial:<br/><form:textarea path="textoApertura" rows="35" cols="120" maxlenght="5000"/><br/>
                    <form:button>Guardar</form:button>
                </td>
                <td>Personajes: <br/><form:select path="personajeList" items="${personajes}" itemValue="personajeId" size="30" multiple="true" selectedItems="${ListaPersonajes}" itemLabel="nombre"/></td>
                </form:form>
            </tr>
        </table>
</body>
</html>
<%--
<html>
<head>
    <title>Pelicula</title>
</head>
<body>
<form:form action="/pelicula/guardar" modelAttribute="pelicula" method="post">
    <form:hidden path="peliculaId"/>
    Titulo: <form:input path="titulo" size="50" maxlength="50"/><br/>
    AÃ±o: <form:input path="anyo" size="4" maxlength="4"/><br/>
    Texto de apertura: <form:input path="textoApertura" size="5000" maxlength="5000"/><br/>
    Personajes: <form:select path="personajeList" items="${ListaPersonajes}" itemLabel="nombre"/>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>--%>
