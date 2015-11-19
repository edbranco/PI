<%-- 
    Document   : Login_Usuario
    Created on : 02/11/2015, 00:25:41
    Author     : Ude
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="ServletLogin" method="post">
            <fieldset>
                <label>Usuário</label>
                <input type="text" name="usuario"/>
                <label>Senha</label>
                <input type="password" name="senha"/>

                <input type="submit" name="valor" value="OK"/>
            </fieldset>
        </form>
    </body>
</html>