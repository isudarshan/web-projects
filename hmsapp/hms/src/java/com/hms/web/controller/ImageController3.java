/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.web.controller;

import com.hms.domain.sub.Pharmacist;
import com.hms.service.PharmacistService;
import com.hms.service.impl.PharmacistServiceImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmc
 */
public class ImageController3 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      

        response.setContentType("image/jpeg");

        String pharmacistName = request.getParameter("pharmacistName").trim();

        PharmacistService pharmacistService = new PharmacistServiceImpl();
        Pharmacist pharmacist = pharmacistService.getByName(pharmacistName);



        byte[] imageBytes = pharmacist.getPhotograph();
        response.setContentLength(imageBytes.length);
        System.out.println(imageBytes.length);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);


        outputStream.flush();
        outputStream.close();
    } 

   

}
