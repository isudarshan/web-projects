/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.Prescription;
import com.hms.service.PrescriptionService;
import com.hms.service.impl.PrescriptionServiceImpl;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.RequestDirector;

/**
 *
 * @author cmc
 */
public class PharmacyController extends HttpServlet {

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
       
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String patientName =request.getParameter("patientName");
         System.out.println(patientName);
        PrescriptionService prescriptionService = ServiceUtils.getPrescriptionService();
        List<Prescription> presciptions = prescriptionService.getPrescriptionByPatientName(patientName);
        System.out.println("listLength"+presciptions.size());
        if(presciptions.size()!= 0){
        HttpSession session = request.getSession();
        session.setAttribute("presciptions", presciptions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pharmacyAdmin.jsp");
        dispatcher.forward(request, response);
        }else{
           request.setAttribute("patientMsg", "The patient does not exists with the given name!!");
           RequestDispatcher dispatcher = request.getRequestDispatcher("/pharmacyAdminHome.jsp");
           dispatcher.forward(request, response);
        }
       
    }
}
