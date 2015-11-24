<%-- 
    Document   : Alterar_Funcionário
    Created on : 02/11/2015, 23:44:05
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
        <title>Alteração de Funcionários</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacaoAlterarFuncionario.js"></script>
    </head>
    <body> 
        <jsp:include page="Menu.jsp" />

        <div class="formulario">
            <form action="ServletFuncionarioAlterar" method="post" onsubmit="return validarAlterarFuncionario();">
                <fieldset>
                    <legend>Alterar Funcionário</legend>
                    <input type="hidden" name="habilitado" id="habilitado" value="${habilitado}">
                    <input type="hidden" name="semRegistro" id="semRegistro" value="${semRegistro}">
                    <p class="campos-esq">
                        <label for="idfuncionario">Digite o ID do Funcionário:</label>
                        <input type="text" name="idfuncionario" id="idfuncionario" value="${funcionario.id}" class="form-control" required />
                    </p>
                    <div id="err-campo-id" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas números inteiros.
                    </div>
                    <p>
                        <label for="nomefuncionario">Nome:</label><br />
                        <input type="text" name="nomefuncionario" id="nomefuncionario" value="${funcionario.nome}" class="ipt-largo form-control" required />
                    </p>
                    <div id="err-campo-nome" class="alert alert-danger">
                        <strong>Atenção!</strong> Digite apenas letras.
                    </div>
                    <p class="campos-esq">
                        <label for="rafuncionario">RA:</label><br />
                        <input type="text" name="rafuncionario" id="rafuncionario" value="${funcionario.ra}" class="ipt-largo form-control" required />
                    </p>
                    <p>
                        <label for="cpffuncionario">CPF:</label><br />
                        <input type="text" name="cpffuncionario" id="cpffuncionario" value="${funcionario.cpf}" class="ipt-largo form-control" required />
                    </p>
                    <p class="campos-esq">
                        <label for="filialfuncionario">Filial:</label><br />
                        <select name="filialfuncionario" id="filialfuncionario" class="ipt-select form-control">
                            <option value="${funcionario.idFilial}">${funcionario.idFilial}</option>
                            <c:forEach items="${listaFilial}" var="filial" varStatus="stat">
                                <option value="${filial.idfilial}">${filial.nomefilial}</option>
                            </c:forEach>                    
                        </select>
                    </p>
                    <p>
                        <label for="telefonefuncionario">Telefone:</label><br />
                        <input type="text" name="telefonefuncionario" id="telefonefuncionario" value="${funcionario.telefone}" class="ipt-largo form-control" required />
                    </p>
                    <p class="campos-esq">
                        <label for="emailfuncionario">Email:</label><br />
                        <input type="email" name="emailfuncionario" id="emailfuncionario" value="${funcionario.email}" class="ipt-largo form-control" required />
                    </p>
                    <p>
                        <label for="enderecofuncionario">Endereco:</label><br />
                        <input type="text" name="enderecofuncionario" id="enderecofuncionario" value="${funcionario.endereco}" class="ipt-largo form-control" required />
                    </p>
                    <p class="campos-esq">
                        <label for="cargofuncionario">Cargo:</label><br />
                        <select name="cargofuncionario" id="cargofuncionario" class="ipt-select ipt-largo form-control">
                            <option value="${funcionario.cargo}">${funcionario.cargo}</option>
                            <option value="gerente">Gerente</option>
                            <option value="vendedor">Vendedor</option>
                        </select>
                    </p>
                    <p class="ipt-curto ipt-curto-1">
                        <label for="estadofuncionario">UF:</label><br />
                        <select name="estadofuncionario" id="estadofuncionario" value="${usuario.uf}" class="ipt-select form-control">
                            <option value="${funcionario.uf}">${funcionario.uf}</option>
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
                        <label for="cidadefuncionario">Cidade:</label><br />
                        <input type="text" name="cidadefuncionario" id="cidadefuncionario" value="${funcionario.cidade}" class="ipt-curto form-control" required />
                    </p><br />
                    
                    <div class="div-botoes">
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-pesquisar" value="Pesquisar" />
                        <input class="btn btn-default" type="submit" name="btn-consultar" id="btn-alterar" value="Alterar" />
                        <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                    </div>
                </fieldset>
            </form>
        </div>
        <div id="suc-alt-funcionario" class="alert alert-success">
            Funcionário alterado com sucesso!
        </div>
        <div id="alerta-registro" class="alert alert-warning">
            <strong>Atenção!</strong> Este funcionário não existe!
        </div>
        
                
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <!--Máscaras-->
        <script>
            jQuery(function($){
                $("#telefonefuncionario").mask("(99)9999-9999");
                $("#cpffuncionario").mask("999.999.999-99");
            });
        </script> 
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-alt-funcionario").classList.add("aparecer");
            } else {
                document.getElementById("suc-alt-funcionario").classList.add("desaparecer");
            }
        </script>
    </body>
</html>