<%-- 
    Document   : tablero
    Created on : Jun 29, 2017, 3:11:30 PM
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
        
        <table>
      <% for (int i=0;i<10;i++)
{ %>
      <tr><td> <%=i%> </td></tr>
      <% }
      %>
</table>
        



        
        	<script>
		function refrescarCeldas(){
			$.get( "https://api.myjson.com/bins/qk4pv" )
			.done(function(data){
				console.log(data);
				data.forEach(function(celda) {
				    //console.log("Celda x:" + celda.x + " y:" + celda.y + " valor:" + celda.value);
				});

				for(var j=0; j<sizeY;j++){
					var fila = "<tr>";
					for(var i=0; i<sizeX;i++){
						var celdaActual = data.filter(function ( celda ) {
						    return celda.x === (i + 1) && celda.y == (j + 1);
						})[0];

						var valor = "";
						if(celdaActual)
							valor = celdaActual.value;

						fila = fila + "<td id='"+i + "," + j +"'>"+ valor +"</td>";
					}
					fila = fila + "</tr>";
					$("#myTable").append(fila);
				}

				$("td").on("click",function(){
					var id = $(this).attr("id");
					var coordenadas = id.split(",");
					alert("Ha dado click a x:" + coordenadas[0] + " y:" + coordenadas[1]);
				})
			});
		}
                
	</script>
    </body>
</html>
