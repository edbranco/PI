<%-- 
    Document   : Excluir_Filial
    Created on : 02/11/2015, 16:47:53
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
        <title>Exclusão de Filiais</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacaoExcluirFilial.js"></script>
    </head>
    <body>        
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletFilialExcluir" method="post" onsubmit="return validarExcluirFilial();">        
                <fieldset>
                    <legend><span>Excluir Filial</span></legend>
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <input type="hidden" name="filialExiste" id="filialExiste" value="${filialExiste}">
                    <p>
                        <label for="idfilial">Digite o ID da Filial:</label>
                        <input class="form-control" type="text" name="idfilial" id="idfilial" value="${filial.idfilial}" required>
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    
                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-excluir" value="Excluir"/>  
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>
        </div>
        <div id="suc-exc-filial" class="alert alert-success">
            Filial excluída com sucesso!
        </div>
        <div id="exc-alert-reg" class="alert alert-warning">
            <strong>Atenção!</strong> Esta filial não existe!
        </div>
                    
        <div class="consulta-excluir">
            <p>Nome: ${filial.nomefilial}</p>
            <p>CNPJ: ${filial.cnpj}</p>
            <p>UF: ${filial.uf}</p>
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-exc-filial").classList.add("aparecer");
            } else {
                document.getElementById("suc-exc-filial").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
