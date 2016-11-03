/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.service.AppUserService;
import com.hms.service.impl.AppUserServiceImpl;
import com.hms.service.impl.ServiceImpl;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmc
 */
public class ChangePasswordController extends HttpServlet {

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
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
        String username = request.getParameter("username");
        String password = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        boolean error = false;
        System.out.println("username:" + username);

        if (username.length() == 0 || username == null) {
            error = true;
        }
        if (password.length() == 0 || password == null) {
            error = true;
        }
        if (newPassword.length() == 0 || newPassword == null) {
            error = true;
        }
        if (confirmPassword.length() == 0 || confirmPassword == null) {
            error = true;
        }
        if (error) {
            request.setAttribute("clientError", "All fields are mandatory!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("matchError", "New Password and Confirm Password do not match!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
            dispatcher.forward(request, response);
            return;
        }

        AppUserService appUserService = ServiceUtils.getAppUserService();
        AppUser appUser1 = appUserService.authenticate(username, password);

        if (appUser1 == null) {

            request.setAttribute("errormsg", "Incorrect Current Password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
            dispatcher.forward(request, response);
            return;

        }

        if (appUser.getUserRole().equalsIgnoreCase("admin")) {

            request.setAttribute("msg", "Password is changed successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
            dispatcher.forward(request, response);
        }

        if (appUser.getUserRole().equalsIgnoreCase("doctor")) {
            request.setAttribute("msg", "Password is changed successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorHome.jsp");
            dispatcher.forward(request, response);
        }
        if (appUser.getUserRole().equalsIgnoreCase("patient")) {
            request.setAttribute("msg", "Password is changed successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/patientHome.jsp");
            dispatcher.forward(request, response);
        }
        if (appUser.getUserRole().equalsIgnoreCase("labAdmin")) {
            request.setAttribute("msg", "Password is changed successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/labAdminHome.jsp");
            dispatcher.forward(request, response);
        }

        appUser.setId(appUser.getId());
        appUser.setActive(appUser.getActive());
        appUser.setGuid(appUser.getGuid());
        appUser.setCreatedBy(appUser.getCreatedBy());
        appUser.setCreatedOn(appUser.getCreatedOn());
        appUser.setModifiedBy(appUser.getModifiedBy());
        appUser.setModifiedOn(new java.util.Date());
        appUser.setUserRole(appUser.getUserRole());
        appUser.setSecurityQuestion(appUser.getSecurityQuestion());
        appUser.setAnswer(appUser.getAnswer());
        appUser.setUserName(appUser.getUserName());
        appUser.setPassword(confirmPassword);
        appUserService.create(appUser);


        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/patientHome.jsp");
        dispatcher1.forward(request, response);


    }
}
