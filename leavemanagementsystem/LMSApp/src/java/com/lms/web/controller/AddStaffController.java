/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.AppUser;
import com.lms.domain.sub.Department;
import com.lms.domain.sub.Staff;
import com.lms.service.AppMailService;
import com.lms.service.AppUserService;
import com.lms.service.DepartmentService;
import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import com.lms.utils.ioc.PasswordGenarator;
import com.lms.web.forms.StafForm;
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
@RequestMapping("/addStaff")
public class AddStaffController {

    private static Logger LOG = Logger.getLogger(AddStaffController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showAddStaffForm(@ModelAttribute StafForm stafForm, WebRequest request) {
        DepartmentService departmentService = (DepartmentService) AppContext.APPCONTEXT.getBean(ContextIdNames.DEPARTMENT_SERVICE);
        List<Department> departmentList = departmentService.getAll();
        request.setAttribute("departmentList", departmentList, WebRequest.SCOPE_SESSION);
        return "/addStaff";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveStaff(@ModelAttribute StafForm stafForm, WebRequest request) {
        String response = null;

        Staff staff = (Staff) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF);
        staff.setEmployeeId(stafForm.getEmployeeId());
        staff.setDepartmentName(stafForm.getDepartmentName());
        staff.setFullName(stafForm.getFullName());
        staff.setDateOfBirth(stafForm.getDateOfBirth());
        staff.setGender(stafForm.getGender());
        staff.setEmail(stafForm.getEmail());
        staff.setMobile(stafForm.getMobile());
        staff.setCreatedBy(1);
        staff.setCreatedOn(new java.util.Date());
        staff.setModifiedOn(new java.util.Date());
        staff.setModifiedBy(1);
        staff.setActive(1);

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        staffService.create(staff);

        AppUser appUser = (AppUser) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER);
        appUser.setUserName(staff.getEmployeeId());
        appUser.setPassword(PasswordGenarator.genaratePassword());
        appUser.setUserRole("employee");
        appUser.setCreatedBy(1);
        appUser.setCreatedOn(new java.util.Date());
        appUser.setModifiedOn(new java.util.Date());
        appUser.setModifiedBy(1);
        appUser.setActive(1);


        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        appUserService.create(appUser);


        try {


            AppMailService appMailService = (AppMailService) AppContext.APPCONTEXT.getBean("appMailService");
            appMailService.sendMail(appUser, staff);

        } catch (Exception exception) {
            response = "Staff Registration Completed\nUnable to Sent mail to Employee";
            LOG.debug("AddStaffController", exception);
            return response;

        }
        LOG.debug(stafForm);
//        GsmWrite gsmWrite = new GsmWrite();
//        gsmWrite.write("91" + staff.getMobileNumber(), "Welcome "+staff.getFullName()+" to LMS.\nLogin to LMS using your Employee ID :" + staff.getEmployeeId() + " and the Password : " + PasswordGenarator.genaratePassword());



        response = "Registration Completed !";


        return response;
    }
}
