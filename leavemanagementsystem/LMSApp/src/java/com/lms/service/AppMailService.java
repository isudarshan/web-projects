/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;


import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import com.lms.domain.sub.AppUser;
import com.lms.domain.sub.Staff;
import com.lms.domain.sub.StaffLeave;
/**
 *
 * @author Sudarsan
 */
public interface AppMailService extends Service {
    
    void setMailSender(JavaMailSender mailSender);
    
    void setVelocityEngine(VelocityEngine velocityEngine);
    
    void sendMail(final AppUser appUser, final Staff staff);
    
    void sendApproveMail(final StaffLeave staffLeave, final Staff staff);

    void sendRejectMail(final StaffLeave staffLeave, final Staff staff);



    //void sendPassword(final Student student, final AppUser appUser);
    
   
}
