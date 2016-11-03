/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.bankapp.domain.Address;
import org.bankapp.domain.Balance;
import org.bankapp.domain.Bankuser;
import org.bankapp.domain.Customer;
import org.bankapp.domain.Details;
import org.bankapp.utils.BankServiceUtils;
import org.bankapp.web.utils.RandomGenerator;
import org.bankapp.web.utils.RootServlet;

/**
 *
 * @author cmc9lab2
 */
public class ClerkCreationController extends RootServlet {
    
    private static Logger LOG = Logger.getLogger(ClerkCreationController.class);
    
    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            
            FileItem AccountType = list.get(0);
            String accType = AccountType.getString();
            
            
            FileItem MinimumBalance = list.get(1);
            String minBalance = MinimumBalance.getString();
            
            FileItem firstName = list.get(2);
            String fName = firstName.getString();
            
            FileItem lastName = list.get(3);
            String lName = lastName.getString();
            
            FileItem parentName = list.get(4);
            String pName = parentName.getString();
            
            FileItem designation = list.get(5);
            String desgn = designation.getString();
            
            FileItem dob = list.get(6);
            String dateOfBirth = dob.getString();
            
            FileItem age = list.get(7);
            String clerkAge = age.getString();
            
            FileItem gender = list.get(8);
            String clerkGender = gender.getString();
            
            FileItem email = list.get(9);
            String clerkEmail = email.getString();
            
            FileItem phNo = list.get(10);
            String phoneNumber = phNo.getString();
            
            FileItem SecurityQuestion = list.get(11);
            String secQuestion = SecurityQuestion.getString();
            
            FileItem answer = list.get(12);
            String ans = answer.getString();
            
            FileItem doorNo = list.get(13);
            String dNo = doorNo.getString();
            
            FileItem streetName = list.get(14);
            String stName = streetName.getString();
            
            FileItem city = list.get(15);
            String cty = city.getString();
            
            FileItem districtName = list.get(16);
            String distName = districtName.getString();
            
            FileItem stateName = list.get(17);
            String statName = stateName.getString();
            
            FileItem country = list.get(18);
            String ctry = country.getString();
            
            FileItem pincode = list.get(19);
            String pcode = pincode.getString();
            
            FileItem role = list.get(20);
            String roleType = role.getString();
            
            FileItem profilepic = list.get(21);
            byte[] pfpic = profilepic.get();
            
            FileItem signature = list.get(22);
            byte[] sig = signature.get();
            
            FileItem document = list.get(23);
            byte[] documentType = document.get();
            
            LOG.debug(list.size());
            
            Address address = new Address();
            Details details = new Details();
            Bankuser bankuser = new Bankuser();
            Balance balance = new Balance();
            Customer customer = new Customer();
            
            balance.setAccountId(RandomGenerator.generateAccountId());
            balance.setBalance(Double.parseDouble(minBalance));
            
            address.setAddressId(RandomGenerator.generateAddressId());
            address.setDoorNo(dNo);
            address.setStreetName(stName);
            address.setCity(cty);
            address.setDistrict(distName);
            address.setState(statName);
            address.setCountry(ctry);
            address.setPincode(Long.parseLong(pcode));
            
            details.setAccountType(accType);
            details.setMinimumBalance(Double.parseDouble(minBalance));
            details.setDetailsId(RandomGenerator.generateDetailsId());
            details.setFirstName(fName);
            details.setLastName(lName);
            details.setParentName(pName);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d = format.parse(dateOfBirth);
            dateOfBirth = format.format(d);
            details.setDateOfBirth(dateOfBirth);
            details.setEmailId(clerkEmail);
            details.setMobile(phoneNumber);
            details.setSecurityQuestion(secQuestion);
            details.setSecurityAnswer(ans);
            details.setPicture(pfpic);
            details.setSignature(sig);
            details.setDocuments(documentType);
            details.setDesignation(desgn);
            
            
            details.setAddressId(address);
            customer.setDetaildId(details);
            
            bankuser.setRole(roleType);
            bankuser.setUserId(RandomGenerator.generateClerkId());
            bankuser.setOldPassword(RandomGenerator.generateUserPassword(pName));
            
            customer.setUserId(bankuser);
            customer.setAccountId(balance);
            
            customer.setCustomerId(RandomGenerator.generateCustomerId());
            
            BankServices service = BankServiceUtils.getInstance();
            
            service.createAccount(customer);
            request.setAttribute("Msg", "Account created");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/clerkRegistration.jsp");
            dispatcher.forward(request, response);
            
            LOG.debug("customer Created");
            
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ClerkCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.debug("Welcome To ClerkCreationController");
        LOG.debug("Whole Servlet");
        
        
    }
}
