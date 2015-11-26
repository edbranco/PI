<%-- 
    Document   : Back_end_cliente_excluir
    Created on : Oct 26, 2015, 2:06:45 AM
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
        <title>Exclusão de Clientes</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacaoExcluir.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <div class="formulario">
            <form action="ServletClienteExcluir" method="post" onsubmit="return validarExcluirCliente();">         
                <fieldset>
                    <legend><span>Excluir Cliente</span></legend>
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <input type="hidden" name="clienteExiste" id="clienteExiste" value="${clienteExiste}">
                    <p>
                        <label for="idcliente">Digite o ID do Cliente:</label>
                        <input class="form-control" type="text" name="idcliente" id="idcliente" value="${cliente.id}" required />
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
        <div id="suc-exc-cliente" class="alert alert-success">
            Cliente excluído com sucesso!
        </div>
        <div id="exc-alert-reg" class="alert alert-warning">
            <strong>Atenção!</strong> Este cliente não existe!
        </div>
                    
        <div class="consulta-excluir">
            <div>
                <h2>Informações do Cliente</h2>
            </div>
            <p>Nome: ${cliente.nome}</p>
            <p>CPF: ${cliente.cpf}</p>
            <p>Telefone: ${cliente.telefone}</p>
            <p>E-mail: ${cliente.email}</p>
            <p>Endereco: ${cliente.endereco}</p>
            <p>UF: ${cliente.uf}</p>
            <p>Cidade: ${cliente.cidade}</p>
        </div>
        
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-exc-cliente").classList.add("aparecer");
            } else {
                document.getElementById("suc-exc-cliente").classList.add("desaparecer");
            }           
        </script>
    </body>
</html>
