/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.controller;

import com.asiapp.utils.service.AppSaiSpringContext;
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
        AppSaiSpringContext.init();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {
        return "/home";
    }
}
