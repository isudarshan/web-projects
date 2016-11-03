/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.Doctor_Patient;
import com.hms.domain.sub.RegisteredDoctor;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.Doctor_PatientService;
import com.hms.service.RegisterPatientService;
import com.hms.service.RegisteredDoctorService;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author cmc
 */
public class AssignDoctor extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        
        RegisterPatientService registerPatientService = ServiceUtils.getRegisteredPatientService();
        RegisteredPatient patient = registerPatientService.getPatient(id);
        
        String specialization = patient.getRequestedConsultant();
        RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
        List<RegisteredDoctor> doctors = registeredDoctorService.getDoctorsBySpecialization(specialization);
        
       
        HttpSession session = request.getSession();
        session.setAttribute("patient", patient);
        
        for (RegisteredDoctor doc : doctors) {
            System.out.println(doc);
        }
        session.setAttribute("doctors", doctors);
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/assignDoctor.jsp");
        dispatcher1.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String doctorName = request.getParameter("doctorName");
        String patientName = request.getParameter("patientName");
        String requestedConsultant = request.getParameter("requestedConsultant");
       
        if (("submit").equalsIgnoreCase(action)) {
           
            RegisterPatientService registerPatientService = ServiceUtils.getRegisteredPatientService();
            RegisteredPatient patient = registerPatientService.getPatientByName(patientName);
            
            RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
            RegisteredDoctor registeredDoctor = registeredDoctorService.getDoctorByName(doctorName);
            
            Doctor_Patient doctor_Patient = new Doctor_Patient();
            doctor_Patient.setDoctorId(registeredDoctor.getDoctorId());
            doctor_Patient.setDoctorName(registeredDoctor.getFirstName());
            doctor_Patient.setRequiredConsultation(registeredDoctor.getSpecialization());
            doctor_Patient.setPatientId(String.valueOf(patient.getId()));
            doctor_Patient.setPatientName(patientName);
            doctor_Patient.setObservation(patient.getObservation());
            doctor_Patient.setMedicalHistory(patient.getMedicalHistory());
            Doctor_PatientService doctor_PatientService = ServiceUtils.getDoctor_PatientService();
            doctor_PatientService.create(doctor_Patient);
            
            request.setAttribute("message", "Patient is set to the doctor");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/assignDoctor.jsp");
            dispatcher.forward(request, response);
            
            
        }
        
        
    }
}
