/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Customer;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author vinod
 */
public class ListController extends RootServlet {

    private static Logger LOG = Logger.getLogger(ListController.class);

    @Override
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BankServices services = BankServiceUtils.getInstance();
        List<Customer> customersList = services.retrieveList();
        if (customersList != null) {
            LOG.debug(customersList.size());
            if (customersList.isEmpty()) {
                request.setAttribute("List", customersList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/List.jsp");
                dispatcher.forward(request, response);

            } else {
                request.setAttribute("List", customersList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/List.jsp");
                dispatcher.forward(request, response);
            }
            LOG.debug(customersList);
//        } else {
//            request.setAttribute("List", "No List");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/List.jsp");
//            dispatcher.forward(request, response);
//        }
        }
    }
}
