/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.web.controller;

import com.hms.domain.sub.*;
import com.hms.service.RegisteredDoctorService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hms.utils.ServiceUtils;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author cmc
 */
public class GetDetailsController extends HttpServlet {
   
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        System.out.println("In GetDetailsController");
        String docId = request.getParameter("docId");


        RegisteredDoctorService doctorService = ServiceUtils.getRegisteredDoctorService();

        RegisteredDoctor doctor = doctorService.get(docId);

        request.setAttribute("doctor", doctor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editDetails.jsp");
        dispatcher.forward(request, response);
        
    }

   
}
