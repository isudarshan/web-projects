/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.web.forms.ChangePasswordForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lms.utils.ioc.AppContext;
import com.lms.domain.sub.AppUser;
import com.lms.service.AppUserService;
import com.lms.context.id.names.ContextIdNames;
/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/changePassword")
public class ChangePasswordController {

    private static Logger LOG = Logger.getLogger(ChangePasswordController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String showChangeForm(@ModelAttribute ChangePasswordForm changePasswordForm) {

        return "/changePassword";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String changePassword(@ModelAttribute ChangePasswordForm changePasswordForm) {

        LOG.debug("In Controller");
        String response = null;
        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        AppUser appUser = appUserService.findByUserName(changePasswordForm.getEmployeeId());
        if(appUser == null) {
            response = "Invalid User Name/ Your Session Expired, Please Login";
            return response;
        }

        appUser.setId(appUser.getId());
        appUser.setPassword(changePasswordForm.getConfirmPassword());
        appUser.setModifiedOn(new java.util.Date());

        appUserService.create(appUser);
        return "Your Password Changed";
    }

}
