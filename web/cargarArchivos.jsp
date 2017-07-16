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
        <h1 align = "center">EDD Junio 2017 Primera Fase</h1>
        
        </div>
        
        <div align="centar"> 
        <h1 align = "center">Seleccione una Operacion</h1>
        
        
        
         <form method="post" enctype="multipart/form-data" action="adminAVL.jsp">
         
         <input type="submit" name="AdminAVL" value="Ir a AVL" />
            </form>
        
             <form method="post" enctype="multipart/form-data" action="AdminArbolB.jsp">
         
         <input type="submit" name="AdminHash" value="Ir a Arbol B" />
            </form>
        
             <form method="post" enctype="multipart/form-data" action="adminHash.jsp">
         
         <input type="submit" name="AdminHash" value="Ir a tabla hash" />
            </form>
        
        
         <h1 align="center">Cargar archivo de usuarios</h1>
        </div>       
    <center>
       
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
    
        <div align="centar"> 
        <h1 align = "center">EDD Junio 2017 Segunda Fase</h1>
                   
        
                  <h1>Cargar Archivo de Contactos</h1>
   <form method="post" enctype="multipart/form-data" action="cargar_archivo_contactos">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadjuegos" value="Cargar Contactos"/>
    </form>
        
                      <h1>Cargar Archivo de Historial de Juegos</h1>
   <form method="post" enctype="multipart/form-data" action="cargaHistorialdeJuegos">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadjuegos" value="Cargar Historial de Juegos"/>
    </form>
                  
                      
                        <h1>Cargar Archivo de Tiros</h1>
   <form method="post" enctype="multipart/form-data" action="carga_tiros">
         <input type="file" name="file" /><br /><br />
         <input type="submit" name="uploadjuegos" value="Cargar Tiros"/>
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
