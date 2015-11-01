<%-- 
    Document   : Listar
    Created on : 21/10/2015, 09:01:58
    Author     : Eder Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" />
        
        <h1>Hello World!</h1>
        <table>
           <tr>
               <th>#</th>
               <th>Nome</th>
               <th>E-mail</th>
           </tr>
           <c:forEach items="${produtos}" var="pro" varStatus="stat">
           <tr>
               <td>${stat.count}</td>
               
               <td>${pro.id}</td>
               <td>${pro.nome}</td>
               <td>${pro.marca}</td>
               <td>${pro.preco}</td>
               <td>${pro.qtde}</td>
           </tr>
           </c:forEach> 
       </table>
       <a href="index.html">Voltar</a>
    </body>
</html>
