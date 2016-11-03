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
public class SetQuestionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
        String username = request.getParameter("username");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");

        boolean error = false;
        System.out.println("username:" + username);

        if (username.length() == 0 || username == null) {
            error = true;
        }

        if (answer.length() == 0 || answer == null) {
            error = true;
        }

        if (error) {
            request.setAttribute("clientError", "All fields are mandatory!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/setQuestion.jsp");
            dispatcher.forward(request, response);
            return;
        }

        AppUserService appUserService = ServiceUtils.getAppUserService();
        AppUser appUser1 = appUserService.findByUserName(username);

        if (appUser1 == null) {

            request.setAttribute("errormsg", "No such User");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/setQuestion.jsp");
            dispatcher.forward(request, response);
            return;

        }

        appUser.setId(appUser.getId());
        appUser.setActive(appUser.getActive());
        appUser.setGuid(appUser.getGuid());
        appUser.setCreatedBy(appUser.getCreatedBy());
        appUser.setCreatedOn(appUser.getCreatedOn());
        appUser.setModifiedBy(appUser.getModifiedBy());
        appUser.setModifiedOn(new java.util.Date());
        appUser.setUserRole(appUser.getUserRole());
        appUser.setSecurityQuestion(question);
        appUser.setAnswer(answer);
        appUser.setUserName(appUser.getUserName());
        appUser.setPassword(appUser.getPassword());
        appUserService.create(appUser);

        if (appUser.getUserRole().equalsIgnoreCase("admin")) {

            request.setAttribute("msg", "SecurityQues set successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
            dispatcher.forward(request, response);
        }

        if (appUser.getUserRole().equalsIgnoreCase("doctor")) {
            request.setAttribute("msg", "SecurityQues set successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorHome.jsp");
            dispatcher.forward(request, response);
        }
        if (appUser.getUserRole().equalsIgnoreCase("patient")) {
            request.setAttribute("msg", "SecurityQues set successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/patientHome.jsp");
            dispatcher.forward(request, response);
        }
        if (appUser.getUserRole().equalsIgnoreCase("labAdmin")) {
            request.setAttribute("msg", "SecurityQues set successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/labAdminHome.jsp");
            dispatcher.forward(request, response);
        }

        


    }
}
