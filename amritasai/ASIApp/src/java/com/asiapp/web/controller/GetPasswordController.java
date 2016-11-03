/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import com.asiapp.service.AppMailService;
import com.asiapp.utils.service.AppContext;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.GetPasswordForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/getPassword")
public class GetPasswordController {

    private static Logger LOG = Logger.getLogger(GetPasswordController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showGetPasswordForm(@ModelAttribute GetPasswordForm getPasswordForm) {
        return "/getPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String getPassword(@ModelAttribute GetPasswordForm getPasswordForm) {

        String response = null;

        AppUser appUser = ServiceUtils.getAppUserService().findByUserName(getPasswordForm.getStudentId());

        if (appUser == null) {
            response = "Inavlid Registration Number";
            return response;
        }

        if (appUser.getQuestion().equals(getPasswordForm.getQuestion()) && appUser.getAnswer().equals(getPasswordForm.getAnswer())) {

            Student student = ServiceUtils.getStudentService().findByStudentId(appUser.getUserName());

            try {


                AppMailService appMailService = (AppMailService) AppContext.APPCONTEXT.getBean("appMailService");
                appMailService.sendPassword(student, appUser);
                response = "Your Password is sent to E-Mail";
            } catch (Exception exception) {
                LOG.debug("GetPasswordController", exception);

            }

            return response;
        }else {
             response = "Invalid SecurityQuestion / Answer !\nPlease Try Again";
            return response;

        }


    }
}
