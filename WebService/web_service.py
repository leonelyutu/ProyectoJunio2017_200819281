import arbolBB
from flask import Flask, jsonify, request
import logging
from logging.handlers import RotatingFileHandler
import juego
import lienzo


tree = arbolBB.arbol()
juego_nuevo = juego.Juego()

app = Flask("Proyecto Junio 2017")

@app.route('/tarea', methods = ['POST']) 
def h():
    
    parametroPython2 = str(request.form['entrada'])
    return "parametro = " + parametroPython2

@app.route('/arbolBB', methods = ['POST'])
def aBB():
    nombre = str(request.form['nombre'])
    clave = str(request.form['clave'])
    conectado = str(request.form['conectado'])    
    tree.root = tree.insert(tree.root, nombre,clave,conectado)
    
#    tree.inorder(tree.root)
#    result = tree.recorrer_lista()

    return "Exito"


@app.route('/inordenABB',methods = ['GET'])
def inorden():
    tree.inorder(tree.root)
    result = tree.recorrer_lista()
    app.logger.info(result)
    return result

@app.route('/arbolGraficar', methods = ['GET'])
def graficar():
    tree.graficar(tree.root)
    result = tree.generar_dot()
    return result


@app.route('/buscarArbol',methods = ['POST'])
def buscar():
    existe = "no existe"
    ##usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano
#    
#           .add("usuario_oponente",usuario_oponente)
#            .add("tiros_realizados",tiros_realizados)
#            .add("tiros_acertados",tiros_acertados)
#            .add("tiros_fallados",tiros_fallados)
#            .add("resultado",resultado)
#            .add("dano",dano)
    nombre_nodo = str(request.form['nombre'])
    
    usuario_oponente=str(request.form['usuario_oponente'])
    tiros_realizados=str(request.form['tiros_realizados'])
    tiros_acertados=str(request.form['tiros_acertados'])
    tiros_fallados=str(request.form['tiros_fallados'])
    resultado=str(request.form['resultado'])
    dano=str(request.form['dano'])

    #############implementar en enlace con los usuarios de juego actual####
    nodito = tree.buscar(nombre_nodo,tree.root)
    
    #if(nodito!=None):
    nodito.lista_juego.insertar_cola(usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano)
    nodito.lista_juego.graficar()
    app.logger.info("insertado en lista: " + str(nodito.dato))
    
    existe = "Insertado en lista"    
    return existe

@app.route('/buscar_logeo',methods=['POST'])
def buscar_usuario():
    nombre = str(request.form['nombre'])
    clave=str(request.form['clave'])
    nodito = tree.buscarconclave(nombre,tree.root,clave)
    existe = "false"
    if (nodito!=None):
        if(nodito.dato == nombre and clave == nodito.contrasena):
            existe = "true"
        
    return existe

    
    

@app.route('/llenarNaves',methods=['POST'])
def llenarNaves():
    ##jugador,columna,fila,nivel,mode,direccion
    jugador=str(request.form['jugador'])
    columna=str(request.form['columna'])
    fila=str(request.form['fila'])
    nivel=str(request.form['nivel'])
    mode=str(request.form['mode'])
    direccion=str(request.form['direccion'])
    app.logger.info('########################################################')
    app.logger.info('jugador: ' +jugador)
    app.logger.info('########################################################')
    app.logger.info('########################################################')
    app.logger.info('jugador: ' +juego_nuevo.jugador1.nombre)
    app.logger.info('########################################################')

    app.logger.info("viene de fila:"+fila)
    
    
    juego_nuevo.llenar_niveles(jugador,str(fila),str(columna),nivel,mode,direccion)
#    
#    if(juego_nuevo.jugador1.nombre==jugador):
#        if(nivel == "1"):
#            juego_nuevo.jugador1.cubo.insertar_satelites(str(fila),str(columna),'satelite')
#            
    juego_nuevo.jugador1.cubo.graficar_dot_satelite()
    
    app.logger.info('Nombre concide con jugador')


    return juego_nuevo.jugador2.nombre

@app.route('/juegoActual',methods = ['POST'])
##jugador1,jugador2,tamanoX,tamanoY,variante,tiempo,disparo,numero_rafagas
def juegoActual():
    ##jugador1,jugador2,tamanoX,tamanoY,variante,tiempo,disparo,numero_rafagas
    
    jugador1=str(request.form['jugador1'])
    jugador2=str(request.form['jugador2'])
    tamanoX=str(request.form['tamanoX'])
    tamanoY=str(request.form['tamanoY'])
    variante=str(request.form['variante'])
    tiempo=str(request.form['tiempo'])
    disparo=str(request.form['disparo'])
    numero_rafagas=str(request.form['numero_rafagas'])

    
    juego_nuevo.iniciar(jugador1,jugador2,tamanoX,tamanoY,variante,tiempo,disparo,numero_rafagas)
    juego_nuevo.jugador1.cubo.obtener_maxFila_satelite()##otra forma de acceer a los valores de los niveles, lienzos
    juego_nuevo.obtenerMaxfila_satelite()
    juego_nuevo.obtenerMaxCol_satelite()
    juego_nuevo.jugador1.cubo.graficar_dot_satelite()
    app.logger.info('')
    
    dimensionY = str(juego_nuevo.jugador1.cubo.obtener_maxFila_satelite())
    dimensionX = str(juego_nuevo.obtenerMaxCol_satelite())
    jugador1 = juego_nuevo.jugador1.nombre
    return ("Satelite: Y:"+dimensionY+"X: " + dimensionX +":" + jugador1)
###METODOS PARA GRAFICAR LIENZOS 1#########

@app.route('/graficar_satelite', methods = ['GET'])
def graficar_satelite():
    app.logger.info('antes de resultado') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
    app.logger.info(str(resultado))
    return str(resultado)

@app.route('/graficar_avion1', methods = ['GET'])
def graficar_avion1():
    app.logger.info('antes de resultado') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_avion()
    app.logger.info(str(resultado))
    return str(resultado)

    
@app.route('/graficar_barco1', methods = ['GET'])
def graficar_barco1():
    app.logger.info('antes de resultado BARCO1') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_barco()
    app.logger.info(str(resultado))
    return str(resultado)

@app.route('/graficar_submarino1', methods = ['GET'])
def graficar_submarino():
    app.logger.info('antes de resultado') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_submarino()
    app.logger.info(str(resultado))
    return str(resultado)


########################################################


###############generar grafos me jugador 2######

###METODOS PARA GRAFICAR LIENZOS 2#########

@app.route('/graficar_satelite2', methods = ['GET'])
def graficar_satelite2():
    app.logger.info('antes de resultado') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    juego_nuevo.jugador2.cubo.graficar_dot_sateliteJ2()
    resultado = juego_nuevo.jugador2.cubo.generar_dot_string_sateliteJ2()
    app.logger.info(str(resultado))
    return str(resultado)

@app.route('/graficar_avion2', methods = ['GET'])
def graficar_avion2():
    app.logger.info('antes de resultado avion') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador2.cubo.generar_dot_string_avionJ2()
    app.logger.info(str(resultado))
    return str(resultado)

    
@app.route('/graficar_barco2', methods = ['GET'])
def graficar_barco2():
    app.logger.info('antes de resultado barco') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador2.cubo.generar_dot_string_barcoJ2()
    app.logger.info(str(resultado))
    return str(resultado)

@app.route('/graficar_submarino2', methods = ['GET'])
def graficar_submarino2():
    app.logger.info('antes de resultado') 
#    resultado = juego_nuevo.jugador1.cubo.generar_dot_string_satelite()
#    app.logger.info(resultado)
    resultado = juego_nuevo.jugador2.cubo.generar_dot_string_submarinoJ2()
    app.logger.info(str(resultado))
    return str(resultado)



@app.route('/hola', methods = ['GET']) 
def he():
    return "hola Mundo" 

if __name__ == "__main__":
    app.run(debug=True, port = 8080)

