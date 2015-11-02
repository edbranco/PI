<%-- 
    Document   : Back_end_cliente
    Created on : Oct 25, 2015, 8:15:42 PM
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <jsp:include page="Menu.jsp" />
       

        <form action="ServletClienteCadastrar" method="post">
     
            <fieldset>
                <legend>Cadastrar Cliente </legend>   
            <p>
                <label for="nomecliente">Nome:</label>
                <input type="text" name="nomeCliente" id="nomecliente">
            </p>
            <p>
                <label for="cpfcliente">CPF:</label>
                <input type="number" name="cpfCliente" id="cpfcliente">
            </p>
            <p>
                <label for="telefonecliente">Telefone:</label>
                <input type="number" name="telefoneCliente" id="telefonecliente">
            </p>
            <p>
                <label for="emailcliente">E-mail:</label>
                <input type="email" name="emailCliente" id="emailcliente">
            </p>
            <p>
                <label for="enderecocliente">Endereço:</label>
                <input type="text" name="enderecoCliente" id="enderecocliente">
            </p>
            <p>
                <label for="estadocliente">UF:</label>
                <select name="estadoCliente" id="estadocliente">
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
                <input type="text" name="cidadeCliente" id="cidadecliente">
            </p>

            <input type="submit" value="Enviar"/>
        </form>
        
    </body>
</html>
