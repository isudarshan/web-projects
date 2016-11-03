/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;

import com.lms.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lms.web.forms.StafForm;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lms.utils.ioc.AppContext;
import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.Staff;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/edit")
public class EditEmployeeController {


    @RequestMapping(method = RequestMethod.GET, params={"employeeId"})
    public String editEmployeeForm(@ModelAttribute StafForm stafForm, String employeeId, WebRequest request) {

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        Staff staff = staffService.findByEmployeeId(employeeId);
        stafForm.setEmployeeId(staff.getEmployeeId());
        stafForm.setFullName(staff.getFullName());
        stafForm.setEmail(staff.getEmail());
        stafForm.setMobile(staff.getMobile());

        request.setAttribute("staffId", staff.getEmployeeId(), WebRequest.SCOPE_REQUEST);
        return "/editEmployee";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String updateEmployee(@ModelAttribute StafForm stafForm) {
        String response = null;


        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        Staff staff = staffService.findByEmployeeId(stafForm.getEmployeeId());
        staff.setId(staff.getId());
        staff.setFullName(stafForm.getFullName());
        staff.setEmail(stafForm.getEmail());
        staff.setMobile(stafForm.getMobile());

        staffService.create(staff);
        response = "Update Successful !\nGo Home to View Updated Data";
        
        return response;
    }
}
