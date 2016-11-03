/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.RegisteredDoctor;
import com.hms.service.AppUserService;
import com.hms.service.RegisteredDoctorService;
import com.hms.service.impl.AppUserServiceImpl;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cmc
 */
public class LoginController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean error = false;
        
        if (userName.length() == 0 || userName == null) {
            error = true;
        }
        
        if (password.length() == 0 || password == null) {
            error = true;
        }
        
        if (error) {
            request.setAttribute("clientError", "All Fields are required !");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
            
        }
        
        
        
        
        AppUserService appUserService = ServiceUtils.getAppUserService();
        
        AppUser appUser = appUserService.authenticate(userName, password);
        
        if (appUser == null) {
            request.setAttribute("dbError", "Invalid UserName/Password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        
        if (appUser.getUserRole().equalsIgnoreCase("admin")) {
            session.setAttribute("user", appUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        if (appUser.getUserRole().equalsIgnoreCase("patient")) {
            session.setAttribute("user", appUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/patientHome.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (appUser.getUserRole().equalsIgnoreCase("doctor")) {
            session.setAttribute("user", appUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorHome.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if(appUser.getUserRole().equalsIgnoreCase("labAdmin")){
            session.setAttribute("user", appUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/labAdminHome.jsp");
            dispatcher.forward(request, response);
        }

        if(appUser.getUserRole().equalsIgnoreCase("pharmacist")){
            session.setAttribute("user", appUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pharmacyAdminHome.jsp");
            dispatcher.forward(request, response);
        }
        
        
    }
    
  
    
}
