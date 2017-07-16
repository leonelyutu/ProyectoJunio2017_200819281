#
#__author__ = "lio"
#__date__ = "$Jun 18, 2017 10:22:57 PM$"
#
#if __name__ == "__main__":
#    print "Hello World"

import os
import lista_juego

class node():
    def __init__(self, dato,contrasena,conectado):
        self.left = None
        self.right = None
        self.dato = dato##name
        self.contrasena = contrasena
        self.conectado = conectado
        self.lista_juego = lista_juego.lista_juego()## Falta Inicializar la Lista
        

class arbol():
    def __init__(self):
        self.root = None
        self.lista = list()
        
    def insert(self, a, dato,contrasena,conectado):
        if(self.existe(a,dato)):
            print('no se inserto',dato)
            return a
        else:
       
            if a == None:
                a = node(dato,contrasena,conectado)

            else:
                d = a.dato
                if dato < d:
                    a.left = self.insert(a.left, dato,contrasena,conectado)
                else:
                    a.right = self.insert(a.right, dato,contrasena,conectado)
            return a

    def existe(self,a,dato):
        if a == None:
            return False
        else:
            if dato == a.dato:
                return True
            else:
                if dato <= a.dato:
                    return self.existe(a.left,dato )
                else:
                    return self.existe(a.right,dato )
              

    def inorder(self, a):    
        if a == None:
            return None
        else:
            self.inorder(a.left)
            self.lista.append(a.dato)
            ##print(a.dato,a.contrasena,a.conectado)
            self.inorder(a.right)
            
        

    def preorder(self, a):
        if a == None:
            return None
        else:
            print(a.dato)
            self.preorder(a.left)
            self.preorder(a.right)

    def postorder(self, a):
        if a == None:
            return None
        else:
            self.postorder(a.left)
            self.postorder(a.right)
            print(a.dato)

    def buscar(self, dato, a):
        if a == None:
            return None
        else:
            if dato == a.dato:
                return a
            else:
                if dato < a.dato:
                    return self.buscar(dato, a.left)
                else:
                    return self.buscar(dato, a.right)

    
                
    def buscarconclave(self, dato, a,clave):
        if a == None:
            return None
        else:
            if dato == a.dato and clave == a.contrasena:
                return a
            else:
                if dato < a.dato:
                    return self.buscarconclave(dato, a.left, clave)
                else:
                    return self.buscarconclave(dato, a.right,clave)
                
    def recorrer_lista(self):
        
        pre = "{"+"Usuarios: " "["
         
        for i in self.lista:
            pre += "{"+"Name :"+str(i)+"}"+","
                       ##print(i)
        pre+="]" +"}"
        
        self.lista = list()
        
        return pre


    def graficando(self,root,archivo):
        
        aux = root
        if(aux!=None):
        #if(aux.left == None and aux.right == None):
            cadena =str(aux.dato)+"[label = "+ "\""+str(aux.dato) + "\"" + "]\n"
            archivo.write(str(aux.dato)+"[label = "+ "\""+str(aux.dato) + "\"" + "]\n")
            print(cadena)
            
            if(aux.left != None):
                archivo.write(str(aux.dato) +"->" + str(aux.left.dato)+"\n")

            if(aux.right != None):
                archivo.write(str(aux.dato) + "->" + str(aux.right.dato)+"\n")

            self.graficando(aux.left,archivo)
            self.graficando(aux.right,archivo)

        
    
    def graficar(self,root):
        aux = root
        
        cadena = open("arbol.dot","w")
        cadena.write("digraph g{\n")
        ##cadena.write("rankdir=LR\n")
        
        if(aux == None):
            print()
        else:
            self.graficando(aux,cadena)
        
        
        cadena.write("}\n")
        cadena.close
                
        
        return cadena
    
    def generar_dot(self):
        archivo = open("arbol.dot","r")
        
        cadena = archivo.read()
        
        archivo.close()
        
        print(str(cadena))
        return str(cadena)
    
    

