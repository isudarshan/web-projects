/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.web.controller;

import com.dmsapp.web.forms.InternalForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/internal")
public class InternalMarksController {
    private Logger LOG = Logger.getLogger(InternalMarksController.class);
    @RequestMapping(method = RequestMethod.POST)
    public String postInternal(@ModelAttribute InternalForm internalForm, WebRequest webRequest) {
        LOG.debug("Internal Form : "+internalForm);
        webRequest.setAttribute("internalForm", internalForm, WebRequest.SCOPE_SESSION);
        return "/readyPost";
    }
}
