/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import back.backend;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jboss.logging.Logger;

/**
 *
 * @author lio
 */
public class adminAVL extends HttpServlet {

Logger log = Logger.getLogger(controler.class);
backend archivo = new backend();
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
String nombre_padre ;

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
        
        if(request.getParameter("Buscar")!=null){
        String nombre = request.getParameter("nombre");
        nombre_padre = nombre;
        String resultado = archivo.arbol_avl_conslta(nombre);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminAVL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminAVL at " + resultado + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
        }
        
        if(request.getParameter("eliminar")!=null){
       String nombre_contacto = request.getParameter("nombre_contacto");     
            
        archivo.arbol_avl_eliminar(nombre_padre, nombre_contacto);
            //llamada al metodo eliminar
        }
        
         if(request.getParameter("modificar")!=null){
        String nombre_contacto = request.getParameter("nombre_contacto");     
        String nuevo_nombre = request.getParameter("nuevo_nombre");
        String nuevo_password = request.getParameter("nueva_clave");
        
        archivo.arbol_avl_modificar(nombre_padre, nombre_contacto,nuevo_nombre,nuevo_password);
            //llamada al metodo eliminar
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
