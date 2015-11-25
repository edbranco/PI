<%-- 
    Document   : Efetuar_Venda
    Created on : Nov 21, 2015, 12:27:43 PM
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de Produtos</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletVendaEfetuar" method="post">
                <fieldset>
                    <legend><span>Vender Produto</span></legend>
                    
                    <input type="hidden" name="idfilial" id="idfilial" value="${produto.id_filial }">
                    <input type="hidden" name="idfuncionario" id="idfuncionario" value="${usuario.id}">
                    
                    <p>
                        <label for="vendaproduto">ID:</label><br />
                        <select name="vendaproduto" id="vendaproduto" class="ipt-select">                    
                           
                               <option value="${produto.id}">${produto.id}</option>
                                            
                        </select>
                    </p>
                    
                    <p class="ipt-curto ipt-curto-1">
                        <label for="vendapreco">Preço R$:</label><br />
                        <input type="text" name="vendapreco" id="vendapreco" value="${produto.preco}"  required />
                    </p>
                    
                    <p>
                        <label for="vendacliente">CPF Cliente:</label><br />
                        <input type="text" name="vendacliente" id="vendacliente" class="ipt-largo" required />
                    </p>
                    
                    <p class="ipt-curto">
                        <label for="qtdeproduto">Quantidade:</label><br />
                        <input type="number" step="1" name="qtdeproduto" id="qtdeproduto" required />
                    </p><br />
                    
                    <input type="submit" name="vender" value="Confirmar" />
                </fieldset>
            </form>
        </div>
        <div id="suc-ven-produto" class="alert alert-success">
            Venda efetuada com sucesso!
        </div>
        <div id="alerta-registro" class="alert alert-warning">
            <strong>Atenção!</strong> Este cliente não existe!
        </div>
        <div id="alerta-estoque" class="alert alert-warning">
            <strong>Atenção!</strong> Este produto não possui esta quantidade em estoque!
        </div>
        
        
        
         <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <!--Máscaras-->
        <script>
            jQuery(function($){
                $("#vendacliente").mask("999.999.999-99");
            });
        </script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-ven-produto").classList.add("aparecer");
            } else {
                document.getElementById("suc-ven-produto").classList.add("desaparecer");
            }
            
            if (${clienteExiste} === true) {
                document.getElementById("alerta-registro").classList.add("desaparecer");
            } else {
                document.getElementById("alerta-registro").classList.add("aparecer");
            }
            
            if (${mensagem2} === true) {
                document.getElementById("alerta-estoque").classList.add("aparecer");
            } else {
                document.getElementById("alerta-estoque").classList.add("desaparecer");
            }
            
        </script>
    </body>
</html>
