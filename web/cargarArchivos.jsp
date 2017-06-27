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
        <h1>Seleccione la Operacion</h1>
        
         <h1>Cargar archivo de usuarios!</h1>
        

   Seleccionar todo
<form method="post" enctype="multipart/form-data" action="archivos">
     <input type="file" name="file" /><br /><br />
     <input type="submit" name="upload" />
</form>



    </body>
</html>
