/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Balance;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc11
 */
public class ChequeController extends RootServlet {

    private static final Logger LOG = Logger.getLogger(ChequeController.class);

    @Override
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            FileItem date = list.get(0);
            String date1 = date.getString();

            FileItem branchName = list.get(1);
            String branch = branchName.getString();


            FileItem payAt = list.get(2);
            String pay = payAt.getString();

            FileItem accountnumber = list.get(3);
            String accnumber = accountnumber.getString();

            FileItem accountname = list.get(4);
            String accname = accountname.getString();

            FileItem amountrupees = list.get(5);
            String amtrupees = amountrupees.getString();

            FileItem amountwords = list.get(6);
            String amtwords = amountwords.getString();

            FileItem Transaction = list.get(7);
            String trans = Transaction.getString();


            FileItem sign = list.get(8);
            byte[] signature = sign.get();


            BankServices services = BankServiceUtils.getInstance();

            if (trans.equals("Withdrawal")) {
                String status = services.withdrawMoney(new Long(accnumber), Double.parseDouble(amtrupees));
                if (status != null) {
                    request.setAttribute("Status", "Transaction Success");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cheque.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("Status", "Transaction Not Success");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cheque.jsp");
                    dispatcher.forward(request, response);
                }

            } else if (trans.equals("Deposit")) {
                String status = services.depositMoney(new Long(accnumber), Double.parseDouble(amtrupees));
                if (status != null) {
                    request.setAttribute("Status", "Transaction Success");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cheque.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("Status", "Transaction Not Success");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cheque.jsp");
                    dispatcher.forward(request, response);
                }

            }



















            LOG.debug(list.size());


        } catch (FileUploadException ex) {
            LOG.warn(ex.getMessage());
        }



    }
}
