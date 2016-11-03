/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/studentHome")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public String showStudent() {
        return "/studentHome";
    }
}
