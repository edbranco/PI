<%-- 
    Document   : AlterarProduto
    Created on : 02/11/2015, 01:15:18
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
        <form action="ServletAlterarProduto" method="post">            

            <fieldset>
                <legend>Alterar Produtos</legend>  
                <p>
                <lable for="txtId">ID: </label>
                    <input type="number" name="idProduto" id="idproduto" value="${produto.id}"/>
                    </p>
                    <p>
                    <lable for="txtId">ID Filial: </label>
                        <input type="number" name="idFilial" id="idfilial" value="${produto.id_filial}"/>
                        </p>
                        <p>
                            <label for="txtNome">Nome:</label>
                            <input type="text" name="nomeProduto" id="nomeproduto" value="${produto.nome}"/>
                        </p>
                        <p>
                            <label for="txtNome">Marca:</label>
                            <input type="text" name="marcaProduto" id="marcaproduto" value="${produto.marca}"/>
                        </p>
                        <p>
                            <label for="numberNome">Preço R$:</label>
                            <input type="number" step=0.01 name="precoProduto" id="precoproduto" value="${produto.preco}"/>
                        </p>
                        <p>
                            <label for="numberNome">Quantidade:</label>
                            <input type="number" name="qtdeProduto" id="qtdeproduto" value="${produto.qtde}"/>
                        </p>

                        <input type="submit" name="btn-consultar" value="Pesquisar" />
                        <input type="submit" name="btn-consultar" value="Alterar" />

                        </fieldset>
        </form>
    </body>
</html>
