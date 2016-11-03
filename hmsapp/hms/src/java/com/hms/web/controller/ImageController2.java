/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.RegisteredDoctor;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.RegisterPatientService;
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
public class ImageController2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in image Controller2====");
        response.setContentType("image/jpeg");

        String firstName = request.getParameter("firstName").trim();

       RegisterPatientService patientService = ServiceUtils.getRegisteredPatientService();
        RegisteredPatient patient = patientService.getPatientByName(firstName);
       System.out.println(firstName);

        byte[] imageBytes = patient.getPhotograph();
        response.setContentLength(imageBytes.length);
        System.out.println(imageBytes.length);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);


        outputStream.flush();
        outputStream.close();
    }
}
