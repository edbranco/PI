<%-- 
    Document   : Back_end_cliente_excluir
    Created on : Oct 26, 2015, 2:06:45 AM
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
      
        <form action="ServletClienteExcluir" method="post">            
      
            <fieldset>
                <legend>Excluir Cliente </legend>
            <p>
                <label for="idcliente">Digite o ID do Cliente:</label>
                <input type="number" name="idCliente" id="idcliente">
            </p>
            <input type="submit" value="Enviar"/>
            
            </fieldset>

        </form>
     <a href="Back_end_cliente_excluir.jsp">excluir cliente</a>
     <a href="Alterar_Cliente.jsp">alterar cliente</a>
    </body>
</html>
