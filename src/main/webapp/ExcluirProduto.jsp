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
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletExcluirProduto" method="post">   
                <fieldset>
                    <legend>Excluir Produto </legend>
                    <p>
                        <label for="idproduto">Digite o ID do Produto:</label>
                        <input type="number" name="idProduto" id="idproduto">
                    </p>
                    <input type="submit" value="Excluir"/>
                </fieldset>
            </form>
        </div>
            
            
            
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
    </body>
</html>
