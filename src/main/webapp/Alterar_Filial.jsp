<%-- 
    Document   : Alterar_Filial
    Created on : 05/11/2015, 17:47:42
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
        <title>Alterar Filial</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${pathResources}/js/validacao.js"></script>
    </head>
    <body>                  
        <jsp:include page="Menu.jsp" />
            
        <div class="formulario">
            <form action="ServletFilialAlterar" method="post">  
                <fieldset>
                    <legend>Alterar Produtos</legend>  
                    <p>
                        <label for="txtId">Digite o ID da Filial:</label>
                        <input type="number" name="idFilial" id="idFilial" value="${filial.idfilial}" class="ipt-id" />
                    </p>
     
                    <p>
                        <label for="txtNome">Nome da Filial:</label><br />
                        <input type="text" name="nomeFilial" id="nomeFilial" value="${filial.nomefilial}" class="ipt-largo" />
                    </p>
                    <p>
                        <label for="txtNome">Cnpj:</label><br />
                        <input type="text" name="cnpj" id="cnpj" value="${filial.cnpj}" class="ipt-largo" />
                    </p>
                    <p class="ipt-largo">
                    <label for="uf">UF:</label><br />
                    <select name="uf" id="uf" class="ipt-largo">
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
                    
                    <input type="submit" name="btn-consultar" value="Pesquisar" />
                    <input type="submit" name="btn-consultar" value="Alterar" />
                </fieldset>
            </form>
        </div>
        <div id="suc-alt-filial" class="alert alert-success">
            Filial alterada com sucesso!
        </div>
                    
                    
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>    
        <script type="text/javascript" src="${pathResources}/js/jquery.maskedinput.js"></script>
        
        <script>
            if (${mensagem} === true) {
                document.getElementById("suc-alt-filial").classList.add("aparecer");
            } else {
                document.getElementById("suc-alt-filial").classList.add("desaparecer");
            }
        </script>
    </body>
</html>
