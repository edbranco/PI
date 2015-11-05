<%-- 
    Document   : filial
    Created on : 25/10/2015, 21:04:10
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
        <title>Cadastro de Filial</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
       
        <div class="formulario">
            <form action="ServletFilialCadastrar" method="post">
                 <fieldset>
                    <legend>Cadastrar Filial</legend>  
                    <p>
                        <label for="txtNome">Nome:</label><br />
                        <input type="text" maxlength="20" name="nomefilial" id="nomefilial" class="ipt-largo" required />
                    </p>
                    <p>
                        <label for="txtNome">UF:</label><br />
                        <input type="text" name="uf" id="uf" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="txtNome">CNPJ:</label><br />
                        <input type="text" name="cnpj" id="cnpj" class="ipt-largo" />
                    </p>
                    <input type="submit" value="Cadastrar"/>
                 </fieldset>
            </form>
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
    </body>
</html>
