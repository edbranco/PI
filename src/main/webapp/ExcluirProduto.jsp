<%-- 
    Document   : ExcluirProduto
    Created on : 03/11/2015, 07:13:31
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
        <title>Exclusão de Produtos</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacaoExcluirProduto.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletExcluirProduto" method="post" onsubmit="return validarExcluirProduto();">   
                <fieldset>
                    <legend><span>Excluir Produto</span></legend>
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <input type="hidden" name="produtoExiste" id="produtoExiste" value="${produtoExiste}">
                    <p>
                        <label for="idproduto">Digite o ID do Produto:</label>
                        <input class="form-control" type="text" name="idProduto" id="idproduto" value="${produto.id}" required />
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    
                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-excluir" value="Excluir"/> 
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>
        </div>
        <div id="suc-exc-produto" class="alert alert-success">
            Produto excluído com sucesso!
        </div>
        <div id="exc-alert-pro" class="alert alert-warning">
            <strong>Atenção!</strong> Este produto não existe!
        </div>
                    
        <div class="consulta-excluir">
            <p>Nome: ${produto.nome}</p>
            <p>Marca: ${produto.marca}</p>
            <p>Preço: ${produto.preco}</p>
            <p>Quantidade: ${produto.qtde}</p>
        </div>
            
            
            
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-exc-produto").classList.add("aparecer");
            } else {
                document.getElementById("suc-exc-produto").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
