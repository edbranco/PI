<%-- 
    Document   : Consultar_Cliente
    Created on : Oct 31, 2015, 9:04:43 PM
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
        <title>Consulta de Clientes</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />        
    </head>
    
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="box-consulta">
            <form action="ServletClienteConsultar" method="post">         
                <fieldset>
                    <legend>Consultar Cliente</legend>              
                    <p>
                        <label for="nomecliente">Nome:</label>
                        <input class="form-control" type="text" name="nomeCliente" id="nomecliente">
                    </p>
                    
                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" value="Listar" />
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>

            <div class="box-tabelas">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <!-- <th>#</th> -->
                            <th>ID</th>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Telefone</th>
                            <th>E-mail</th>
                            <th>Endereco</th>
                            <th>Cidade</th>
                            <th>UF</th>
                        </tr>
                    </thead>
                    <c:forEach items="${listaClientes}" var="cliente" varStatus="stat">
                        <tr>                
                            <td><c:out value="${cliente.id}" /></td>
                            <td><c:out value="${cliente.nome}" /></td>
                            <td><c:out value="${cliente.cpf}" /></td>
                            <td><c:out value="${cliente.telefone}" /></td>
                            <td><c:out value="${cliente.email}" /></td>
                            <td><c:out value="${cliente.endereco}" /></td>
                            <td><c:out value="${cliente.cidade}" /></td>
                            <td><c:out value="${cliente.uf}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
    </body>
</html>
