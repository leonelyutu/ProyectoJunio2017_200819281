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
    
    public String arbol_insert(String nombre, String clave, String conectado){
    
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
    
    public String lectura_usuariocsv(HttpServletRequest request) throws IOException, FileUploadException, Exception{
    String r = "";
    
      
            //Se recorren todos los items, que son de tipo FileItem
    List items = upload.parseRequest(request);
      
            //Se recorren todos los items, que son de tipo FileItem
        for (Object item : items) {
            FileItem uploaded = (FileItem) item;
            log.info(item);
   // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
   // subido donde nos interese
            if (!uploaded.isFormField()) {
      // No es campo de formulario, guardamos el fichero en algún sitio
            File fichero = new File("/tmp", uploaded.getName());
            String lectura = "";
            
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
            } else {
      // es un campo de formulario, podemos obtener clave y valor
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

