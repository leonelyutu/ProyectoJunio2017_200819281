# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "lio"
__date__ = "$Jun 20, 2017 2:24:34 PM$"

if __name__ == "__main__":
    print "Hello World"
 
class Nodo():
    def __init__(self, fil, col, value, abajo, derecha):
        self.fil = fil
        self.col = col
        self.value = value
        self.abajo = abajo
        self.derecha = derecha



class MatrizDispersa():
    
    def __init__(self, filsize, colsize):
        self.maxFila = filsize
        self.maxColumna = colsize
    
        self.ultimoFila = Nodo(filsize+1,0,1000,None,None)
        self.ultimoColumna = Nodo(0,colsize + 1, 1000, None, None )
        self.cabeza = Nodo(0,0,0,self.ultimoFila,self.ultimoColumna)
        ##la matriz apunta a los ultimos elementos de las flas y las columnas, tomar en cuenta al insertar
        
    def obtenerMaxFila(self):
        return str(self.maxFila)
    
    def obtenerMaxCol(self):
        return str(self.maxColumna)
   
        
    def obtenerValor(self,fil,col):
        
        actual = None
        value = 0
        
        actual = self.buscarValor(fil,col)
        
        if(actual != None):
            value = actual.value
        
        return value
        
    def insertarValor(self,fil,col,nuevoValor):
        
        anterior = None
        actual = None
        
        
        actual = self.buscarValor(fil,col)
        
        if(actual != None):
            actual.value = nuevoValor
            if(actual.value == 0 ):
                self.buscarAbajo(fil,col).abajo = actual.abajo
                self.buscarDerecha(fil,col).derecha = actual.derecha
                if(esVaciaFila(fil)):
                    borrarFila(fil)
                if(esVaciaColumna(col)):
                    delete(col)
        else:
            if(self.buscarValor(fil,0) == None):
                self.crearFila(fil)
            if(self.buscarValor(0,col) == None):
                self.crearColumna(col)
                
            actual = self.cabeza
            fiAc = self.cabeza
            while(fiAc.fil < fil):
                fiAc= fiAc.abajo
            colAc = fiAc    
            while(colAc.col<col):
                anterior=colAc
                colAc = colAc.derecha
            
            anterior.derecha = Nodo(fil, col, nuevoValor,None,colAc)
            nArriba  = (self.buscarAbajo(fil, col))
            nAuxAbajo = nArriba.abajo
            nArriba.abajo = anterior.derecha
            anterior.derecha.abajo = nAuxAbajo
#            self.buscarAbajo(fil,col).abajo = anterior.derecha
                    
        
    def buscarValor(self,fil,col):
        
        actual = self.cabeza
        encontrado = None
        
        while(actual.fil < fil):
            actual = actual.abajo
            
            
        if actual.fil == fil:   
            while(actual.col < col):
                actual = actual.derecha
            if(actual.col == col):
                encontrado = actual
                
        return encontrado
            
    
    def buscarAbajo(self,fil,col):
        actual = self.cabeza
        anterior = None
        filAC=0
        
        while(actual.col<col):
            print(str(actual.value))
            actual = actual.derecha
        print("fila: " + str(actual.fil) + " columna: " + str(actual.col) + " valor: " + str(actual.value) )    
        while filAC<fil and actual!=None:
            anterior = actual
            print(str(actual.value))
            actual = actual.abajo
            if(actual!= None):
                filAC = actual.fil
        ##print(anterior.value)    
        return anterior

    def buscarDerecha(self,fil,col):
        actual = self.cabeza
        anterior = None
        
        while(actual.fil<fil):
            actual = actual.abajo
        while(actual.col<col):
            anterior = actual
            actual = actual.derecha
                
        return anterior
        
    def borrarFila(self,fil):
        anterior = None
        actual = self.cabeza
        
        while(actual.fil < fil):
            anterior = actual
            actual = actual.abajo
        anterior.abajo = actual.abajo
        
    def borrarColumna(self,col):
        actual = self.cabeza
        anterior = None
        
        while(actual.col<col):
            anterior = actual
            actual = actual.derecha
        anterior.derecha = actual.derecha
        
    def crearFila(self,fil):
        anterior = None
        actual = self.cabeza
        
        while(actual.fil < fil):
            anterior = actual
            actual = actual.abajo
        anterior.abajo = Nodo(fil, 0, 1000 , actual, Nodo(fil, self.maxColumna+1, 0, None,None))
            
    def crearColumna(self,col):
        anterior = None
        actual = self.cabeza
        
        while(actual.col<col):
            anterior = actual
            actual = actual.derecha
            
        anterior.derecha = Nodo(0 ,col ,1000 , Nodo(self.maxFila+1, col, 0, None, None), actual)
    
    def esVaciaFila(self,fil):
        filEmpty = True
        test = self.cabeza
        
        while(test.fil<fil):
            test =  test.abajo
            
        if(test.fil == fil):
            pass
        if(test.derecha.derecha != None ):
            filEmpty = False
        
        return filEmpty
    
    def esVaciaColumna(self,col):
        colEmpty = True
        test = self.cabeza
        
        while(test.col < col):
            test =  test.derecha
        if(test.col == col):
            
            if(test.abajo.abajo !=None ):
                colEmpty = False
            
        return colEmpty
    
    def printMatrix(self):
      
        for x in range(0,11):
            for y in range(0,11):
                print(self.obtenerValor(x,y))
              
            
        
 
    def generar_dot(self):
        cadena = open("grafo.dot","w")
        cadena.write("digraph g{\n")
        cadena.write("rankdir=LR\n")
        
        temp = self.cabeza
        
        if(temp == self.cabeza):
            cadena.write(str(temp) + "[label ="+"<Cab:"+str(temp.fil)+":"+str(temp.col)+">" +" shape =box, style=filled, fillcolor=red] \n")
            
            test = self.cabeza.derecha
            while(test!=None):
                cadena.write(str(test) + "[label ="+"<col:"+str(test.col)+">" +" shape =box, style=filled, fillcolor=red] \n")
                test =  test.derecha
             
            test = self.cabeza
            while(test.derecha!=None):
#                if(test.derecha==None):
#                    pass
#                else:
                cadena.write(str(test) +"->"+str(test.derecha))
                test =  test.derecha
            
            test = self.cabeza.abajo
            while(test!=None):
                cadena.write(str(test) + "[label = "+"<fil:"+str(test.fil)+">" +" shape =box, style=filled, fillcolor=blue] \n")
                test =  test.abajo
        
            test = self.cabeza
            while(test.abajo!=None):
                cadena.write(str(test) +"->"+str(test.abajo))
                test =  test.abajo
        
        
            cadena.write("subgraph{\n")
            cadena.write("rank = same;")
            test = self.cabeza.abajo
            cadena.write(str(self.cabeza)+";"+str(test.abajo))
            while(test.abajo!=None):

                cadena.write(str(test) +";"+str(test.abajo))
                test =  test.abajo
            cadena.write("}\n")

           
            aux = self.cabeza.abajo
            while(aux.abajo != None):
                cadena.write(str(aux)+"->"+str(aux.derecha)+"\n")
                aux2 = aux.derecha
                
                while(aux2.derecha!=None):
                    cadena.write(str(aux2) + "[label = "+"<Nodo:"+str(aux2.fil)+":"+str(aux2.col)+">" +" shape =box, style=filled, fillcolor=blue] \n")
                    aux2=aux2.derecha
                    
                aux=aux.abajo
          
          
            aux = self.cabeza.abajo
            while(aux.abajo != None):
                ##cadena.write(str(aux)+"->"+str(aux.derecha)+"\n")
                aux2 = aux.derecha
                
                while(aux2.derecha!=None):
                    
                    if(aux2.derecha.col==11):
                        print()
                    else:
                        cadena.write(str(aux2) +"->"+str(aux2.derecha)+"\n")
                    
                    aux2=aux2.derecha
                    
                aux=aux.abajo
           
  
           
            aux = self.cabeza.derecha
            while(aux.derecha != None):
                cadena.write(str(aux)+"->"+str(aux.abajo)+"\n")
                aux2 = aux.abajo
                
                while(aux2.abajo!=None):
                    
                    if(aux2.abajo.fil==11):
                        print()
                    else:
                        cadena.write(str(aux2) +"->"+str(aux2.abajo)+"\n")
                    
                    aux2=aux2.abajo
                    
                aux=aux.derecha
  
           
        cadena.write("}\n")
        cadena.close


    def generar_dot_nombre(self,nombre):
        cadena = open(nombre+"grafo.dot","w")
        cadena.write("digraph g{\n")
        cadena.write("rankdir=LR\n")
        
        temp = self.cabeza
        
        if(temp == self.cabeza):
            cadena.write(str(temp) + "[label ="+"<Cab:"+str(temp.fil)+":"+str(temp.col)+">" +" shape =box, style=filled, fillcolor=red] \n")
            
            test = self.cabeza.derecha
            while(test!=None):
                cadena.write(str(test) + "[label ="+"<col:"+str(test.col)+">" +" shape =box, style=filled, fillcolor=red] \n")
                test =  test.derecha
             
            test = self.cabeza
            while(test.derecha!=None):
#                if(test.derecha==None):
#                    pass
#                else:
                cadena.write(str(test) +"->"+str(test.derecha))
                test =  test.derecha
            
            test = self.cabeza.abajo
            while(test!=None):
                cadena.write(str(test) + "[label = "+"<fil:"+str(test.fil)+">" +" shape =box, style=filled, fillcolor=blue] \n")
                test =  test.abajo
        
            test = self.cabeza
            while(test.abajo!=None):
                cadena.write(str(test) +"->"+str(test.abajo))
                test =  test.abajo
        
        
            cadena.write("subgraph{\n")
            cadena.write("rank = same;")
            test = self.cabeza.abajo
            cadena.write(str(self.cabeza)+";"+str(test.abajo))
            while(test.abajo!=None):

                cadena.write(str(test) +";"+str(test.abajo))
                test =  test.abajo
            cadena.write("}\n")

           
            aux = self.cabeza.abajo
            while(aux.abajo != None):
                cadena.write(str(aux)+"->"+str(aux.derecha)+"\n")
                aux2 = aux.derecha
                
                while(aux2.derecha!=None):
                    cadena.write(str(aux2) + "[label = "+"<Nodo:"+str(aux2.fil)+":"+str(aux2.col)+">" +" shape =box, style=filled, fillcolor=blue] \n")
                    aux2=aux2.derecha
                    
                aux=aux.abajo
          
          
            aux = self.cabeza.abajo
            while(aux.abajo != None):
                ##cadena.write(str(aux)+"->"+str(aux.derecha)+"\n")
                aux2 = aux.derecha
                
                while(aux2.derecha!=None):
                    
                    if(aux2.derecha.col==11):
                        print()
                    else:
                        cadena.write(str(aux2) +"->"+str(aux2.derecha)+"\n")
                    
                    aux2=aux2.derecha
                    
                aux=aux.abajo
           
  
           
            aux = self.cabeza.derecha
            while(aux.derecha != None):
                cadena.write(str(aux)+"->"+str(aux.abajo)+"\n")
                aux2 = aux.abajo
                
                while(aux2.abajo!=None):
                    
                    if(aux2.abajo.fil==11):
                        print()
                    else:
                        cadena.write(str(aux2) +"->"+str(aux2.abajo)+"\n")
                    
                    aux2=aux2.abajo
                    
                aux=aux.derecha
  
           
        cadena.write("}\n")
        cadena.close

        
        
        
        
        
            
    def graficar(self):
      
        cadena = open("sparse.dot","w")
        cadena.write("digraph g{\n")
        cadena.write("rankdir=LR\n")
        
        
        
        
        test = self.cabeza
        while(test!=None):
            cadena.write(str(test) + "[label ="+"<col:"+str(test.col)+">" +" shape =box, style=filled, fillcolor=red] \n")
            test =  test.derecha
    
        test = self.cabeza
        while(test!=None):
            if(test.derecha==None):
                pass
            else:
                cadena.write(str(test) +"->"+str(test.derecha))
            test =  test.derecha
            

        test = self.cabeza
        while(test!=None):
            cadena.write(str(test) + "[label = "+"<fil:"+str(test.fil)+">" +" shape =box, style=filled, fillcolor=blue] \n")
            test =  test.abajo
        
        test = self.cabeza
        while(test.abajo!=None):
            cadena.write(str(test) +"->"+str(test.abajo))
            test =  test.abajo
        
        
        cadena.write("subgraph{\n")
        cadena.write("rank = same;")
        test = self.cabeza
        while(test!=None):
            if(test.abajo==None):
                pass
            else:
        
                cadena.write(str(test) +";"+str(test.abajo))
            test =  test.abajo
        cadena.write("}\n")
        
        
        auxfila = self.cabeza
        while(auxfila!=None):
            
            auxcol = auxfila
            
            ##cadena.write(str(auxcol) + "[label = "+"<nodo:"+str(auxcol.derecha) +">"+" shape =box, style=filled, fillcolor=blue] \n")
            while(auxcol!=None):
                cadena.write(str(auxcol) + "->" + str(auxcol.derecha)+"\n")
                if(auxcol.abajo != None):
                    cadena.write(str(auxcol)+"->" +str(auxcol.derecha)+"\n")
                auxcol = auxcol.derecha
            auxfila=auxfila.abajo
#        
#        
#        aux = self.cabeza.abajo
#        while(aux.abajo!=None):
#            aux2 = aux.derecha
#            while(aux2.abajo!=None):
#                if(aux2.value == 0 ):
#                    pass
#                else:
#                    cadena.write("nodo"+str(aux2.fil) + "[label = "+str(aux2.value) +" shape =box, style=filled, fillcolor=blue] \n")
#                aux2=aux2.derecha
#            aux = aux.abajo
        
#        aux = self.cabeza.abajo
#        while(aux.abajo!=None):
#            aux2 = aux.derecha
#            while(aux2.derecha!=None):
#                if(aux2.value == 0 ):
#                    pass
#                else:
#                    cadena.write(str(aux2.fil+aux2.col) +"->"+str(aux2.derecha.fil+aux2.derecha.col))
#                aux2=aux2.derecha
#            aux = aux.abajo
#        
            
        cadena.write("}\n")
        cadena.close

    def generar_dot_string(self,nombre):
        archivo = open(nombre+"grafo.dot","r")
        
        cadena = archivo.read()
        
        archivo.close()
        
       ## print(str(cadena))
        
        
        return str(cadena)
        
    
        
        
 
#sparse = MatrizDispersa(30,30)
#
#sparse.insertarValor(5,6,200)
#sparse.insertarValor(6,6,200)
#sparse.insertarValor(6,6,200)
#
#sparse.insertarValor(15,27,400)
#sparse.insertarValor(19,23,900)
#sparse.insertarValor(12,2,900)
#
#
#sparse.insertarValor(5,6,200)
#sparse.insertarValor(17,17,200)
#sparse.insertarValor(26,16,200)
#
#sparse.insertarValor(15,14,400)
#sparse.insertarValor(25,20,900)
#sparse.insertarValor(3,20,900)
#
#
##sparse.insertarValor(4,3,250)
##sparse.insertarValor(4,4,8)
####sparse.insertarValor(2,3,100)
##sparse.insertarValor(6,6,300)
##sparse.insertarValor(1,1,4)
#
###sparse.printMatrix()
#sparse.graficar()
#sparse.generar_dot()
#print(sparse.obtenerValor(3,3))