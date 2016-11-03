/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Bankuser;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.utils.EncryptDecrypt;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc9lab2
 */
public class IbChangePasswordController extends RootServlet {

    private static Logger LOG = Logger.getLogger(IbChangePasswordController.class);

    @Override
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String accountNumber = request.getParameter("accountNumber").trim();
        String oldpswd = request.getParameter("oldpswd").trim();
        String newpswd = request.getParameter("newpswd").trim();
        String confirmpswd = request.getParameter("confirmpswd").trim();

        LOG.debug(accountNumber + "\t" + oldpswd + "\t" + newpswd + "\t" + confirmpswd);


        BankServices services = BankServiceUtils.getInstance();
        LOG.debug("Service Started");
        Bankuser user = services.getBankUserById(new Long(accountNumber));
        if (user != null) {
            LOG.debug("Service User Ready");
            if (user.getPassword() == null || user.getPassword().equals("")) {
                if ((!(oldpswd).equals(newpswd)) && (!(newpswd.equals(confirmpswd))) && (!(user.getOldPassword().equals(oldpswd)))) {
                    request.setAttribute("passwordError", "Passwords are mismatched");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ibUserChangePassword.jsp");
                    dispatcher.forward(request, response);
                    return;
                } else {
                    LOG.debug(response);
                    List list = EncryptDecrypt.encrypt(newpswd);
                    LOG.debug(list.size());
                    String Estring = (String) list.get(0);
                    byte[] secKey = (byte[]) list.get(1);
                    LOG.debug(Estring + secKey);
                    Bankuser user1 = new Bankuser();
                    user1.setPassword(Estring);
                    user1.setUserId(user.getUserId());
                    user1.setRole(user.getRole());
                    user1.setOldPassword(oldpswd);
                    user1.setSecretKey(secKey);
                    services.changeAccountDetails(user1);
                    request.setAttribute("msg", "Your password is changed");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/ibUserChangePassword.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
                
            }
        } else {
            response.sendRedirect("IBuserLogin.jsp");
        }


    }
}
