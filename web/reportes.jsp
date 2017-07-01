<%-- 
    Document   : reportes
    Created on : Jun 29, 2017, 2:18:03 PM
    Author     : lio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes de Juego</title>
    </head>
    <body>
        
        <form action="reportes" method="post">
    <center>
        <h1>Elija un tipo de Reporte</h1>
        <br>
        <br>
        <br    
        <h1>Esta opcion muestra el grafo del arbol Binario de Busqueda </h1>
        <br>
        <input type="submit" name="arbol" value="Ver Arbol"> 
        <br>
        <br>
        <h1>Esta opcion muestra la lista de juegos </h1>
         <input type="submit" name="listajuegos" value="Ver lista"> 
        <br>
         <br>
        <h1>Esta opcion muestra los grafos de Cada Jugador</h1>
         <input type="submit" name="reporteJuegosAdmin" value="entrar"> 
        <br>
        
        
        
        
    </center>
        </form>
        
        
    </body>
</html>
