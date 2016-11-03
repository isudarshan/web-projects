package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AppUser appUser = (AppUser) request.getSession().getAttribute("user");
        
        if(appUser!=null) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }


    }
}
