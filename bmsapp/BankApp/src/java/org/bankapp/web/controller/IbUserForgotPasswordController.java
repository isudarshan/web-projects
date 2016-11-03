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
import org.apache.log4j.Logger;

import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc5
 */
public class IbUserForgotPasswordController extends RootServlet {

    private static Logger LOG = Logger.getLogger(IbUserForgotPasswordController.class);

    @Override
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String accnum = request.getParameter("accountNumber");
        out.println(accnum);
        String email = request.getParameter("email");
        out.println(email);
        String secQstn = request.getParameter("secQuestion");
        out.println(secQstn);
        String answer = request.getParameter("answer");
        out.println(answer);

    }
}
