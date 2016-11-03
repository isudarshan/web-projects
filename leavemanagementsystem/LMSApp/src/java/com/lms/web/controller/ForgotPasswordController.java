/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.service.AppUserService;
import com.lms.web.forms.ForgotForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lms.context.id.names.ContextIdNames;
import com.lms.utils.ioc.AppContext;
import com.lms.domain.sub.AppUser;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    @RequestMapping(method = RequestMethod.GET)
    
    public String showForgotForm(@ModelAttribute ForgotForm forgotForm) {


        return "/forgotPassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String showPassword(@ModelAttribute ForgotForm forgotForm) {

        String response = null;
        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        AppUser appUser = appUserService.findByUserName(forgotForm.getEmployeeId());

        if(appUser == null) {
            response = "Invalid UserName !";
            return response;
        }

        if(appUser.getQuestion().equals(forgotForm.getQuestion()) && appUser.getAnswer().equals(forgotForm.getAnswer())) {
            response = "Your Password is : "+appUser.getPassword();
            return response;
        }else {
            response = "Invalid Details !";
            return response;
        }
        
    }
}
