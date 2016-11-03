/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Bankuser;
import org.bankapp.domain.Customer;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.web.utils.RootServlet;

public class AdminClerkLoginController extends RootServlet {

    private static Logger LOG = Logger.getLogger(AdminClerkLoginController.class);

    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankServices service = BankServiceUtils.getInstance();

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
//        Customer customer = service.getCustomerById(new Long(userId));
//        if (customer == null) {
//            request.setAttribute("UserError", "Invalid Details are entered");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/bankLogin.jsp");
//            dispatcher.forward(request, response);
//            return;
//        }
//        String pwd = customer.getUserId().getOldPassword();
//        LOG.debug(userId);
//        LOG.debug(password);
//        if (customer == null || (!password.equals(pwd))) {
//            LOG.debug("Customer Not Avaliable (Or) Invalid Details are entered)");
//            request.setAttribute("UserError", "Invalid Details are entered");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/bankLogin.jsp");
//            dispatcher.forward(request, response);
//            return;
//        }
        Bankuser user = service.getBankUserById(new Long(userId));
        String pwd = user.getOldPassword();
        if (user == null) {
            request.setAttribute("UserError", "Invalid Details are entered");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/bankLogin.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            if (user.getRole().equalsIgnoreCase("admin") && password.equals(pwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("BankUser", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHome.jsp");
                dispatcher.forward(request, response);
                return;
            } else if (user.getRole().equalsIgnoreCase("clerk") && password.equals(pwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("BankUser", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/clerkHome.jsp");
                dispatcher.forward(request, response);
                return;
            } else {
                request.setAttribute("UserError", "Invalid Details are entered");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/bankLogin.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/bankLogin.jsp");
//        dispatcher.forward(request, response);


    }
}
