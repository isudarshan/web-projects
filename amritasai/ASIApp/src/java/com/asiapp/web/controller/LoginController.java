/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.LoginForm;
import java.util.List;
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
    public String showLogin(@ModelAttribute LoginForm loginForm) {
        return "/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postLogin(@ModelAttribute LoginForm loginForm, WebRequest request) {
        LOG.debug("In Post");
        LOG.debug(loginForm);
        String response = null;
        AppUser appUser = ServiceUtils.getAppUserService().authenticate(loginForm.getUserName().trim(), loginForm.getPassword().trim());

        LOG.debug("App User :"+appUser);
        if (appUser == null) {
            //request.setAttribute("errMsg", "Invalid UserId/Password", WebRequest.SCOPE_REQUEST);
            response = "Invalid UserId/Password";
            return response;
        }

        if ("Admin".equalsIgnoreCase(appUser.getUserRole())) {
            request.setAttribute("appUser", appUser, WebRequest.SCOPE_SESSION);
            response = "/admin";
        }

        if ("Student".equalsIgnoreCase(appUser.getUserRole())) {
            Student student = ServiceUtils.getStudentService().findByStudentId(appUser.getUserName());
            LOG.debug("Student : "+student);
            if (student == null) {
                response = "Invalid Registration Id !";
                return response;
            }

            List<Subject> subjectList = ServiceUtils.getStudentService().getSubjects(student.getStudentId());
            request.setAttribute("appUser", appUser, WebRequest.SCOPE_SESSION);
            request.setAttribute("student", student, WebRequest.SCOPE_SESSION);
            request.setAttribute("subjectList", subjectList, WebRequest.SCOPE_SESSION);
            response = "/studentHome";
        }

        return response;
    }
}
