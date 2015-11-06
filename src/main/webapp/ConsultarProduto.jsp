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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        <form action="ServletConsultarProduto" method="post">            
          
            <fieldset>
                <legend>Consultar Produto</legend>              
                <p>
                    <label for="txtNome">Nome:</label>
                    <input type="text" name="nomeProduto" id="nomeproduto">
                </p>
                <input type="submit" value="Listar"/>
            </fieldset>
        </form>
        
        <table>
            <tr>
                <!-- <th>#</th> -->
                <th>ID</th>
                <th>Filial</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Preço</th>
                <th>Quantidade</th>
                
            </tr>
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
    </body>
</html>
