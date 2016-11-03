
package com.dmsapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/home")
public class StartupController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {
        return "/home";
    }


}
