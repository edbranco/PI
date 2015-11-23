<%-- 
    Document   : Login_Usuario
    Created on : 02/11/2015, 00:25:41
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
        <title>Login</title>
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />  
    </head>
    <body>
        
        <div id="login-box">
            <div id="login-titulo">
                <p>Login</p>
            </div>
            <div id="form-login">
                <form action="Login" method="post">
                    <div id="form-login-campos">
                        <fieldset>
                            <div class="form-group">
                                <label class="control-label col-sm-2">Usuário</label>
                                <div class="col-sm-10">
                                    <input type="text" name="usuario" class="form-control" /><br />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">Senha</label>
                                <div class="col-sm-10">
                                    <input type="password" name="senha" class="form-control" />
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div id="form-login-botoes">
                        <input class="btn btn-default" type="submit" name="valor"  value="OK" />
                        <input class="btn btn-default" type="reset" name="limpar"  value="Limpar" />
                    </div>
                </form>
            </div>
        </div>
        
        <!-- Scripts: jQuery e Bootstrap -->
        <script type="text/javascript" src="${pathResources}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pathResources}/js/bootstrap.min.js"></script>
    </body>
</html>