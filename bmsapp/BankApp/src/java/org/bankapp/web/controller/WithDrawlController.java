/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.bankservices.impl.BankServicesImpl;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc11
 */
public class WithDrawlController extends RootServlet{
    
       private static final Logger LOG = Logger.getLogger(AccountCreationController.class);
     public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    
     String branchname = request.getParameter("branchName");
    
     String date = request.getParameter("date");
    
     String accountnumber = request.getParameter("accountNumber");
    
     String customername = request.getParameter("customerName");
    
     String amountrupees = request.getParameter("amount");
       
     String amountwords = request.getParameter("amt");
        
     String mobilenumber = request.getParameter("mobileNumber");
         
     String depositorid = request.getParameter("depositorId");
         
        LOG.debug(branchname);
      LOG.debug(date);
        LOG.debug(accountnumber);
        LOG.debug(customername);
        LOG.debug(amountrupees);
       LOG.debug(amountwords);
        LOG.debug( mobilenumber);
        LOG.debug(depositorid);
        
      BankServices service  = BankServiceUtils.getInstance();
    service.withdrawMoney(new Long(accountnumber), Double.parseDouble(amountrupees));
       
        String status="Your Transaction is Successfull";
       request.setAttribute("msg", status);
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WithDrawlForm.jsp");
        dispatcher.forward(request, response);
    }
}
