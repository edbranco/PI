<%-- 
    Document   : Excluir_Filial
    Created on : 02/11/2015, 16:47:53
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
         
         <form action="ServletFilialExcluir" method="post">            
      
            <fieldset>
                <legend>Excluir Filial</legend>
            <p>
                <label for="idfilial">Digite o ID da Filial:</label>
                <input type="number" name="idfilial" id="idfilial">
            </p>
              
            <input type="submit" value="Enviar"/>
            
            </fieldset>

        </form>
    </body>
</html>
