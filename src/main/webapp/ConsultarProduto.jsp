<%-- 
    Document   : ConsultarProduto
    Created on : 03/11/2015, 06:35:10
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
        <title>Consulta de Produtos</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />  
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="box-consulta">
            <form action="ServletConsultarProduto" method="post">         
                <fieldset>
                    <legend><span>Consultar Produto</span></legend>              
                    <p>
                        <label for="nomeproduto">Nome:</label>
                        <input class="form-control" type="text" name="nomeProduto" id="nomeproduto">
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
                            <th class="cpo-id">ID</th>
                            <th class="cpo-id">Filial</th>
                            <th class="cpo-id">Nome</th>
                            <th class="cpo-id">Marca</th>
                            <th class="cpo-id">Preço</th>
                            <th class="cpo-id">Quantidade</th>
                        </tr>
                    </thead>
                    <c:forEach items="${listProduto}" var="produto" varStatus="stat">
                        <tr>                
                            <td><c:out value="${produto.id}" /></td>
                            <td><c:out value="${produto.id_filial}" /></td>
                            <td><c:out value="${produto.nome}" /></td>
                            <td><c:out value="${produto.marca}" /></td>
                            <td><c:out value="${produto.preco}" /></td>
                            <td><c:out value="${produto.qtde}" /></td>
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
