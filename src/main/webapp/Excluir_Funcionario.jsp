<%-- 
    Document   : Excluir_Funcionario
    Created on : Nov 15, 2015, 10:29:50 PM
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
        <title>Exclusão de Funcionários</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacaoExcluirFuncionario.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletFuncionarioExcluir" method="post" onsubmit="return validarExcluirFuncionario();">         
                <fieldset>
                    <legend>Excluir Funcionário</legend>
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <input type="hidden" name="funcionarioExiste" id="funcionarioExiste" value="${funcionarioExiste}">
                    <p>
                        <label for="idfuncionario">Digite o ID do Funcionário:</label>
                        <input type="text" name="idfuncionario" id="idfuncionario" value="${funcionario.id}" required />
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    
                    <input type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                    <input type="submit" name="btn-consultar" id="btn-excluir" value="Excluir"/>            
                </fieldset>
            </form>
        </div>
        <div id="suc-exc-funcionario" class="alert alert-success">
            Funcionário excluído com sucesso!
        </div>
        <div id="exc-alert-reg" class="alert alert-warning">
            <strong>Atenção!</strong> Este funcionário não existe!
        </div>
                    
        <div class="consulta-excluir">
            <p>Nome: ${funcionario.nome}</p>
            <p>RA: ${funcionario.ra}</p>
            <p>CPF: ${funcionario.cpf}</p>
            <p>Telefone: ${funcionario.telefone}</p>
            <p>E-mail: ${funcionario.email}</p>
            <p>Endereco: ${funcionario.endereco}</p>
            <p>UF: ${funcionario.uf}</p>
            <p>Cidade: ${funcionario.cidade}</p>
            <p>Cargo: ${funcionario.cargo}</p>
        </div>
        
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-exc-funcionario").classList.add("aparecer");
            } else {
                document.getElementById("suc-exc-funcionario").classList.add("desaparecer");
            }           
        </script>
    </body>
</html>
