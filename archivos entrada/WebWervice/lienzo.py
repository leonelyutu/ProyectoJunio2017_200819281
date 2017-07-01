import matriz

class Lienzos():
    ##inicializar matrizes y lienzos, uno por cada nivel
    
    def __init__(self,row,col):
        self.submarinos = matriz.MatrizDispersa(int(row),int(col))##nivel4
        self.barcos = matriz.MatrizDispersa(int(row),int(col))#3nivel3
        self.aviones = matriz.MatrizDispersa(int(row),int(col))##nivel2
        self.satelites = matriz.MatrizDispersa(int(row),int(col))##nivel1
        
        
    ################   METODOS PARA DEVOLVER ALGUNAS FUNCIONES UTILES DE LA MATRIZ###################    
        ##################declarado en lienzos, estos metodos son llamados desde juego
        
        
    def graficar_dot_sateliteJ2(self):
        self.satelites.generar_dot_nombre("sateliteJ2")
 
    def graficar_dot_avionJ2(self):
        self.aviones.generar_dot_nombre("avionJ2")
        
    def graficar_dot_barcoJ2(self):
        self.barcos.generar_dot_nombre("barcoJ2")
        
    def graficar_dot_submarinoJ2(self):
        self.submarinos.generar_dot_nombre("submarino2")
        
    def graficar_dot_satelite(self):
        self.satelites.generar_dot_nombre("satelite")
 

    def graficar_dot_avion(self):
        self.aviones.generar_dot_nombre("avion")
        
    def graficar_dot_barco(self):
        self.barcos.generar_dot_nombre("barco")
        
    def graficar_dot_submarino(self):
        self.submarinos.generar_dot_nombre("submarino")
    
     #######generar cadenas String para devolver a JAVA
    def generar_dot_string_satelite(self):
        
        result = self.satelites.generar_dot_string("satelite")
        
        return str(result)
    
    def generar_dot_string_avion(self):
        result = self.aviones.generar_dot_string("avion")
        return str(result)
        
        
    def generar_dot_string_barco(self):
        result = self.barcos.generar_dot_string("barco")
        return result
    
    def generar_dot_string_submarino(self):
        result = self.submarinos.generar_dot_string("submarino")
        return result



    def generar_dot_string_satelite2(self):
        result = self.satelites.generar_dot_string("sateliteJ2")
        return str(result)
    
    def generar_dot_string_avion2(self):
        result = self.aviones.generar_dot_string("avionJ2")
        return result
        
    def generar_dot_string_barco2(self):
        result = self.barcos.generar_dot_string("barcoJ2")
        return result
    
    def generar_dot_string_submarino2(self):
        result = self.submarinos.generar_dot_string("submarinoJ2")
        return result
    
    
    
    def obtener_maxFila_satelite(self):
        return str(self.satelites.obtenerMaxFila())
    
    def obtener_maxCol_satelite(self):
        return str(self.satelites.obtenerMaxCol())
    
    ###################METODO PARA INSERTAR EN LA MATRIZ#################
    
    def insertar_submarinos(self,row,col,valor):
        self.submarinos.insertarValor(row,col,valor)
        return True
    
    def insertar_barcos(self,row,col,valor):
        self.barcos.insertarValor(row,col,valor)
        return True
    
    def insertar_aviones(self,row,col,valor):
        self.aviones.insertarValor(row,col,valor)
        return True
    
    def insertar_satelites(self,row,col,valor):
        self.satelites.insertarValor(row,col,valor)
        return True

    