<%-- 
    Document   : Alterar_Usuario
    Created on : 02/11/2015, 23:44:05
    Author     : Ude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração de Usuários</title>
    </head>
    <body> 
        <jsp:include page="Menu.jsp" />
        <a href="Back_end_filial.jsp">Filial</a>
        <a href="cadastroProduto.jsp">Produto</a>
        <a href="Back_end_cliente.jsp">Cliente</a>

        <form action="ServletAlterarUsuario" method="post">

            <fieldset>
                <legend>Alterar cliente</legend>

                <p>
                    <label for="idusuario">Digite o ID do Usuario:</label>
                    <input type="number" name="idUsuario" id="idusuario">
                </p>
                <p>
                    <label for="nomeusuario">Usuario:</label>
                    <input type="text" name="nomeUsuario" id="nomeusuario" value="${usuario.nome}" />
                </p>
                <p>
                    <label for="senhausuario">Senha:</label>
                    <input type="password" name="senhaUsuario" id="senhausuario" value="${usuario.senha}" />
                </p>
                <p>
                    <label for="nomeusuario">Funcionario:</label>
                    <input type="text" name="nomeUsuario" id="nomeusuario" value="${usuario.funcionario}">
                </p>
                <p>
                    <label for="rausuario">RA:</label>
                    <input type="text" name="raUsuario" id="rausuario" value="${usuario.ra}">
                </p>
                <p>
                    <label for="cpfusuario">CPF:</label>
                    <input type="text" name="cpfUsuario" id="cpfusuario" value="${usuario.cpf}">
                </p>
                <p>
                    <label for="telefoneusuario">Telefone:</label>
                    <input type="number" name="telefoneUsuario" id="telefoneusuario" value="${usuario.telefone}">
                </p>
                <p>
                    <label for="emailusuario">Email:</label>
                    <input type="email" name="emailUsuario" id="emailusuario" value="${usuario.email}">
                </p>
                <p>
                    <label for="enderecousuario">Endereco:</label>
                    <input type="text" name="enderecoUsuario" id="enderecousuario" value="${usuario.endereco}">
                </p>
                <p>
                    <label for="cidadeusuario">Cidade:</label>
                    <input type="text" name="cidadeUsuario" id="cidadeusuario" value="${usuario.cidade}">
                </p>

                <p>
                    <label for="cargousuario">Cargo:</label>
                    <input type="text" name="cargoUsuario" id="cargousuario" value="${usuario.cargo}">
                </p>
                <p>
                    <label for="estadousuario">UF:</label>
                    <select name="estadoUsuario" id="estadousuario" value="${usuario.uf}">
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
                    <input type="text" name="cidadeUsuario" id="cidadeusuario" value="${usuario.cidade}" />
                </p>

                <input type="submit" name="btn-consultar" value="Pesquisar" />
                <input type="submit" name="btn-consultar" value="Alterar" />
            </fieldset>
        </form>
    </body>
</html>