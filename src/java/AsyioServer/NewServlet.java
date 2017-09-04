/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsyioServer;

import com.google.gson.Gson;
import java.io.*;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import service.HttpRequests;
import service.Req;

/**
 *
 * @author Miss M
 */

public class NewServlet extends HttpServlet {
        HttpRequests hr=new HttpRequests();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("application/json");  
             
            Gson gson = new Gson();
 
             try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);}
      
            Req r = (Req) gson.fromJson(sb.toString(), Req.class);            
            Class[] cArg = new Class[r.getParams().length];
            for(int i=0; i<r.getParams().length; cArg[i++]=String.class); 
            Method temp=hr.getClass().getMethod(r.getExecute(), cArg);
	    Object o=(Object) temp.invoke(hr, r.getParams());
            String json = gson.toJson(o);
            out.print(json);
            out.flush();
            
        } catch (Exception e) {}
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
