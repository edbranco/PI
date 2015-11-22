<%-- 
    Document   : RelatorioVenda
    Created on : 22/11/2015, 19:07:52
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
        <title>Consulta de Produtos</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />  
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        <form action="ServletRelatorioVenda" method="post">            
          
            <fieldset>
                <legend>Relatorio de Venda</legend>              
              
                <input type="submit" value="Gerar"/>
            </fieldset>
        </form>
        
        <table>
            <tr>
                <!-- <th>#</th> -->
                
                <th class="cpo-id">Nome Produto</th>
                <th class="cpo-id">Preço Total Venda</th>
                <th class="cpo-id">Data</th>
                <th class="cpo-id">Nome Funcionario</th>
                <th class="cpo-id">Nome Filial</th>
                
                
                
            </tr>
            <c:forEach items="${relatorio}" var="relatorio" varStatus="stat">
                <tr>                
                    <td><c:out value="${relatorio.nomeProduto}" /></td>
                    <td>R$<c:out value="${relatorio.preco}" /> </td>
                    <td><c:out value="${relatorio.dt_cadastro}" /></td>
                    <td><c:out value="${relatorio.nomeFuncionario}" /></td>
                    <td><c:out value="${relatorio.nomeFilial}" /></td>
                    
                    
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

