/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.SecurityForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/security")
public class SecurityQuestionController {

    @RequestMapping(method = RequestMethod.GET)
    public String setupSecurityQuestion(@ModelAttribute SecurityForm securityForm, WebRequest request) {
        Student student = (Student) request.getAttribute("student", WebRequest.SCOPE_SESSION);
        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);

        return "/security";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postQuestion(@ModelAttribute SecurityForm securityForm, WebRequest request) {
        String response = null;


        AppUser appUser = ServiceUtils.getAppUserService().findByUserName(securityForm.getStudentId());
        if (appUser == null) {
            response = "Invalid User Name/ Your Session Expired, Please Login";
            return response;
        }

        appUser.setId(appUser.getId());
        appUser.setQuestion(securityForm.getQuestion());
        appUser.setAnswer(securityForm.getAnswer());
        appUser.setModifiedOn(new java.util.Date());

        ServiceUtils.getAppUserService().create(appUser);

        return "Security Question Changed !";
    }
}
