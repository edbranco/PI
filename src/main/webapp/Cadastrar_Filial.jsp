<%-- 
    Document   : filial
    Created on : 25/10/2015, 21:04:10
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Filial</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
       
        <div class="formulario">
            <form action="ServletFilialCadastrar" method="post" onsubmit="return validarFilialCadastrar();">
                 <fieldset>
                    <legend>Cadastrar Filial</legend>  
                    <p>
                        <label for="nomefilial">Nome:</label><br />
                        <input type="text" maxlength="20" name="nomefilial" id="nomefilial" class="ipt-largo form-control" required />
                    </p>
                    <p class="ipt-largo">
                    <label for="uf">UF:</label><br />
                    <select name="uf" id="uf" class="ipt-select form-control">
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
                <div id="err-campo-estado" class="alert alert-danger">
                    <strong>Atenção!</strong> Escolha um Estado.
                </div>
                    <p>
                        <label for="cnpj">CNPJ:</label><br />
                        <input type="text" name="cnpj" id="cnpj" class="ipt-largo form-control" required />
                    </p>
                    <input class="btn btn-default" type="submit" value="Cadastrar"/>
                    <a href="Menu.jsp"><input class="btn btn-default" type="button" value="Cancelar"/></a>
                 </fieldset>
            </form>
        </div>
        <div id="suc-cad-filial" class="alert alert-success">
            Filial cadastrada com sucesso!
        </div>
        
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <!--Máscaras-->
        <script>
            jQuery(function($){
                $("#cnpj").mask("999999999999");
            });
        </script>
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-cad-filial").classList.add("aparecer");
            } else {
                document.getElementById("suc-cad-filial").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
