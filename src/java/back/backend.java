/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jboss.logging.Logger;
import servlet.controler;

//import static servlet.controler.getString;
import static servlet.controler.webClient;

/**
 *
 * @author lio
 */
public class backend {
Logger log = Logger.getLogger(controler.class);
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
int contador_historial = 0;
    

    public backend() {
    }
    
    //#######################################################################################################
    
    public String Android(){
    
        String r = getString_Get("hola");
        
        return r;
    }
    
    //#######################################################################################################
    
    public String arbol_insert(String nombre, String clave, String conectado) throws IOException{
    
            RequestBody formBody = new FormEncodingBuilder()
                      
            .add("nombre",nombre)
            .add("clave",clave)
            .add("conectado",conectado)
            .build();
            String r = getString("arbolBB", formBody); 
           System.out.println(r + "---");
            
            return r;
    }
    
    public String imprimir_inordenABB(){
        
            String r = getString_Get("inordenABB"); 
            System.out.println(r + "---");
            
            return r;   
    }
    
    public boolean buscar_arbol(String nombre,String usuario_oponente,String tiros_realizados,String tiros_acertados,String tiros_fallados,String resultado,String dano){
        
        //usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano
        
        boolean existe = false;
                
        RequestBody formBody = new FormEncodingBuilder()
                      
            .add("nombre",nombre)
            .add("usuario_oponente",usuario_oponente)
            .add("tiros_realizados",tiros_realizados)
            .add("tiros_acertados",tiros_acertados)
            .add("tiros_fallados",tiros_fallados)
            .add("resultado",resultado)
            .add("dano",dano)
                
            .build();
        
           String r = getString("buscarArbol", formBody); 
           
           if(r.equals("existe")){
           existe = true;
           System.out.println(r + "---");
           }
                
           
            
            return existe;
        
    }
    
    ///#############METODO DE LOGEO########################
    
    public boolean buscar_usuario_arbol(String nombre,String clave){
        boolean existe = false;
        
        RequestBody formBody = new FormEncodingBuilder()          
            .add("nombre",nombre)
            .add("clave",clave)
            .build();
        
           String r = getString("buscar_logeo", formBody); 
           if(r.equals("true")){
                existe = true;
                log.info("existe");
           System.out.println(r + "---");
           }  
           
       return existe; 
    }
    
    
    
    public void crear_png_arbol() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/arbolCliente.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }
    
    
    public String graficar_dot() throws IOException{
    
    String r = getString_Get("arbolGraficar"); 
    
    File archivoArbol = new File("/Users/lio/NetBeansProjects/example1/web/arbolCliente.dot");
    FileWriter fw = new FileWriter(archivoArbol);
    
    fw.write(r);
    fw.close();
    
    
    crear_png_arbol();//llamada para generar imagen

            System.out.println(r + "---");
            log.info(r);   
            return r;
         
 
            
    }
    
    private void crear_png_sateliteJugador1() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/satelitejugador1.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_satelite() throws IOException{
    
    String r = getString_Get("graficar_satelite"); 
    
    File archivo_satelite_jugador1 = new File("/Users/lio/NetBeansProjects/example1/web/satelitejugador1.dot");
    FileWriter fw = new FileWriter(archivo_satelite_jugador1);
    
    fw.write(r);
    fw.close();
    crear_png_sateliteJugador1();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    //graficar_avion1
    
     private void crear_png_avionJugador1() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/avionjugador1.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_avionJ1() throws IOException{
    
    String r = getString_Get("graficar_avion1"); 
    
    File archivo_avion_jugador1 = new File("/Users/lio/NetBeansProjects/example1/web/avionjugador1.dot");
    FileWriter fw = new FileWriter(archivo_avion_jugador1);
    
    fw.write(r);
    fw.close();
    crear_png_avionJugador1();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    
    /////////////////BARCO J1#################
     private void crear_png_barcoJugador1() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/barcojugador1.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_barcoJ1() throws IOException{
    
    String r = getString_Get("graficar_barco1"); 
    
    File archivo_avion_jugador1 = new File("/Users/lio/NetBeansProjects/example1/web/barcojugador1.dot");
    FileWriter fw = new FileWriter(archivo_avion_jugador1);
    
    fw.write(r);
    fw.close();
    crear_png_barcoJugador1();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    //////////SUBMARINO 1########
    //graficar_submarino1
     private void crear_png_submarinoJugador1() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/submarinojugador1.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dotsubmarinoJ1() throws IOException{
    
    String r = getString_Get("graficar_submarino1"); 
    
    File archivo_avion_jugador1 = new File("/Users/lio/NetBeansProjects/example1/web/submarinojugador1.dot");
    FileWriter fw = new FileWriter(archivo_avion_jugador1);
    
    fw.write(r);
    fw.close();
    crear_png_submarinoJugador1();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    
    
    
    //------------------   SECCION DE GRAFOS JUGADOR 2#######################
    
        private void crear_png_sateliteJugador2() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/satelitejugador2.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_satelite2() throws IOException{
    
    String r = getString_Get("graficar_satelite2"); 
    
    File archivo_satelite_jugador2 = new File("/Users/lio/NetBeansProjects/example1/web/satelitejugador2.dot");
    FileWriter fw = new FileWriter(archivo_satelite_jugador2);
    
    fw.write(r);
    fw.close();
    crear_png_sateliteJugador2();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    //graficar_avion1
    
    
    
     private void crear_png_avionJugador2() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/avionjugador2.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_avionJ2() throws IOException{
    
    String r = getString_Get("graficar_avion2"); 
    
    File archivo_avion_jugador2 = new File("/Users/lio/NetBeansProjects/example1/web/avionjugador2.dot");
    FileWriter fw = new FileWriter(archivo_avion_jugador2);
    
    fw.write(r);
    fw.close();
    crear_png_avionJugador2();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    
    /////////////////BARCO J1#################
     private void crear_png_barcoJugador2() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/barcojugador2.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dot_barcoJ2() throws IOException{
    
    String r = getString_Get("graficar_barco2"); 
    
    File archivo_barco_jugador2 = new File("/Users/lio/NetBeansProjects/example1/web/barcojugador2.dot");
    FileWriter fw = new FileWriter(archivo_barco_jugador2);
    
    fw.write(r);
    fw.close();
    crear_png_barcoJugador2();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    //////////SUBMARINO 1########
    //graficar_submarino1
     private void crear_png_submarinoJugador2() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/submarinojugador2.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }    
    
    public String graficar_dotsubmarinoJ2() throws IOException{
    
    String r = getString_Get("graficar_submarino2"); 
    
    File archivo_submarino_jugador2 = new File("/Users/lio/NetBeansProjects/example1/web/submarinojugador2.dot");
    FileWriter fw = new FileWriter(archivo_submarino_jugador2);
    
    fw.write(r);
    fw.close();
    crear_png_submarinoJugador2();
    
            System.out.println(r + "---");
            log.info(r);
            return r;
    }
    
    
    
    //###################FINALIZA SECCION DE GRAFOS JUGADOR 1######
    
    
    public String insertar_juego_actual(String jugador1,String jugador2,String tamanoX,String tamanoY,String variante,String tiempo,String disparo,String numero_rafagas){
    
           String existe = "";
                
        RequestBody formBody = new FormEncodingBuilder()
                      
            .add("jugador1",jugador1)
            .add("jugador2",jugador2)
            .add("tamanoX",tamanoX)
            .add("tamanoY",tamanoY)
            .add("variante",variante)
            .add("tiempo",tiempo)
            .add("disparo",disparo)
            .add("numero_rafagas",numero_rafagas)
                
            .build();
        
           String r = getString("juegoActual", formBody); 
           
           log.info(r); 
            return r;
        
        
    }
    
    
    
    public String insertar_naves(String jugador,String columna,String fila,String nivel,String mode,String direccion){
    
             RequestBody formBody = new FormEncodingBuilder()                  
            .add("jugador",jugador)
            .add("columna",columna)
            .add("fila",fila)
            .add("nivel",nivel)
            .add("mode",mode)
            .add("direccion",direccion)
            .build();
        
           String r = getString("llenarNaves", formBody); 
           
           log.info(r); 
            return r;
    
    }
    
    
    public String lectura_usuariocsv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            lectura = buferlector.readLine();
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                String [] campos = lectura.split(",");
                //nombre,contrasena,conectado
                String nombre = campos[0].trim();
                String clave = campos[1].trim();
                String conectado = campos[2].trim();
                       
                System.out.println(nombre + ";" + clave + ";" + conectado);
                arbol_insert(nombre, clave, conectado);
                
            }
      
            log.info("subido");
            uploaded.write(fichero);
            
            graficar_dot();
            
            } else {
      
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
    }
            
            
      return r;
    }
    
    public String lectura_juego_actualcsv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            lectura = buferlector.readLine();

            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                String [] campos = lectura.split(",");
                //System.out.println(campos[0] + ";" + campos[1] + ";" + campos[2]);
                //jugador1,jugador2,tamanoX,tamanoY,variante,tiempo,disparo,numero_rafagas
                //arbol_insert(campos[0], campos[1], campos[2]);
                String stringcampos=campos[0].trim();
                String stringcamposdos = campos[1].trim();
                log.info(stringcampos +";"+stringcamposdos +";"+ campos[2]+";"+ campos[3]+";"+ campos[4]+";"+ campos[5]+";"+ campos[6]+";"+ campos[7]);
                
                insertar_juego_actual(stringcampos, stringcamposdos, campos[2], campos[3], campos[4], campos[5], campos[6], campos[7]);
               // log.info(campos[0] +";"+campos[1] +";"+ campos[2]+";"+ campos[3]+";"+ campos[4]+";"+ campos[5]+";"+ campos[6]+";"+ campos[7]);
                
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
      
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
    }
            
            
      return r;
    }
    
    public String lectura_navescsv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            
            lectura = buferlector.readLine();

            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                String [] campos = lectura.split(",");
                //System.out.println(campos[0] + ";" + campos[1] + ";" + campos[2]);
//               jugador1 columna	fila	nivel (1 satelite, 2 avion, 3 barco, 4 submarino)	modo	direccion (1 = horizontal, 2 vertical) (cuando aplique)
//                Mord86	4	26	1	1	
//                Mord86	5	3	2	1	
//                Mord86	9	9	2	2	
//                Mord86	10	26	3	1	1

                String jugador =campos[0].trim();
                String columna =campos[1].trim();
                String fila =campos[2].trim();
                String nivel =campos[3].trim();
                String modo =campos[4].trim();
                
                
                //el if es para manejar tamanos distintos de cadenas, de 5 y de 6 componentes
                if(campos.length == 5){
                    log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4]);
                    
                    insertar_naves(jugador, columna, fila, nivel, modo, "no tiene");
                }
                else{
                    
                    String direccion =campos[5].trim();
                    
                    log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4]+ ";" + direccion);

                    insertar_naves(jugador, columna, fila, nivel, modo, direccion);
                }
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
      
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
    }
            
            
      return r;
    }
    
    
    public String lectura_juegoscsv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            
                lectura = buferlector.readLine();
            //log.info(cadena);
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                
                String [] campos = lectura.split(",");
                //UsuarioBase	Oponente	Tirosrealizados	Tirosacertados	Tirosfallados	Gano (1 si, 0 no)	Dañorecibido=tirosrecibidos
                //Mord86	Stin94	51	26	25	0	10
                
                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4] + ";" + campos[5]+ ";" + campos[6]);
                String UsuarioBase = campos[0].trim();
                String Oponente = campos[1].trim();
                String Tirosrealizados = campos[2].trim();
                String Tirosacertados = campos[3].trim();
                String Tirosfallados = campos[4].trim();
                String gano = campos[5].trim();
                String Danorecibido = campos[6].trim();
                
                //aqui se inserta en la lista, de cada nodo de arbol Jugador
                //primero obtener el nodo, obtener la lista, llenar la lista
                //arbol_insert(campos[0], campos[1], campos[2]);
                //log.info(campos[0] + ";" + campos[1] + ";" + campos[2]);
                //usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano

                buscar_arbol(UsuarioBase,Oponente,Tirosrealizados,Tirosacertados,Tirosfallados,gano,Danorecibido);
                     
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
      
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
    }
              
      return r;
    }
    
//################################# SEGUNDA FASE########################################################
     public String arbol_avl_insertar(String nombre_padre, String nick, String password) throws IOException{
    
            RequestBody formBody = new FormEncodingBuilder()
                      
            .add("nodo_padre",nombre_padre)
            .add("nick", nick)
            .add("password",password)
            .build();
            String r = getString("insertar_contactos_AVL", formBody); 
           System.out.println(r + "---");
            
            return r;
    }
    
     public String arbol_B_insertar(String CoordenadaX,String CoordenadaY,String Tipo_tiro,String Resultado,String Tipo_de_nave_golpeada,String Emisor,String receptor,String Fecha,String tiempo_restante,String numero_tiro) throws IOException{
    
            RequestBody formBody = new FormEncodingBuilder()
                      
            .add("CoordenadaX",CoordenadaX)
            .add("CoordenadaY", CoordenadaY)
            .add("Tipo_tiro",Tipo_tiro)
            .add("Resultado",Resultado)
            .add("Tipo_de_nave_golpeada", Tipo_de_nave_golpeada)
            .add("Emisor",Emisor)
            .add("receptor",receptor)
            .add("Fecha", Fecha)
            .add("tiempo_restante",tiempo_restante)
            .add("numero_tiro",numero_tiro)
            .build();
            
            String r = getString("insertar_historial_B", formBody); 
            System.out.println(r + "---");
            
            
            return r;
    }
     
     
    public String arbol_avl_conslta(String nombre){
    
          RequestBody formBody = new FormEncodingBuilder()
                      
            .add("nombre",nombre)
            
            .build();
            String result = getString("AVL_desplegar", formBody); 
           System.out.println(result + "---");
            
        return result;
    }
     
      public String arbol_avl_eliminar(String nombre_padre,String nombre_contacto){
    
          RequestBody formBody = new FormEncodingBuilder()
            .add("nombre_padre",nombre_padre)
            .add("nombre_contacto",nombre_contacto)
            
            .build();
            String result = getString("AVL_eliminar", formBody); 
           System.out.println(result + "---");
            
        return result;
    }
  
    public String arbol_avl_modificar(String nombre_padre,String nombre_contacto,String nuevo_nombre,String nuevo_password ){
    
//         nombre_padre = str(request.form['nombre_padre'])##informacion dericiba desde Java
//    nombre_contacto = str(request.form['nombre_contacto'])
//    nuevo_nombre = str(request.form['nuevo_nombre'])
//    nuevo_password = str(request.form['nuevo_password'])
//        
          RequestBody formBody = new FormEncodingBuilder()
            .add("nombre_padre",nombre_padre)
            .add("nombre_contacto",nombre_contacto)
            .add("nuevo_nombre",nuevo_nombre)
            .add("nuevo_password",nuevo_password)
            
                  
            .build();
            String result = getString("AVL_modificar", formBody); 
           System.out.println(result + "---");
            
        return result;
    }
            
    public String lectura_cotactos_csv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            
                lectura = buferlector.readLine();
            //log.info(cadena);
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                
                String [] campos = lectura.split(",");
//                Usuario "padre"	Nickname	Contrasenaa
//                Mord86	Stone Griffin	WAG95DOM2LZ

                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]);
                String usuario_padre = campos[0].trim();
                String nickname = campos[1].trim();
                String password = campos[2].trim();
               
                arbol_avl_insertar(usuario_padre,nickname,password);
                     
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
      
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
    }
              
      return r;
    }
    
//#######################################################################################################    

//#########################################################################################################
//##################################### Lectura del historial de juegos###################################
  public String incrementar_juego(){
    
        String r = getString_Get("generar_juego");
        log.info("Resultado en Incrementar Juego:"+r);
        return r;
        
    }    
    
  public String graficar_historial(){
  
  String r = getString_Get("graficar_historial");
        log.info("Graficando"+r);
        return r;
  }
    
 public String lectura_historial_csv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";       
    contador_historial +=1;
    incrementar_juego();
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            
                lectura = buferlector.readLine();
            //log.info(cadena);
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                
                String [] campos = lectura.split(",");
////Coordenada X Coordenada Y Tipo tiro (1 = de uno en uno, 2 = ráfaga)	Resultado (fallo = 1, golpe = 2, eliminacion de objetivo = 3)	Tipo de nave golpeada (1 satelite, 2 avion, 3 barco, 4 submarino)	Emisor	Receptor	Fecha	Tiempo Restante	Número de Tiro
////AC	12	1	1	1	Mord86	Stin94	8/1/15		1
////W	26	1	3	3	Stin94	Mord96	8/1/15		2
////B	30	1	1	4	Mord86	Stin94	8/1/15		3
////E	12	11	3	2	Stin94	Mord96	8/1/15		4
////Z	6	1	3	2	Mord86	Stin94	8/1/15		5
////AB	7	1	2	3	Stin94	Mord96	8/1/15		6
////J	10	1	1	3	Mord86	Stin94	8/1/15		7
////T	8	1	2	3	Stin94	Mord96	8/1/15		8
////F	6	1	3	1	Mord86	Stin94	8/1/15		9
////AC	3	1	3	4	Stin94	Mord96	8/1/15		10  
////
                

                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+";"+campos[3] + ";" + campos[4] + ";" + campos[5]+";"+campos[6] + ";" + campos[7] + ";" + campos[8]+";"+campos[9]);
                String CoordenadaX = campos[0].trim();
                String CoordenadaY = campos[1].trim();
                String Tipo_tiro = campos[2].trim();
                String Resultado = campos[3].trim();
                String Tipo_de_nave_golpeada = campos[4].trim();
                String Emisor = campos[5].trim();
                String receptor = campos[6].trim();
                String Fecha = campos[7].trim();
                String tiempo_restante = campos[8].trim();
                String numero_tiro = campos[9].trim(); 
                
                arbol_B_insertar(CoordenadaX,CoordenadaY,Tipo_tiro,Resultado,Tipo_de_nave_golpeada,Emisor,receptor,Fecha,tiempo_restante,numero_tiro);
                //arbol_avl_insertar(usuario_padre,nickname,password);       
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
            
            
    }
       //graficar_historial();       
      return r;
    }
    
//######################################################################################################## 
 
//###########################################GENERAR HASH################################################    

  public void crear_png_Hash() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/hash.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }
   public String insertar_hash() throws IOException{
  
    String r = getString_Get("insertar_tabla_hash");
        File archivohash = new File("/Users/lio/NetBeansProjects/example1/web/hash.dot");
    FileWriter fw = new FileWriter(archivohash);
    
    fw.write(r);
    fw.close();
    
    
        crear_png_Hash();//llamada para generar imagen

            System.out.println(r + "---");
            log.info(r);   
            return r;
  }
 
 //########################################################################################################    

 //################################Obtener String y Graficar Arbol B#######################################
 ////######################################################################################################
   
    public void crear_png_Arbol_B() throws IOException{
      String so = System.getProperty("os.name");
      String comando = ("/usr/local/bin/dot -Tpng -O /Users/lio/NetBeansProjects/example1/web/arbolBCliente.dot");
      Process p = Runtime.getRuntime().exec(comando);
            log.info(so);     
    }
    
    
    public String graficar_dot_Arbol_B() throws IOException{
    
    String r = getString_Get("arbolBGraficar"); 
    
    File archivoArbolB = new File("/Users/lio/NetBeansProjects/example1/web/arbolBCliente.dot");
    FileWriter fw = new FileWriter(archivoArbolB);
    
    fw.write(r);
    fw.close();
    
    
        crear_png_Arbol_B();//llamada para generar imagen

            System.out.println(r + "---");
            log.info(r);   
            return r;
         
 
            
    }
  
 //################################Obtener String y Graficar Arbol B#######################################
 ////######################################################################################################
   
   
 //########################################## archivo tiros###############################################
    //##########################################################################################
    
    
 public String lectura_tiros_csv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";     
    
    List items = upload.parseRequest(request);
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   
            if (!uploaded.isFormField()) {
      
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            uploaded.write(fichero);

            FileReader lector = new FileReader(fichero);
            BufferedReader buferlector = new BufferedReader(lector);
            
                lectura = buferlector.readLine();
            //log.info(cadena);
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                
                String [] campos = lectura.split(",");

////                            jugador1	columna	fila
////            Mord86	D	26
////            Mord86	E	3
////            Mord86	I	9
////            Mord86	J	26
////            Mord86	M	17
////            Mord86	P	29
////            Mord86	Q	21
////             Stin94	J	17
////             Stin94	L	7
////             Stin94	N	21
////             Stin94	K	19
////             Stin94	I	19
////             Stin94	S	3
////             Stin94	H	16
////             Stin94	H	20
                
                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]);
                String jugador = campos[0].trim();
                String colmna = campos[1].trim();
                String fila = campos[2].trim();
                
                //arbol_B_insertar(CoordenadaX,CoordenadaY,Tipo_tiro);
                //arbol_avl_insertar(usuario_padre,nickname,password);       
            }
      
            log.info("subido");
            uploaded.write(fichero);
            } else {
            String key = uploaded.getFieldName();
            String valor = uploaded.getString();
            log.info("campos"+key + valor);
        }
            
            
    }
       //graficar_historial();       
      return r;
    }
    
    
    //#############################################################################################
    //############################################################################################
 
 
 
 
    public static String getString(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://127.0.0.1:8080/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String response_string = response.body().string();//y este seria el string de las respuesta
            return response_string;
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(servlet.controler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(servlet.controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
  public static String getString_Get(String metodo) {

        try {
            URL url = new URL("http://127.0.0.1:8080/" + metodo);
            Request  req = new Request.Builder().url(url).get().build();
            Response resp = webClient.newCall(req).execute();
            String resp_string = resp.body().string();
           
            return resp_string;
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(servlet.controler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(servlet.controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
}

