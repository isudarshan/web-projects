/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.service.AppUserService;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Address;


/**
 *
 * @author cmc
 */


public class ForgotPasswordController extends HttpServlet {

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
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String securityQuestion = request.getParameter("securityQuestion");
        String answer = request.getParameter("answer");

        AppUserService appUserService = ServiceUtils.getAppUserService();

        AppUser appUser = appUserService.forgotPassword(securityQuestion, answer, username);

        if (appUser == null) {
            request.setAttribute("errorMsg", "Invalid Details, Please try again..");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/forgotPassword.jsp");
            dispatcher.forward(request, response);
            return;

        }
        String password = appUser.getPassword();
        request.setAttribute("password", password);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/forgotPassword.jsp");
        dispatcher.forward(request, response);


    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
