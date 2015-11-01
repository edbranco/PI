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
                <li class="dropdown"><a href="#">Cadastrar</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Cadastrar Filial</a></li>
                        <li><a href="#">Cadastrar Funcionário</a></li>
                        <li><a href="Cadastrar_Cliente.jsp">Cadastrar Cliente</a></li> 
                        <li><a href="#">Cadastrar Produto</a></li> 
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Alterar</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Alterar Filial</a></li>
                        <li><a href="#">Alterar Funcionário</a></li>
                        <li><a href="Alterar_Cliente.jsp">Alterar Cliente</a></li> 
                        <li><a href="#">Alterar Produto</a></li> 
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Consultar</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Consultar Filial</a></li>
                        <li><a href="#">Consultar Funcionário</a></li>
                        <li><a href="Consultar_Cliente.jsp">Consultar Cliente</a></li> 
                        <li><a href="#">Consultar Produto</a></li> 
                    </ul>
                </li>
                <li class="dropdown"><a href="#">Excluir</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Excluir Filial</a></li>
                        <li><a href="#">Excluir Funcionário</a></li>
                        <li><a href="Excluir_Cliente.jsp">Excluir Cliente</a></li> 
                        <li><a href="#">Excluir Produto</a></li> 
                    </ul>
                </li>
            </ul>   
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
    </body>
</html>
