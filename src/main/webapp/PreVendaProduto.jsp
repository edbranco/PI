<%-- 
    Document   : PreVendaProduto
    Created on : 22/11/2015, 17:06:52
    Author     : Lucas
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
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
       
    </head>
    <body>                  
        <jsp:include page="Menu.jsp" />
            
        <div class="formulario">
            <form action="ServletPreVendaProduto" method="post">  
                <fieldset>
                    <legend>Pre Venda</legend>  
                    <input type="hidden" name="habilitado" id="habilitado" value="${habilitado}">
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <input type="hidden" name="idfilial" id="idfilial" value="${produto.id_filial}">
                    <p>
                        <label for="idproduto">Digite o ID do Produto:</label>
                        <input type="text" name="idProduto" id="idproduto" value="${produto.id}" class="ipt-id" required />
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    <p>
                        <label for="nomeproduto">Nome:</label><br />
                        <input type="text" name="nomeProduto" id="nomeproduto" value="${produto.nome}" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="marcaproduto">Marca:</label><br />
                        <input type="text" name="marcaProduto" id="marcaproduto" value="${produto.marca}" class="ipt-largo" />
                    </p>
                    <p class="ipt-curto ipt-curto-1">
                        <label for="precoproduto">Preço R$:</label><br />
                        <input type="number" step=0.01 name="precoProduto" id="precoproduto" value="${produto.preco}" />
                    </p>
                    <p class="ipt-curto">
                        <label for="qtdeproduto">Quantidade:</label><br />
                        <input type="number" name="qtdeProduto" id="qtdeproduto" value="${produto.qtde}" />
                    </p><br />
                    <input type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                    <input type="submit" name="btn-consultar" id="btn-alterar" value="Vender" />
                </fieldset>
            </form>
        </div>
     
        <div id="alerta-registro" class="alert alert-warning">
            <strong>Atenção!</strong> Este produto não existe!
        </div>
                    
                    
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-alt-produto").classList.add("aparecer");
            } else {
                document.getElementById("suc-alt-produto").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
