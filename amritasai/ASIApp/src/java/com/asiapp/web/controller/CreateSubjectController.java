/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.Subject;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.SubjectForm;
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
@RequestMapping("/createSubject")
public class CreateSubjectController {

    @RequestMapping(method = RequestMethod.GET)
    public String showCreateSubjectForm(@ModelAttribute SubjectForm subjectForm, WebRequest request) {

        List<Department> departments = ServiceUtils.getDepartmentService().getAll();
        request.setAttribute("departments", departments, WebRequest.SCOPE_SESSION);

        return "/createSubject";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postSubject(@ModelAttribute SubjectForm subjectForm) {
        String subjectCode = subjectForm.getSubjectCode();
        String subjectName = subjectForm.getSubjectTitle();
        String departmentName = subjectForm.getDepartmentName();
        String year = subjectForm.getYear();
        String semister = subjectForm.getSemister();

        String response = null;
        if (subjectName == null || subjectName.length() == 0 || subjectName.equals("Subject Title")) {
            response = "Subject Title is required !";
            return response;
        }

        if (subjectCode == null || subjectCode.length() == 0 || subjectCode.equals("Subject Code")) {
            response = "Subject Code is required !";
            return response;
        }

        if (departmentName == null || departmentName.length() == 0 || departmentName.equals("Department")) {
            response = "Department is required !";
            return response;
        }
        if (year == null || year.length() == 0 || year.equals("Select Year")) {
            response = "Year is required !";
            return response;
        }
        if (semister == null || semister.length() == 0 || semister.equals("Select Semister")) {
            response = "Semister is required !";
            return response;
        }

        Department department = ServiceUtils.getDepartmentService().findByDepartmentName(departmentName);

        if (department == null) {
            response = "Invalid Department !";
            return response;
        }

        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setSubjectCode(subjectCode);
        subject.setDepartmentName(departmentName);
        subject.setYear(year);
        subject.setSemister(semister);
        subject.setDepartmentCode(department.getDepartmentCode());

        ServiceUtils.getSubjectService().create(subject);

        return "Subject Created";
    }
}
