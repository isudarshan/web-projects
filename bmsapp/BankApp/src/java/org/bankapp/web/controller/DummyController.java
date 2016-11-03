/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.DummyService;
import org.bankapp.domain.Dummy;
import org.bankapp.utils.BankServiceUtils;

/**
 *
 * @author Sudarsan
 */
public class DummyController extends HttpServlet {


    private static final Logger LOG = Logger.getLogger(DummyController.class);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            DummyService dummyService = BankServiceUtils.getDummyService();

            
            // Create
//            try {
//                
//                
//                
//                
//                InputStream inputStream = this.getServletContext().getResourceAsStream("images/error.jpg");
//                byte[] imageBytes = new byte[inputStream.available()];
//                inputStream.read(imageBytes);
//
//                Dummy dummy = new Dummy();
//                dummy.setName("BBB");
//                dummy.setPic(imageBytes);
//
//                dummyService.create(dummy);
//            } catch (FileNotFoundException ex) {
//                LOG.warn("", ex);
//            } catch (IOException ex) {
//                LOG.warn("", ex);
//            }
            
            
            // Get All
            //out.print(dummyService.getAll());
            
            
            //Delete
//            Dummy dummy = new Dummy();
//            dummy.setId(15L);
//            dummyService.delete(dummy);
//          
            
            
            
            
            //Find
            
            
            out.println(dummyService.getDummy(3L));
        } finally {
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
    }// </editor-fold>

}
