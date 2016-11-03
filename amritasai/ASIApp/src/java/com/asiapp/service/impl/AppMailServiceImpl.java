package com.asiapp.service.impl;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import com.asiapp.service.AppMailService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Sudarsan
 */
public class AppMailServiceImpl extends ServiceImpl implements AppMailService {

    private static Logger LOG = Logger.getLogger(AppMailServiceImpl.class);
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    public AppMailServiceImpl() {
    }

    /**
     *
     * @param mailSender
     */
    @Override
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     *
     * @param velocityEngine
     */
    @Override
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    /**
     *
     * @param appUser
     * @param imageList
     */
    @Override
    public void sendMail(final Student student, final AppUser appUser) {
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {


                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED);
                mimeMessageHelper.setTo(student.getEmail());
                mimeMessageHelper.setSubject("Welcome to Amrita Sai ");
                mimeMessageHelper.setSentDate(new java.util.Date());
                mimeMessageHelper.setFrom("amritasaicollegevijayawada@gmail.com");

                Map model = new HashMap();
                model.put("student", student);
                model.put("appUser", appUser);

                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/mailTemplate.vm", model);

                mimeMessageHelper.setText(text, true);


            }
        };

        this.mailSender.send(mimeMessagePreparator);
    }

    public void sendPassword(final Student student, final AppUser appUser) {

        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {


                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED);
                mimeMessageHelper.setTo(student.getEmail());
                mimeMessageHelper.setSubject("Welcome to Amrita Sai ");
                mimeMessageHelper.setSentDate(new java.util.Date());
                mimeMessageHelper.setFrom("amritasaicollegevijayawada@gmail.com");

                String text = "Dear "+student.getFirstName()+" "+student.getLastName()+"\nYour Password is : " + appUser.getPassword();

                mimeMessageHelper.setText(text, true);


            }
        };

        this.mailSender.send(mimeMessagePreparator);

    }
}
