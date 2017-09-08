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
@SuppressWarnings("serial")
public class NewServlet extends HttpServlet {

    HttpRequests hr = new HttpRequests();
    public static String ip;
    public static HttpServletRequest req;
    public static HttpSession session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("application/json");
            
            
            try (PrintWriter out = response.getWriter()) {            
            ip = request.getRemoteAddr();
            req=request;
            Gson gson = new Gson();
            StringBuilder sb = new StringBuilder();
            String s;

            try {

                while ((s = request.getReader().readLine()) != null) {
                    sb.append(s);
                }

                Req r = gson.fromJson(sb.toString(), Req.class);
                Class<?>[] cArg = new Class<?>[r.getParams().length];
                for (int i = 0; i < r.getParams().length; cArg[i++] = String.class);
                Method temp = hr.getClass().getMethod(r.getExecute(), cArg);
                Object o = temp.invoke(hr, r.getParams());
                String json = gson.toJson(o);
                out.print(json);
                //out.print((request.getSession(false).getAttribute("sessionClient")).getClass().toString());
                out.flush();

            } catch (Exception e) {
            }
         out.close();
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
    }

}
