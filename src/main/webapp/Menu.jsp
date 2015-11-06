<%-- 
    Document   : Menu
    Created on : Nov 1, 2015, 1:26:53 PM
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
        <title>JSP Page</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
       
<div id="menu-header">
            <ul class="nav nav-pills">
                <li class="dropdown"><a href="#">Produto</a>
                    <ul class="dropdown-menu">
                        <li><a href="Servlet">Cadastrar</a></li>
                        <li><a href="ServletAlterarProduto">Alterar</a></li>
                        <li><a href="ConsultarProduto.jsp">Consultar</a></li>
                        <li><a href="ServletExcluirProduto">Excluir</a></li>
                          
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Filial</a>
                    <ul class="dropdown-menu">
                        <li><a href="ServletFilialCadastrar">Cadastrar</a></li>
                        <li><a href="ServletFilialAlterar">Alterar</a></li>
                        <li><a href="Consultar_Filial.jsp">Consultar</a></li>
                        <li><a href="ServletFilialExcluir">Excluir</a></li> 
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Cliente</a>
                    <ul class="dropdown-menu">
                        <li><a href="ServletClienteCadastrar">Cadastrar</a></li>
                        <li><a href="ServletClienteAlterar">Alterar</a></li>
                        <li><a href="Consultar_Cliente.jsp">Consultar</a></li> 
                        <li><a href="ServletClienteExcluir">Excluir</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Funcionário</a>
                    <ul class="dropdown-menu">                      
                        <li><a href="PreCadastroUsuario"> Cadastrar</a></li>                   
                        <li><a href="Alterar_Usuario.jsp">Alterar</a></li>
                        <li><a href="#">Consultar</a></li>
                        <li><a href="#">Excluir</a></li>
                    </ul>
                </li>
            </ul>   
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
    </body>
</html>
