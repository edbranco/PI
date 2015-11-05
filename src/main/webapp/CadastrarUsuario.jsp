<%-- 
    Document   : CadastrarUsuario
    Created on : 02/11/2015, 23:02:41
    Author     : Ude
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionário</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>
   <body>
        <jsp:include page="Menu.jsp" />    
        
        <div class="formulario">
            <form action="ServletCadastrarUsuario" method="post">
                <fieldset>
                    <legend>Cadastrar Funcionário</legend>   
                    <p>
                        <label for="nomeusuario">Usuario:</label><br />
                        <input type="text" name="nomeUsuario" id="nomeusuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="senhausuario">Senha:</label><br />
                        <input type="password" name="senhaUsuario" id="senhausuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="nomeusuario">Funcionario:</label><br />
                        <input type="text" name="nomeUsuario" id="nomeusuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="rausuario">RA:</label><br />
                        <input type="text" name="raUsuario" id="rausuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="cpfusuario">CPF:</label><br />
                        <input type="text" name="cpfUsuario" id="cpfusuario" class="ipt-largo" />
                    </p>
                    
            
                     <select name="estadoUsuario" id="estadousuario" class="ipt-select">
                    
                    <c:forEach items="${listaFilial}" var="filial" varStatus="stat">
                             
                    <option>${filial.nomefilial}</option>
                         
                    </c:forEach>
                    
                     </select>
                    <p>
                        <label for="telefoneusuario">Telefone:</label><br />
                        <input type="number" name="telefoneUsuario" id="telefoneusuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="emailusuario">Email:</label><br />
                        <input type="email" name="emailUsuario" id="emailusuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="enderecousuario">Endereco:</label><br />
                        <input type="text" name="enderecoUsuario" id="enderecousuario" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="cargousuario">Cargo:</label><br />
                        <select name="cargoUsuario" id="cargousuario" class="ipt-select ipt-largo">
                            <option value="0">Selecione o Cargo</option>
                            <option value="gerente">Gerente</option>
                            <option value="vendedor">Vendedor</option>
                        </select>
                    </p>

                    <p class="ipt-curto ipt-curto-1">
                        <label for="estadousuario">UF:</label><br />
                        <select name="estadoUsuario" id="estadousuario" class="ipt-select">
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
                    <p class="ipt-curto">
                        <label for="cidadeusuario">Cidade:</label><br />
                        <input type="text" name="cidadeUsuario" id="cidadeusuario">
                    </p><br />
                    <input type="submit" value="Cadastrar"/>
                </fieldset>
            </form> 
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script> 
    </body>
</html>