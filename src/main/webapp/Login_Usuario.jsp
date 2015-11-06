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

        <form action="ServletLogin" method="post">
            <label>Usuário</label>
            <input type="text" name="usuario"/>
            <label>Senha</label>
            <input type="password" name="senha"/>

            <input type="submit" name="valor" value="OK"/>
        </form>
    </body>
</html>