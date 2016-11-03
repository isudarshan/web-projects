/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.web.controller;

import com.asiapp.domain.sub.Department;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.DepartmentForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/createDept")
public class CreateDepartmentController {

    @RequestMapping(method = RequestMethod.GET)
    public String showCreateDeptHome(@ModelAttribute DepartmentForm departmentForm) {
        return"/createDept";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String createDepartment(@ModelAttribute DepartmentForm departmentForm) {

        String departmentName = departmentForm.getDepartmentName();
        String departmentCode = departmentForm.getDepartmentCode();
        String response= null;
        
        if(departmentName == null || departmentName.length() == 0 || "Department Name".equalsIgnoreCase(departmentForm.getDepartmentName())) {
            response =  "Department Name required !";           
            return response;
        }

        if(departmentCode == null || departmentCode.length() == 0 || "Department Code".equalsIgnoreCase(departmentForm.getDepartmentCode())) {
            response = "Department Code is Required !";            
            return response;
        }

        

        Department department = new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentCode(departmentCode);
        ServiceUtils.getDepartmentService().create(department);
        
        return "Department Created !";
    }
}
