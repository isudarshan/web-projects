/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.ChangePasswordForm;
import org.apache.log4j.Logger;
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
@RequestMapping("/changePassword")
public class ChangePasswordController {

    private static Logger LOG = Logger.getLogger(ChangePasswordController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String showChangePasswordForm(@ModelAttribute ChangePasswordForm changePasswordForm, WebRequest request) {
        Student student = (Student) request.getAttribute("student", WebRequest.SCOPE_SESSION);
        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);
        
        return "/changePassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String changePassword(@ModelAttribute ChangePasswordForm changePasswordForm) {

        LOG.debug("In Controller");
        String response = null;
        AppUser appUser = ServiceUtils.getAppUserService().findByUserName(changePasswordForm.getStudentId());
        if(appUser == null) {
            response = "Invalid User Name/ Your Session Expired, Please Login";
            return response;
        }

        appUser.setId(appUser.getId());
        appUser.setPassword(changePasswordForm.getConfirmPassword());
        appUser.setModifiedOn(new java.util.Date());

        ServiceUtils.getAppUserService().create(appUser);
        return "Your Password Changed";
    }

}
