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
    
    

    public backend() {
    }
    
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
            
            
            while ((lectura = buferlector.readLine()) != null){
                //System.out.println(lectura);
                String [] campos = lectura.split(",");
                System.out.println(campos[0] + ";" + campos[1] + ";" + campos[2]);
                arbol_insert(campos[0], campos[1], campos[2]);
                
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
                String stringcampos=campos[0].trim();

                if(campos.length == 5){
                    
               log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4]);
                    insertar_naves(stringcampos, campos[1], campos[2], campos[3], campos[4], "no tiene");
                }
                else{
                //
                insertar_naves(stringcampos, campos[1], campos[2], campos[3], campos[4], campos[5]);
                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4]+ ";" + campos[5]);
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
                
                log.info(campos[0] + ";" + campos[1] + ";" + campos[2]+ ";"+ campos[3] + ";" + campos[4] + ";" + campos[5]+ ";" + campos[6]);
                
                //aqui se inserta en la lista, de cada nodo de arbol Jugador
                //primero obtener el nodo, obtener la lista, llenar la lista
                //arbol_insert(campos[0], campos[1], campos[2]);
                //log.info(campos[0] + ";" + campos[1] + ";" + campos[2]);
                //usuario_oponente,tiros_realizados,tiros_acertados,tiros_fallados,resultado,dano

                buscar_arbol(campos[0],campos[1],campos[2],campos[3],campos[4],campos[5],campos[6]);
                
                        
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

