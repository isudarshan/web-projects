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
import org.bankapp.bankservices.impl.BankServicesImpl;
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
 * @author cmc5
 */
public class AccountCreationController extends RootServlet {
    
    private static final Logger LOG = Logger.getLogger(AccountCreationController.class);
    
    @Override
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
            
            
            FileItem FirstName = list.get(2);
            String fName = FirstName.getString();
            
            
            FileItem LastName = list.get(3);
            String lName = LastName.getString();
            
            
            FileItem parentName = list.get(4);
            String parentname = parentName.getString();
            
            
            FileItem Designation = list.get(5);
            String desgn = Designation.getString();
            
            
            FileItem dateofBirth = list.get(6);
            String dob = dateofBirth.getString();
            
            
            FileItem phoneNo = list.get(7);
            String pNo = phoneNo.getString();
            
            FileItem email = list.get(8);
            String eml = email.getString();
            
            FileItem SecQuestion = list.get(9);
            String secQuest = SecQuestion.getString();
            
            FileItem answer = list.get(10);
            String ansr = answer.getString();
            
            FileItem gender = list.get(11);
            String gndr = gender.getString();
            
            FileItem status = list.get(12);
            String sts = status.getString();
            
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
            
            FileItem profilepic = list.get(20);
            byte[] pfpic = profilepic.get();
            
            
            FileItem thumbPrint = list.get(21);
            byte[] thmbpt = thumbPrint.get();
            
            FileItem proof = list.get(22);
            byte[] addressProof = proof.get();
            
            LOG.debug(list.size());
            
            Address address = new Address();
            Details details = new Details();
            Balance balance = new Balance();
            Bankuser user = new Bankuser();
            Customer customer = new Customer();
            LOG.debug("After obj creattion");
            address.setAddressId(RandomGenerator.generateAddressId());
            address.setDoorNo(dNo);
            address.setStreetName(stName);
            address.setCity(cty);
            address.setDistrict(distName);
            address.setState(statName);
            address.setCountry(ctry);
            address.setPincode(Long.parseLong(pcode));
            LOG.debug("After addr creattion");
            details.setDetailsId(RandomGenerator.generateDetailsId());
            details.setAccountType(accType);
            details.setMinimumBalance(Double.parseDouble(minBalance));
            details.setFirstName(fName);
            details.setLastName(lName);
            details.setParentName(parentname);
            details.setDesignation(desgn);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d = format.parse(dob);
            dob = format.format(d);
            details.setDateOfBirth(dob);
            details.setMobile(pNo);
            details.setEmailId(eml);
            details.setSecurityQuestion(secQuest);
            details.setSecurityAnswer(ansr);
            details.setAddressId(address);
            details.setPicture(pfpic);
            details.setSignature(thmbpt);
            details.setDocuments(addressProof);
            
            LOG.debug("After Details creattion");
            balance.setAccountId(RandomGenerator.generateAccountId());
            balance.setBalance(details.getMinimumBalance());
            LOG.debug("After balance creattion");
            user.setUserId(RandomGenerator.generateUserId());
            user.setOldPassword(RandomGenerator.generateUserPassword(lName));
            //user.setSecretKey();
            user.setRole("User");
            LOG.debug("After USer creattion");
            customer.setCustomerId(RandomGenerator.generateCustomerId());
            customer.setAccountId(balance);
            customer.setDetaildId(details);
            customer.setUserId(user);
            LOG.debug("After Customer creattion");
            LOG.debug("Befor service creattion");
            BankServices service = BankServiceUtils.getInstance();
            service.createAccount(customer);
            LOG.debug("FIANALLLLLLLL ");
            request.setAttribute("Msg", "Account created");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/accountcreation.jsp");
            dispatcher.forward(request, response);
            
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(AccountCreationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
