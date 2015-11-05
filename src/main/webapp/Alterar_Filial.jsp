<%-- 
    Document   : Alterar_Filial
    Created on : 05/11/2015, 17:47:42
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
        <title>Alterar Filial</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>                  
        <jsp:include page="Menu.jsp" />
            
        <div class="formulario">
            <form action="ServletFilialAlterar" method="post">  
                <fieldset>
                    <legend>Alterar Produtos</legend>  
                    <p>
                        <label for="txtId">Digite o ID da Filial:</label>
                        <input type="number" name="idFilial" id="idFilial" value="${filial.idfilial}" class="ipt-id" />
                    </p>
     
                    <p>
                        <label for="txtNome">Nome da Filial:</label><br />
                        <input type="text" name="nomeFilial" id="nomeFilial" value="${filial.nomefilial}" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="txtNome">Cnpj:</label><br />
                        <input type="text" name="cnpj" id="cnpj" value="${filial.cnpj}" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="txtNome">UF:</label><br />
                        <input type="text" name="uf" id="uf" value="${filial.uf}" class="ipt-largo" />
                    </p>
                    
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
