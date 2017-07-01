/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import back.backend;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.DataInputStream;
import static java.lang.Math.log;
import static java.lang.System.out;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import org.jboss.logging.Logger;


/**
 *
 * @author lio
 */
public class controler extends HttpServlet {
    public static OkHttpClient webClient = new OkHttpClient();
Logger log = Logger.getLogger(controler.class);
backend usuarios = new backend();



    /**
     *
     */
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        if(request.getParameter("login") != null ){
                
            String nombre = request.getParameter("nombre");
            String clave = request.getParameter("clave");
            
                if(nombre.equals("admin") && clave.equals("admin")){
                 request.setAttribute("admin", "admin");
                 request.getRequestDispatcher("cargarArchivos.jsp").forward(request, response);
               
                 
                }else{
                    //boolean existe = false;
                    //usuarios.buscar(nombre,clave)
                    boolean existe = usuarios.buscar_usuario_arbol(nombre, clave);
                    log.info("desde controler"+existe);
                    
                    if(existe == true){
                        
                        request.setAttribute("Bienvenido", "admin");
                        request.getRequestDispatcher("bienvenidoJugador.jsp").forward(request, response);
               
                 
                    }else{
                       request.getRequestDispatcher("index.jsp").forward(request, response);

                    }
                    
                    /////###################cosulta de logeo //////#############
                }
            }else if(request.getParameter("register") != null){
                request.getRequestDispatcher("register.jsp").forward(request, response);
                
                }else if(request.getParameter("nuevoUsuario")!=null){
                    String nombre=request.getParameter("nombre");
                    String clave=request.getParameter("clave");
           
                    if(!nombre.equalsIgnoreCase("") && !clave.equalsIgnoreCase("")){
                
                        boolean sw= true;
                        
                        usuarios.arbol_insert(nombre, clave,"0");
                        usuarios.graficar_dot();
                        String result = usuarios.imprimir_inordenABB();
                        log.info("recibido en llamada a imprimir"+result);
                        request.setAttribute("resultado", result);
                        request.getRequestDispatcher("bienvenidoNuevoUsuario.jsp").forward(request, response);
                       
                        
                    if(sw){
        
            
                    }else{
                                PrintWriter out=response.getWriter();
                                out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
                            }
                    }
                }else if(request.getParameter("regresar")!=null){
                    
                    request.getRequestDispatcher("cargarArchivos.jsp").forward(request, response);

                }else if(request.getParameter("bienvenidoNuevoUsuario")!=null){
                request.setAttribute("resultado", "bienvenido");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                       
                }else if(request.getParameter("salir")!=null){
                request.setAttribute("resultado", "bienvenido");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
            
                }else if(request.getParameter("")!=null){
                request.setAttribute("resultado", "bienvenido");
                        request.getRequestDispatcher("verReportes.jsp").forward(request, response);
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

    

}
