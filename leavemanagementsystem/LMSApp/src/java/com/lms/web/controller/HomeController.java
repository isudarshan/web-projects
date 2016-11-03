/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.utils.ioc.AppLmsContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public HomeController() {
        AppLmsContext.init();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {        
        return "/home";
    }
}
