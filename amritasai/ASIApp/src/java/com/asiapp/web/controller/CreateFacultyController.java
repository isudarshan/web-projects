/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.Faculty;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.FacultyForm;
import java.util.List;
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
@RequestMapping("/faculty")
public class CreateFacultyController {

    @RequestMapping(method = RequestMethod.GET)
    public String showRegisterFacultyForm(@ModelAttribute FacultyForm facultyForm, WebRequest request) {
        List<Department> departments = ServiceUtils.getDepartmentService().getAll();
        request.setAttribute("departments", departments, WebRequest.SCOPE_SESSION);

        return "/createFaculty";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String createFacultyForm(@ModelAttribute FacultyForm facultyForm) {
        
        String facultyName = facultyForm.getFacultyName();
        String departmentName = facultyForm.getDepartmentName();        
        String email = facultyForm.getEmail();
        String mobile = facultyForm.getMobile();

        String response = null;

        if (facultyName == null || facultyName.length() == 0 || facultyName.equals("Faculty Name")) {
            response = "Faculty Name is required !";
            return response;
        }

        if (departmentName == null || departmentName.length() == 0 || departmentName.equals("Department")) {
            response = "Department Name is required !";
            return response;
        }

        Department department = ServiceUtils.getDepartmentService().findByDepartmentName(departmentName);
        if(department == null) {
            response = "Invalid Department !";
            return response;
        }

        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyName);
        faculty.setDepartmentName(departmentName);
        faculty.setDepartmentCode(department.getDepartmentCode());
        faculty.setEmail(email);
        faculty.setMobile(mobile);

        ServiceUtils.getFacultyService().create(faculty);
        return "Faculty Created !";
    }
}
