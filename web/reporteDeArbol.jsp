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
        <br>

                <img src="<%=request.getContextPath()%>/setearImagen" name="mierda">
            <br>
             
           
             <%--arbol--------------------------------%>

                      
              <%--SATELITE--------------------------------%>
            
             <form action="setearImagenMatrizSatelite1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Satelite1"></td>
    </form>
            <br>

                <img src="<%=request.getContextPath()%>/setearImagenMatrizSatelite1" name="mierda">

            <br>
            <br>
            <br>
            
        <%--SATELITE--------------------------------%>
              
        <%--AVION-------------------------------%>
            
             <form action="setearIMA1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Avion1"></td>
    </form>
     <br>
                <img src="<%=request.getContextPath()%>/setearIMA1" name="mierda">

              <br>
            <br>
            <br>
         <%--AVION-------------------------------%>
            
      <%--BARCO--------------------------------%>
             <form action="setearIMB1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Barco1"></td>
    </form>
            <br

                <img src="<%=request.getContextPath()%>/setearIMB1" name="mierda">
            
              <br>
            <br>
            <br>
      <%--BARCO--------------------------------%>
   
             
            <%--SUBMARINO--------------------------------%>
            
             <form action="setearIMS1" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Submarino1"></td>
    </form>
                        <br>

                <img src="<%=request.getContextPath()%>/setearIMS1" name="mierda">
            
                <br>
                 <br>
                
                  <br>
                
      <%--SUBMARINO--------------------------------%>
      
      
          <%--satelite 2--------------------------------%>
            
             <form action="setearImagenMatrizSatelite2" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz satelite2"></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearImagenMatrizSatelite2" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
           <%--satelite 2--------------------------------%>
      
          <%--Avion 2--------------------------------%>
            
             <form action="setearMAJ2" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Avion 2"></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearMAJ2" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
           <%--Avion 2--------------------------------%>   
         
       <%--Barco 2--------------------------------%>
            
             <form action="setearMBJ2" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Matriz Barco 2"></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearMBJ2" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
           <%--Barco 2--------------------------------%>   
     
     <form action="setearMSJ2" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Submarino 2"></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearMBSJ2" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
                  
             <%--Barco 2--------------------------------%>        
            
               <%--Arbol B--------------------------------%>   
     
      <form action="setearImagenAB" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Arbol B "></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearImagenAB" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
           <%--Arbol B--------------------------------%>   
               
             
                  
           <%--Tabla Hash--------------------------------%>   
     
      <form action="setearImagenHash" method="post">
    <td colspan="2" align="center"><input type="submit" name = "login" value="Ver Hash "></td>
    </form>
          <br>

                <img src="<%=request.getContextPath()%>/setearImagenHash" name="mierda">
            
            <br>
             <br>
                
                  <br>
                
           <%--Tabla Hash--------------------------------%>   
           
           
    
    </body>
</html>
