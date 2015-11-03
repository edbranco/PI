<%-- 
    Document   : ExcluirProduto
    Created on : 03/11/2015, 07:13:31
    Author     : Eder Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletExcluirProduto" method="post">            
      
            <fieldset>
                <legend>Excluir Produto </legend>
            <p>
                <label for="idproduto">Digite o ID do Produto:</label>
                <input type="number" name="idProduto" id="idproduto">
            </p>
            <input type="submit" value="Enviar"/>
            
            </fieldset>

        </form>
    </body>
</html>
