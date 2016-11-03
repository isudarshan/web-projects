/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.RegisteredDoctor;
import com.hms.service.RegisteredDoctorService;
import com.hms.utils.ServiceUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmc
 */
public class ImageController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("image/jpeg");
        
        String firstName = request.getParameter("firstName").trim();
        
        RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
        RegisteredDoctor doctor = registeredDoctorService.getDoctorByName(firstName);
        System.out.println(firstName);
        
        
        byte[] imageBytes = doctor.getPhotoGraph();
        response.setContentLength(imageBytes.length);
        System.out.println(imageBytes.length);
        
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);
       
       
        outputStream.flush();
        outputStream.close();
    }
}
