<%-- 
    Document   : bienvenidoJugador
    Created on : Jun 30, 2017, 10:51:45 AM
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
    <center>
        <div>
            <form action="bienvenidoJugador" method="post">
        <h1>Bienvenido a BattleShip</h1>
        <br>
        <br>
        <br>
        <h1>Elija una operacion</h1>
         <h1> </h1>
        <br>
         <br>
          <br>
          
         <h1>Cargar Naves: esta opcion permite generar las naves sobre el campo de batalla</h1>
         <br>
          <br>
           <br>
           
        <input type="submit" name="cargaNaves" value="Cargar"> 
        <br>
        <br>
        <h1>Iniciar Juego </h1>
         <input type="submit" name="jugar" value="Jugar"> 
        <br>
         <br>
        </form>
        </div>
        </center>
    </body>
</html>
