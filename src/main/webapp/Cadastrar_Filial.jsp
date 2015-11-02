<%-- 
    Document   : filial
    Created on : 25/10/2015, 21:04:10
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
       
       
        <form action="ServletFilialCadastrar" method="post">
             
             <fieldset>
                <legend>Cadastrar Filial</legend>  
            <p>
                <label for="txtNome">Nome:</label>
                <input type="text" name="nomefilial" id="nomefilial">
            </p>
            <p>
                <label for="txtNome">UF:</label>
                <input type="text" name="uf" id="uf">
            </p>
            <p>
                <label for="txtNome">CNPJ:</label>
                <input type="text" name="cnpj" id="cnpj">
            </p>

            <input type="submit" value="Enviar"/>

             </fieldset>
               
        </form>
    </body>
</html>
