<%-- 
    Document   : adminAVL
    Created on : Jul 14, 2017, 9:28:47 AM
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
        <h1>Bienvenido a Administracion de Arbol AVL</h1>
    </body>
    
    
    <center>
<div align="center">
    
    
<table>
<tr>
    
<center>
<td>Mostrar Contenido de AVL de usuario</td>
</center> 
<td></td>
</tr>
<tr>
<td>
<form action="adminAVL" method="post">
<table>
<tr>
<td>Nombre de Usuario:</td>
<td><input type="text" size="20" name="nombre"></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" name = "Buscar" value="Buscar"></td>
<br>

</tr>
</table>
</form>
</td>

<td>
<form action="adminAVL" method="post">
<table>
<tr>
<td><td>Ingrese un Contacto a eliminar</td></td>
<td><input type="text" size="20" name="nombre_contacto"></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" name = "eliminar" value="Eliminar"></td>
<br>

</tr>
</table>
</form>
</td>

<form action="adminAVL" method="post">
<table>
    <td>Modificar Usuario:</td>
<tr>
<td> Nombre de Contacto:</td>
<td><input type="text" size="20" name="nombre_contacto"></td>
</tr>    
    
<tr>
<td>nuevo Nombre:</td>
<td><input type="text" size="20" name="nuevo_nombre"></td>
</tr>

<tr>
<td>nueva Contraseña:</td>
<td><input type="password" size="20" name="nueva_clave"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" name = "modificar" value="Modificar"></td>
<br>
</tr>
</table>
</form>


<td>
</td>
</tr>
</table>
    
    
    
</div>
    </center>
    
    
</html>
