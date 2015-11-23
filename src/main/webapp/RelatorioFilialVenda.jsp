<%-- 
    Document   : RelatorioFilialVenda
    Created on : 23/11/2015, 20:59:04
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
        <form action="RelatorioFilialVenda" method="post">            
            
            <fieldset>
                <legend>Relatorio de Venda</legend>                     
          
          <p>
             <label for="filial">Filial:</label><br />
              <select name="filial" id="filial" class="ipt-select form-control">                    
                <c:forEach items="${listaFilial}" var="filial" varStatus="stat">
                 <option value="${filial.idfilial}">${filial.nomefilial}</option>
                   </c:forEach>                    
                    </select>
                  </p>        
                
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
            <c:forEach items="${relatorioFilial}" var="relatorioFilial" varStatus="stat">
                <tr>                
                    <td><c:out value="${relatorioFilial.nomeProduto}" /></td>
                    <td>R$<c:out value="${relatorioFilial.preco}" /> </td>
                    <td><c:out value="${relatorioFilial.dt_cadastro}" /></td>
                    <td><c:out value="${relatorioFilial.nomeFuncionario}" /></td>
                    <td><c:out value="${relatorioFilial.nomeFilial}" /></td>
                    
                    
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>


