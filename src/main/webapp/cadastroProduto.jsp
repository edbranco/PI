<%-- 
    Document   : cadastroProduto
    Created on : 31/10/2015, 15:36:01
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
        <title>Cadastro de Produtos</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="Servlet" method="post">         
                <fieldset>
                    <legend>Cadastrar Produtos</legend>           
                    <p>
                        <label for="txtNome">Nome:</label><br />
                        <input type="text" maxlength="100" name="nomeProduto" id="nomeproduto" class="ipt-largo" required />
                    </p>
                    <p>
                        <label for="txtNome">Marca:</label><br />
                        <input type="text" maxlength="80" name="marcaProduto" id="marcaproduto" class="ipt-largo" required />
                    </p>
                    <p class="ipt-curto ipt-curto-1">
                        <label for="numberNome">Preço R$:</label><br />
                        <input type="number" step=0.01 name="precoProduto" id="precoproduto" required />
                    </p>
                    <p class="ipt-curto">
                        <label for="numberNome">Quantidade:</label><br />
                        <input type="number" name="qtdeProduto" id="qtdeproduto" required />
                    </p><br />
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
