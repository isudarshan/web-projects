/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.RegisteredDoctor;
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
public class EditDoctorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String doctorId = request.getParameter("doctorId");
        String mobileNumber = request.getParameter("mobileNumber");
        String email = request.getParameter("email");
        String experience = request.getParameter("experience");

        RegisteredDoctorService doctorService = ServiceUtils.getRegisteredDoctorService();

        RegisteredDoctor doctor = doctorService.get(doctorId);

        doctor.setDoctorId(doctorId);
        doctor.setMobileNumber(mobileNumber);
        doctor.setEmail(email);
        doctor.setExperience(experience);

        doctorService.create(doctor);

        request.setAttribute("success1", "Details Edited Successfully..");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
        dispatcher.forward(request, response);

    }
}
