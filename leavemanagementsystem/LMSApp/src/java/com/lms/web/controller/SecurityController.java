/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.service.AppUserService;
import com.lms.web.forms.SecurityForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.AppUser;
import com.lms.utils.ioc.AppContext;
/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping(method = RequestMethod.GET)
    public String showSecurityForm(@ModelAttribute SecurityForm securityForm) {
        return "/security";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postQuestion(@ModelAttribute SecurityForm securityForm, WebRequest request) {
        String response = null;

        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);

        AppUser appUser = appUserService.findByUserName(securityForm.getEmployeeId());
        if (appUser == null) {
            response = "Invalid User Name/ Your Session Expired, Please Login";
            return response;
        }

        appUser.setId(appUser.getId());
        appUser.setQuestion(securityForm.getQuestion());
        appUser.setAnswer(securityForm.getAnswer());
        appUser.setModifiedOn(new java.util.Date());

        appUserService.create(appUser);

        return "Security Question Changed !";
    }
}
