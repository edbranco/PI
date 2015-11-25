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
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
        <script type="text/javascript" src="${pathResources}/js/validacaoAlterar.js"></script>
    </head>
    <body> 
        <jsp:include page="Menu.jsp" />
       
        <div class="formulario">
            <form action="ServletClienteAlterar" method="post" onsubmit="return validarAlterarCliente();">
                <fieldset>
                    <legend><span>Alterar Cliente</span></legend>
                    <input type="hidden" name="habilitado" id="habilitado" value="${habilitado}">
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <p class="campos-esq">
                        <label for="idcliente">Digite o ID do Cliente:</label><br />
                        <input type="text" name="idCliente" id="idcliente" value="${cliente.id}" class="ipt-id form-control" required />
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    <p>
                        <label for="nomecliente">Nome:</label><br />
                        <input type="text" name="nomeCliente" id="nomecliente" value="${cliente.nome}" class="ipt-largo form-control" required />
                    </p>
                    <div id="err-campo-nome" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas letras.
                    </div>
                    <p class="campos-esq">
                        <label for="cpfcliente">CPF:</label><br />
                        <input type="text" name="cpfCliente" id="cpfcliente" value="${cliente.cpf}" class="ipt-largo form-control" required />
                    </p>
                    <p>
                        <label for="telefonecliente">Telefone:</label><br />
                        <input type="text" name="telefoneCliente" id="telefonecliente" value="${cliente.telefone}" class="ipt-largo form-control" required />
                    </p>
                    <p class="campos-esq">
                        <label for="emailcliente">E-mail:</label><br />
                        <input type="email" name="emailCliente" id="emailcliente" value="${cliente.email}" class="ipt-largo form-control" required />
                    </p>
                    <p>
                        <label for="enderecocliente">Endereço:</label><br />
                        <input type="text" name="enderecoCliente" id="enderecocliente" value="${cliente.endereco}" class="ipt-largo form-control" required />
                    </p>
                    <p class="campos-esq">
                        <label for="estadocliente">UF:</label><br />
                        <select name="estadoCliente" id="estadocliente" class="ipt-select form-control">
                            <option value="${cliente.uf}">${cliente.uf}</option>
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
                        <input type="text" name="cidadeCliente" id="cidadecliente" value="${cliente.cidade}" class="form-control" required />
                    </p><br />
                    
                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-alterar" value="Alterar" />
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>
        </div>
        <div id="suc-alt-cliente" class="alert alert-success">
            Cliente alterado com sucesso!
        </div>
        <div id="alerta-registro" class="alert alert-warning">
            <strong>Atenção!</strong> Este cliente não existe!
        </div>
        <div id="alerta-pes-cliente" class="alert alert-warning">
            <strong>Atenção!</strong> Pesquise um cliente primeiro!
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
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-alt-cliente").classList.add("aparecer");
            } else {
                document.getElementById("suc-alt-cliente").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
