<%-- 
    Document   : index
    Created on : Jun 21, 2017, 5:28:47 PM
    Author     : lio
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Registro</title>
</head>
<body>
<div align="center">
<table>
<tr>
<td>Registre sus Datos</td>
<td></td>
</tr>
<tr>
<td>
<form action="controler" method="post">
<table>
<tr>
<td>Nombre:</td>
<td><input type="text" size="20" name="nombre"></td>
</tr>
<tr>
<tr>
<td>Contraseņa:</td>
<td><input type="password" size="20" name="clave"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" name = "nuevoUsuario" value="Registrar"></td>
</tr>
</table>
</form>
</td>
<td>

</td>
</tr>
</table>
</div>
</body>
</html>

