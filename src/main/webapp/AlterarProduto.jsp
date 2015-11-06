<%-- 
    Document   : AlterarProduto
    Created on : 02/11/2015, 01:15:18
    Author     : Eder Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de Produto</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>                  
        <jsp:include page="Menu.jsp" />
            
        <div class="formulario">
            <form action="ServletAlterarProduto" method="post">  
                <fieldset>
                    <legend>Alterar Produtos</legend>  
                    <p>
                        <label for="txtId">Digite o ID do Produto:</label>
                        <input type="number" name="idProduto" id="idproduto" value="${produto.id}" class="ipt-id" />
                    </p>
                    <p>
                        <label for="txtId">Digite o ID da Filial:</label>
                        <input type="number" name="idFilial" id="idfilial" value="${produto.id_filial}" class="ipt-id-filial" />
                    </p>
                    <p>
                        <label for="txtNome">Nome:</label><br />
                        <input type="text" name="nomeProduto" id="nomeproduto" value="${produto.nome}" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="txtNome">Marca:</label><br />
                        <input type="text" name="marcaProduto" id="marcaproduto" value="${produto.marca}" class="ipt-largo" />
                    </p>
                    <p class="ipt-curto ipt-curto-1">
                        <label for="numberNome">Preço R$:</label><br />
                        <input type="number" step=0.01 name="precoProduto" id="precoproduto" value="${produto.preco}" />
                    </p>
                    <p class="ipt-curto">
                        <label for="numberNome">Quantidade:</label><br />
                        <input type="number" name="qtdeProduto" id="qtdeproduto" value="${produto.qtde}" />
                    </p><br />
                    <input type="submit" name="btn-consultar" value="Pesquisar" />
                    <input type="submit" name="btn-consultar" value="Alterar" />
                </fieldset>
            </form>
        </div>
                    
                    
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>            
    </body>
</html>
