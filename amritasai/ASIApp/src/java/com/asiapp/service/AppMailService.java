/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import java.util.List;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author Sudarsan
 */
public interface AppMailService extends Service {
    
    void setMailSender(JavaMailSender mailSender);
    
    void setVelocityEngine(VelocityEngine velocityEngine);
    
    void sendMail(final Student student, final AppUser appUser);

    void sendPassword(final Student student, final AppUser appUser);
    
   
}
