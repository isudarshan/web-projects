package org.bankapp.web.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.bankapp.domain.Customer;

class MailAut extends Authenticator {

    PasswordAuthentication authentication;

    public PasswordAuthentication getPasswordAuthentication() {
        authentication = new PasswordAuthentication("bankmanagementapp@gmail.com", "bankmanagement");
        return authentication;
    }
}

public class MailUtils {

    public static void mail(String eMail, Customer customer) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new MailAut());
        InternetAddress toAddress = new InternetAddress(eMail);
        InternetAddress fromAddress = new InternetAddress("bankmanagementapp@gmail.com");
        Message message = new MimeMessage(session);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        message.setFrom(fromAddress);
        message.setSentDate(new java.util.Date());
        message.setSubject("YOUR BANK ACCOUNT DETAILS.....");
        message.setText("You Bank Acct Details \n\n\nACCOUNT ID -------------" + customer.getAccountId().getAccountId() + "Your Password :" + customer.getUserId().getPassword());
        Transport.send(message);
    }

    public static void mail(Customer customer) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props, new MailAut());
        InternetAddress toAddress = new InternetAddress(customer.getDetaildId().getEmailId());
        InternetAddress fromAddress = new InternetAddress("bankmanagementapp@gmail.com");
        Message message = new MimeMessage(session);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        message.setFrom(fromAddress);
        message.setSentDate(new java.util.Date());
        message.setSubject("YOUR BANK ACCOUNT DETAILS.....");
        message.setText("You Bank Acct Details \n\n\nACCOUNT ID -------------" + customer.getAccountId().getAccountId() + "\n" + "Your Ib UserId:" + customer.getUserId().getUserId() + "\n" + "Your Old Password (For First Use Only):" + customer.getUserId().getOldPassword());
        Transport.send(message);
    }
}
