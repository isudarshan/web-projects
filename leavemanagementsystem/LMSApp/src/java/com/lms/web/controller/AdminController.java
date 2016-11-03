/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.Staff;
import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAdmin(WebRequest request) {
        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        List<Staff> staffList = staffService.getAll();
        request.setAttribute("staffList", staffList, WebRequest.SCOPE_SESSION);
        return"/adminHome";
    }
}
