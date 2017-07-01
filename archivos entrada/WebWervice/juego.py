import lienzo

class Jugador():##nombre, es el nombre que viene del archivo, fila, es la fila del archivo, columna, es la columna del archivo
            ##llenar con archivo juego actual
    def __init__(self,nombre,fila,columna):
        self.nombre = nombre
        self.cubo = lienzo.Lienzos(fila,columna)
        self.identificador = None ##puede ser jugador 1 o jugador 2
 
    
    

class Juego():
    def __init__(self):
        self.jugador1 = None
        self.jugador2 = None
        print()
    
    
    ##Usuario1,Usuario2, TamaoX,TamaoY," Variante (1 = normal, 2 = con tiempo)",tiempo (si aplica),"disparo (1 = 1 por 1, 2= rafaga)",numero de rafagas (si aplica)
    ##numero de rafagas puede ser None
    ##llenar con archivo de juego actual
    def iniciar(self,jugador1,jugador2,tamanoX,tamanoY,variante,tiempo,disparo,numero_rafagas):
        
        self.jugador1 = Jugador(jugador1,tamanoY,tamanoX)
        self.jugador2 = Jugador(jugador2,tamanoY,tamanoX)
        
        ##esta copia es para tablero Inicial
        
        self.copia_jugador1 = self.jugador1
        self.copia_jugador2 = self.jugador2
    
       
        self.variante = variante
        self.tiempo = tiempo
        self.disparo = disparo
        self.numero_rafagas = numero_rafagas
        
       ###aqui se llaman los metodos declarados en lienzo, y son llamados desde el @app route
    
    
    
    def graficar_dot_satelite(self):
        self.jugador1.cubo.graficar_dot_satelite()
          ##llenar con archivo naves.csv    
    def obtenerMaxfila_satelite(self):
        return str(self.jugador1.cubo.obtener_maxFila_satelite())
    def obtenerMaxCol_satelite(self):
        return str(self.jugador1.cubo.obtener_maxCol_satelite())
    
    
    
    
    def llenar_niveles(self,jugador,columna,fila,nivel,mode,direccion):
        ##self.jugador1.cubo.insertar_satelites(int(fila),int(columna),"satelite")

        
        if(self.jugador1.nombre == jugador):
            
            if(nivel == "1"):
                self.jugador1.cubo.insertar_satelites(int(fila),int(columna),"satelite")
                self.jugador1.cubo.graficar_dot_satelite()
            if(nivel == "2"):
                self.jugador1.cubo.insertar_aviones(int(fila),int(columna),"avion")
                self.jugador1.cubo.graficar_dot_avion()
            if(nivel == "3"):
                self.jugador1.cubo.insertar_barcos(int(fila),int(columna),"barco")
                self.jugador1.cubo.graficar_dot_barco()
                
            if(nivel == "4"):
                self.jugador1.cubo.insertar_submarinos(int(fila),int(columna),"submarino")
                self.jugador1.cubo.graficar_dot_submarino()

        elif(self.jugador2.nombre == jugador):
            if(nivel == "1"):
                self.jugador2.cubo.insertar_satelites(int(fila),int(columna),"satelite")
                self.jugador2.cubo.graficar_dot_sateliteJ2()
                self.jugador2.cubo.generar_dot_string_satelite2()
                
            if(nivel == "2"):
                self.jugador2.cubo.insertar_aviones(int(fila),int(columna),"avion")
                self.jugador2.cubo.graficar_dot_avionJ2()
            if(nivel == "3"):
                self.jugador2.cubo.insertar_barcos(int(fila),int(columna),"barco")
                self.jugador2.cubo.graficar_dot_barcoJ2()
                
            if(nivel == "4"):
                self.jugador2.cubo.insertar_submarinos(int(fila),int(columna),"submarino")
                self.jugador2.cubo.graficar_dot_submarinoJ2()


        ##############AQUI SE ESTA QUEDANDO######################
        
        ##app.logger.info('entro a insertar')

#        if(jugador==self.jugador1.nombre):
#            ##llenar las matrices del jugador uno
#            if(nivel == 1):
#                self.jugador1.cubo.insertar_satelites(int(fila),int(columna),"satelite")
                ##satelite
#            elif(nivel == 2):
#                self.jugador1.cubo.insertar_avions(int(fila),int(columna),"avion")
#
#                ##avion
#            elif(nivel == 3):
#                self.jugador1.cubo.insertar_barcos(int(fila),int(columna),"barco")
#
#                ##barco
#                
#            elif(nivel == 4):
#                self.jugador1.cubo.insertar_submarinos(int(fila),int(columna),"sub")
#
#                ##submarino
#                
#        
#        elif(jugador == self.jugador2.nombre):
#            if(nivel == 1):
#                self.jugador2.cubo.insertar_satelites(int(fila),int(columna),"satelite")
#
#            elif(nivel == 2):
#                self.jugador2.cubo.insertar_aviones(int(fila),int(columna),"avion")
#
#            elif(nivel == 3):
#                self.jugador2.cubo.insertar_barcos(int(fila),int(columna),"barco")
#
#            elif(nivel == 4):
#                self.jugador2.cubo.insertar_submarinos(int(fila),int(columna),"sub")

                
    
            
        
        
        
    
        
  
        