<%-- 
    Document   : Back_end_cliente
    Created on : Oct 25, 2015, 8:15:42 PM
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
        <title>Cadastro de Clientes</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
   <body>
       <jsp:include page="Menu.jsp" />       
     
       <div class="formulario">
            <form id="fr-cad-cliente" action="ServletClienteCadastrar" method="post" onsubmit="return validarCampos();">
                <fieldset>
                    <legend>Cadastrar Cliente </legend>   
                <p>
                    <label for="nomecliente">Nome:</label><br />
                    <input type="text" maxlength="100" name="nomeCliente" id="nomecliente" class="ipt-largo" required />
                </p>
                <div id="err-campo-nome" class="alert alert-danger">
                    <strong>Atenção!</strong> Digite apenas letras.
                </div>
                <p>
                    <label for="cpfcliente">CPF:</label><br />
                    <input type="cpf" name="cpfCliente" id="cpfcliente" class="ipt-largo" required /><span class="aviso"> * Digite apenas números</span>
                </p>
                <div id="err-campo-cpf" class="alert alert-danger">
                    <strong>Atenção!</strong> CPF inválido.
                </div>
                <p>
                    <label for="telefonecliente">Telefone:</label><br />
                    <input type="text" name="telefoneCliente" id="telefonecliente" class="ipt-largo" required /><span class="aviso"> * Digite apenas números (DDDnumero)</span>
                </p>
                <div id="err-campo-fone" class="alert alert-danger">
                    <strong>Atenção!</strong> Telefone inválido.
                </div>
                <p>
                    <label for="emailcliente">E-mail:</label><br />
                    <input type="email" name="emailCliente" id="emailcliente" class="ipt-largo" required />
                </p>
                <p>
                    <label for="enderecocliente">Endereço:</label><br />
                    <input type="text" maxlength="200" name="enderecoCliente" id="enderecocliente" class="ipt-largo" required />
                </p>
                <p class="ipt-curto ipt-curto-1">
                    <label for="estadocliente">UF:</label><br />
                    <select name="estadoCliente" id="estadocliente" class="ipt-select">
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
                    <label for="cidadecliente">Cidade:</label><br />
                    <input type="text" maxlength="80" name="cidadeCliente" id="cidadecliente" required />
                </p>
                
                <div>
                    <input type="submit" value="Cadastrar"/>
                </div>
            </form>
        </div>
        <div id="suc-cad-cliente" class="alert alert-success">
            Cliente cadastrado com sucesso!
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <!--Máscaras-->
        <script>
            jQuery(function($){
                $("#telefonecliente").mask("(99)9999-9999");
                $("#cpfcliente").mask("999.999.999-99");
            });
        </script>
    </body>
</html>
