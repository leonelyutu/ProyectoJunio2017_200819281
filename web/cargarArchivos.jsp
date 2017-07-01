<%-- 
    Document   : cargarArchivos
    Created on : Jun 22, 2017, 4:09:48 PM
    Author     : lio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a la carga de archivos</title>
    </head>
    <body>
        
        <div align="centar"> 
        <h1 align = "center">Seleccione una Operacion</h1>
        
         <h1 align="center">Cargar archivo de usuarios</h1>
        </div>
            
    <center>
        <div> 
            <form method="post" enctype="multipart/form-data" action="archivos">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadusuarios" value="Cargar Usuarios" />
            </form>
            
                   <h1>Cargar Arvhivo de listaa de Juegos</h1>
   <form method="post" enctype="multipart/form-data" action="cargaJuegos">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadjuegos" value="Cargar Lista Juegos"/>
    </form>
           
                    <h1>Cargar archivo de juego actual</h1>
            
   <form method="post" enctype="multipart/form-data" action="juegoActual">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadjuegoactual" value="Juego Actual" />
    </form>
                   
                   <h1>Cargar archivo de naves</h1>
            <form method="post" enctype="multipart/form-data" action="cargaNaves">
         <input type="file" name="file" /> <br /> <br />
         <input  type="submit" name="cargaNaves" value="Cargar Naves" />
            </form>
   
           
   
     
            
            <h1>Ver Reportes</h1>
            <form method="post"  action="reportes">
       
       
       <input type="submit" name="verreportes" value="Reportes" />
    </form>
            
            
   <form method="post"  action="controler">
       
       
       <input type="submit" name="salir" value="Salir" />
    </form>
            
            
            

        </div>
    </center>


    </body>
</html>
