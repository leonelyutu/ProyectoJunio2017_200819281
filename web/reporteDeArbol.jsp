<%-- 
    Document   : reporteDeArbol
    Created on : Jun 30, 2017, 1:59:20 PM
    Author     : lio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%--arbol--------------------------------%>
        
            <form action="setearImagen" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="VerArbol"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearImagen" name="mierda">

             <%--arbol--------------------------------%>
             
              <%--SATELITE--------------------------------%>
            
             <form action="setearImagenMatrizSatelite1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Satelite1"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearImagenMatrizSatelite1" name="mierda">

            <br>
            <br>
            <br>
            
             <%--AVION-------------------------------%>
            
             <form action="setearIMA1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Avion1"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearIMA1" name="mierda">

        
              <br>
            <br>
            <br>
            
             <%--BARCO--------------------------------%>
             <form action="setearIMB1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Barco1"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearIMB1" name="mierda">
            
              <br>
            <br>
            <br>
             <%--SUBMARINO--------------------------------%>
            
             <form action="setearIMS1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Submarino1"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearIMS1" name="mierda">
            
            
              <%--satelite 2--------------------------------%>
            
             <form action="setearMAJ1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz satelite2"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearMAJ1" name="mierda">
            
            <br
                
                      
             <form action="setearMAJ2" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver MatrizAvion2"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearMAJ2" name="mierda">
            
            <br
            
    </body>
</html>
