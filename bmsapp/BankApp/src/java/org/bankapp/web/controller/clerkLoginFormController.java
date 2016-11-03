/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc9lab2
 */
public class clerkLoginFormController extends RootServlet{
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String clerkId = request.getParameter("clerkId");
    String password = request.getParameter("password");
    
    
    
    }
    
}
