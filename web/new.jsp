<%-- 
    Document   : new
    Created on : Jun 21, 2017, 6:53:32 PM
    Author     : lio
--%>

<% String variable = request.getParameter("resultado"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1><input type="text" value="${resultado}"></h1>
    
        <form action="controler" method="post">

    <td><input type ="submit" name ="regresar" value="regresar"></td>
    </body>
    </form>
</html>
