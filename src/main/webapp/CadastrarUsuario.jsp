<%-- 
    Document   : CadastrarUsuario
    Created on : 02/11/2015, 23:02:41
    Author     : Ude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <jsp:include page="Menu.jsp" />
       
       <a href="Back_end_filial.jsp">Filial</a>
       <a href="cadastroProduto.jsp">Produto</a>
       <a href="Back_end_cliente.jsp">Cliente</a>
       
     

        <form action="ServletCadastrarUsuario" method="post">
     
            <fieldset>
                <legend>Cadastrar Usuario </legend>   
            <p>
                <label for="nomeusuario">Usuario:</label>
                <input type="text" name="nomeUsuario" id="nomeusuario">
            </p>
            <p>
                <label for="senhausuario">Senha:</label>
                <input type="password" name="senhaUsuario" id="senhausuario">
            </p>
            <p>
                <label for="nomeusuario">Funcionario:</label>
                <input type="text" name="nomeUsuario" id="nomeusuario">
            </p>
            <p>
                <label for="rausuario">RA:</label>
                <input type="text" name="raUsuario" id="rausuario">
            </p>
            <p>
                <label for="cpfusuario">CPF:</label>
                <input type="text" name="cpfUsuario" id="cpfusuario">
            </p>
            <p>
                <label for="telefoneusuario">Telefone:</label>
                <input type="number" name="telefoneUsuario" id="telefoneusuario">
            </p>
            <p>
                <label for="emailusuario">Email:</label>
                <input type="email" name="emailUsuario" id="emailusuario">
            </p>
            <p>
                <label for="enderecousuario">Endereco:</label>
                <input type="text" name="enderecoUsuario" id="enderecousuario">
            </p>
            <p>
                <label for="cidadeusuario">Cidade:</label>
                <input type="text" name="cidadeUsuario" id="cidadeusuario">
            </p>
            
            <p>
                <label for="cargousuario">Cargo:</label>
                <input type="text" name="cargoUsuario" id="cargousuario">
            </p>
            
            <p>
                <label for="estadousuario">UF:</label>
                <select name="estadoUsuario" id="estadousuario">
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
                <label for="cidadeusuario">Cidade:</label>
                <input type="text" name="cidadeUsuario" id="cidadeusuario">
            </p>

            <input type="submit" value="Enviar"/>
        </form>
        
        <a href="Excluir_Usuario.jsp">excluir Usuario</a>
        <a href="Alterar_Usuario.jsp">alterar Usuario</a>
        
    </body>
</html>