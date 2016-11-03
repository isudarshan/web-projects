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
import javax.servlet.http.HttpSession;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Balance;
import org.bankapp.domain.Bankuser;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.utils.EncryptDecrypt;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc5
 */
public class IbUseLloginController extends RootServlet {

    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uName = request.getParameter("userName");
        String accountNumber = request.getParameter("accountNumber");
        String vCode = request.getParameter("verificationCode");
        String password = request.getParameter("password");
        BankServices services = BankServiceUtils.getInstance();
        Bankuser user = services.getBankUserById(new Long(uName));
        if (user != null) {
            if (user.getPassword() == null) {
                String pwd = user.getOldPassword();
                if (pwd.equals(password)) {
                    if (user.getRole().equalsIgnoreCase("user")) {
                        Balance b = services.getBalanceByAcctId(new Long(accountNumber));
                        if (b != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("user", user.getUserId());
                            session.setAttribute("userAccountId", b.getAccountId());
                            response.sendRedirect("ibUserChangePassword.jsp");
                        }
                    }
                }
            } else {
                Balance b = services.getBalanceByAcctId(new Long(accountNumber));
                if (b != null) {

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user.getUserId());
                    session.setAttribute("userAccountId", b.getAccountId());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/userhomepage.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }

        } else {
            response.sendRedirect("IBuserLogin.jsp");
        }
    }
}
