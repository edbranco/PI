<%-- 
    Document   : Consultar_Filial
    Created on : 03/11/2015, 20:17:58
    Author     : eder.lrbranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />  
        <title>Consultar Filial</title>
    </head>
    <body>
      <jsp:include page="Menu.jsp" />
      
        <div class="box-consulta">
            <form action="ServletFilialConsultar" method="post">         
                <fieldset>
                    <legend><span>Consultar Filial</span></legend>              

                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" value="Listar"/>
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>
        
        
            <div class="box-tabelas">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <!-- <th>#</th> -->
                            <th>Nome  </th>
                             <th>Cnpj </th>
                              <th>UF  </th>
                        </tr>
                    </thead>
                    <c:forEach items="${listaFilial}" var="filial" varStatus="stat">
                        <tr>                
                            <td><c:out value="${filial.nomefilial}   " /></td>
                            <td><c:out value="${filial.cnpj}   " /></td>
                            <td><c:out value="${filial.uf}   " /></td>

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
