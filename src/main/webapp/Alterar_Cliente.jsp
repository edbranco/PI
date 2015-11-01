<%-- 
    Document   : Consultar_Cliente
    Created on : Oct 28, 2015, 8:02:33 PM
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
        <title>Alteração de Clientes</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        <jsp:include page="Menu.jsp" />
       <a href="Back_end_filial.jsp">Filial</a>
       <a href="cadastroProduto.jsp">Produto</a>
       <a href="Back_end_cliente.jsp">Cliente</a>
        
        <form action="ServletClienteAlterar" method="post">
       
            <fieldset>
                <legend>Alterar cliente</legend>
            
            <p>
                <label for="idcliente">Digite o ID do Cliente:</label>
                <input type="number" name="idCliente" id="idcliente">
            </p>
            <p>
                <label for="nomecliente">Nome:</label>
                <input type="text" name="nomeCliente" id="nomecliente" value="${cliente.nome}" />
            </p>
            <p>
                <label for="cpfcliente">CPF:</label>
                <input type="number" name="cpfCliente" id="cpfcliente" value="${cliente.cpf}" />
            </p>
            <p>
                <label for="telefonecliente">Telefone:</label>
                <input type="number" name="telefoneCliente" id="telefonecliente" value="${cliente.telefone}" />
            </p>
            <p>
                <label for="emailcliente">E-mail:</label>
                <input type="email" name="emailCliente" id="emailcliente" value="${cliente.email}" />
            </p>
            <p>
                <label for="enderecocliente">Endereço:</label>
                <input type="text" name="enderecoCliente" id="enderecocliente" value="${cliente.endereco}" />
            </p>
            <p>
                <label for="estadocliente">UF:</label>
                <select name="estadoCliente" id="estadocliente" value="${cliente.uf}">
                    <option value="0">Selecione o Estado</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espirito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
            </p>            
            <p>
                <label for="cidadecliente">Cidade:</label>
                <input type="text" name="cidadeCliente" id="cidadecliente" value="${cliente.cidade}" />
            </p>
          
            <input type="submit" name="btn-consultar" value="Pesquisar" />
            <input type="submit" name="btn-consultar" value="Alterar" />
            </fieldset>
          
        </form>
            
            
            
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
    </body>
</html>
