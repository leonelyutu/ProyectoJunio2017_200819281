class Nodo_juego():
    def __init__(self,usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano):
        self.usuario_oponente = usuario_oponente
        self.tiros_realizados = tiros_realizados
        self.tiros_acertados = tiros_acertados
        self.tiros_fallados = tiros_fallados
        self.resultado = resultado
        self.dano = dano
        pass

class lista_juego():
    def __init__(self):
        self.primero = None
        self.ultimo = None
        self.tam = 0
    
    def insertar_frente(self,usuario_oponente):
        
        nuevo = Nodo_juego()
        nuevo.usuario_oponente = usuario_oponente
        self.siguiente = None
        self.siguiente = None
        
        if(self.primero == None and self.ultimo == None):
            self.primero = nuevo
            self.ultimo = nuevo
            
        else:
            nuevo.anterior = None
            nuevo.siguiente = self.primero
            
            self.primero.anterior = nuevo
            self.primero = nuevo
         
    def insertar_cola(self,usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano):
        nuevo = Nodo_juego(usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano)
        ##nuevo.usuario_oponente = usuario_oponente
        
        if(self.primero == None and self.ultimo == None ):
            self.primero = nuevo
            self.ultimo = nuevo
            self.tam +=1
        else:
            
            nuevo.siguiente = None
            nuevo.anterior = self.ultimo
            
            self.ultimo.siguiente = nuevo
            self.ultimo = nuevo
            self.tam +=1
        
    def insertar_ordenado(self,usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano):
        
        
        if(self.buscar_clave(usuario_oponente) == True):
            print('Elemento ya existe')
#            
        elif(self.primero == None or self.primero.usuario_oponente>usuario_oponente):
            nuevo = Nodo_juego(usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano)
            ##nuevo.usuario_oponente = usuario_oponente
            
            nuevo.siguiente = self.primero
            nuevo.anterior = None
            self.primero = nuevo
            
            self.tam +=1
        
        else:
            
            aux = self.primero
            
            nuevo = Nodo_juego(usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano)
            ##nuevo.usuario_oponente = usuario_oponente
            
            while(aux.siguiente!=None and aux.siguiente.usuario_oponente <=usuario_oponente):
                aux = aux.siguiente
                
            nuevo.siguiente = aux.siguiente
            nuevo.anterior = aux
            aux.siguiente = nuevo
            aux.siguiente.anterior = nuevo
            
            
            
    def buscar_clave(self,usuario_oponente):
        aux = self.primero
        
        while(aux!=None):
            if(aux.usuario_oponente == usuario_oponente):
                return True
                break
            aux = aux.siguiente
        
    def imprimir(self):
            aux = self.primero
            while(aux!=None):
                print(aux.usuario_oponente,aux.tiros_fallados)
                
                aux = aux.siguiente
    
    def graficar(self):
        
        cadena = open("listadoble.dot","w")
        cadena.write("digraph g{\n")
        cadena.write("rankdir=LR\n")
        
        aux = self.primero
        while(aux!=None):
            cadena.write(str(aux) + "[label = "+str(aux.usuario_oponente) +" shape =box, style=filled, fillcolor=blue] \n")
            aux=aux.siguiente
           
        aux=self.primero
        while(aux!=None):
            cadena.write(str(aux)+"->"+str(aux.siguiente))
            aux=aux.siguiente
             
        cadena.write("}\n")
        cadena.close
        
        
#lista = lista_juego()
##print('primero')
#lista.insertar_cola(1,2,1,1,1,1)
#lista.insertar_cola(4,2,3,4,5,5)
#lista.insertar_cola(5,4,5,3,3,4)
#lista.insertar_ordenado(6,6,6,6,6,6)
#lista.graficar()
#
#
##lista.imprimir()
#
#print('ultimo')
##
##lista.insertar_ordenado(1)
##lista.insertar_ordenado(0)
##lista.insertar_ordenado(0)
##lista.insertar_ordenado(7)
##
##lista.insertar_ordenado(7)
#lista.imprimir()
####print(lista.insertar_ordenado(3))
#
#print('')

