/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.domain.sub.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/logout")
public class LogOutController {

    @RequestMapping(method = RequestMethod.GET)
    public String doSignOut(WebRequest request) {

        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);

        if (appUser != null) {
            request.removeAttribute("appUser", WebRequest.SCOPE_SESSION);
            return "redirect:/home";
        }
        return "redirect:/home";
    }
}
