<%-- 
    Document   : cadastroProduto
    Created on : 31/10/2015, 15:36:01
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
        <a href="Back_end_filial.jsp">Filial</a>
        <a href="cadastroProduto.jsp">Produto</a>
        <a href="Back_end_cliente.jsp">Cliente</a>
                 
        <form action="Servlet" method="post">            
          
             <fieldset>
                <legend>Cadastrar Produtos</legend>  
            
            <p>
                <label for="txtNome">Nome:</label>
                <input type="text" name="nomeProduto" id="nomeproduto">
            </p>
            <p>
                <label for="txtNome">Marca:</label>
                <input type="text" name="marcaProduto" id="marcaproduto">
            </p>
            <p>
                <label for="numberNome">Preço R$:</label>
                <input type="number" step=0.01 name="precoProduto" id="precoproduto">
            </p>
            <p>
                <label for="numberNome">Quantidade:</label>
                <input type="number" name="qtdeProduto" id="qtdeproduto">
            </p>

            <input type="submit" value="Enviar"/>
            
             </fieldset>
        </form>
    </body>
</html>
