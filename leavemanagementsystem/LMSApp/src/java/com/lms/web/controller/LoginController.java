/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.AppUser;
import com.lms.domain.sub.Staff;
import com.lms.service.AppUserService;
import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import com.lms.web.forms.LoginForm;
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
@RequestMapping("/login")
public class LoginController {

    private static Logger LOG = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(@ModelAttribute LoginForm loginForm) {
       return "/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postLoginForm(@ModelAttribute LoginForm loginForm, WebRequest request) {


        LOG.debug("In Post");
        LOG.debug(loginForm);
        String response = null;
        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        AppUser appUser = (AppUser) appUserService.authenticate(loginForm.getUserName(), loginForm.getPassword());

        LOG.debug("App User :" + appUser);
        if (appUser == null) {
            //request.setAttribute("errMsg", "Invalid UserId/Password", WebRequest.SCOPE_REQUEST);
            response = "Invalid UserId/Password";
            return response;
        }

        if ("Admin".equalsIgnoreCase(appUser.getUserRole())) {
            request.setAttribute("appUser", appUser, WebRequest.SCOPE_SESSION);
            response = "/admin";
        }

        if ("Employee".equalsIgnoreCase(appUser.getUserRole())) {
            request.setAttribute("appUser", appUser, WebRequest.SCOPE_SESSION);
            StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
            Staff staff = staffService.findByEmployeeId(appUser.getUserName());
            request.setAttribute("staff", staff, WebRequest.SCOPE_SESSION);
            response = "/employeeHome";
        }

        return response;





    }
}
