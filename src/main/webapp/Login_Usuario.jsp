<%-- 
    Document   : Login_Usuario
    Created on : 02/11/2015, 00:25:41
    Author     : Ude
--%>

<%
    if (request.getAttribute("falha") != null) {
%>

<script type="text/javascript"> alert(<%= request.getAttribute("falha")%>)</script>

<%
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "Logout_Servlet" method ="post">
            <fieldset>
                <h3> Login </h3>
                <p>
                    <label for="nomeusuario">Nome:</label>
                    <input type="text" name="nomeUsuario" id="nomeusuario">
                </p>
                <p>
                    Senha: <input type="password"/>
                </p>

                <p>
                    <input type ="submit" name ="menu.jsp"/> 
                </p>

                <p>
                    <input type="reset" name ="Limpar"/>
                </p>
                
                <p>
            </fieldset>
        </form>
    </body>
</html>