/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import com.asiapp.service.AppMailService;
import com.asiapp.utils.service.AppContext;
import com.asiapp.utils.service.PasswordGenarator;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.StudentForm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/registerStudent")
public class RegisterStudentController {

    private Logger LOG = Logger.getLogger(RegisterStudentController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showRegisterStudentForm(@ModelAttribute StudentForm studentForm, WebRequest request) {
        List<Department> departments = ServiceUtils.getDepartmentService().getAll();
        request.setAttribute("departments", departments, WebRequest.SCOPE_SESSION);

        List<Subject> subjects = ServiceUtils.getSubjectService().getAll();
        request.setAttribute("subjects", subjects, WebRequest.SCOPE_SESSION);


        return "/registerStudent";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postStudent(@ModelAttribute StudentForm studentForm, HttpServletRequest request) {
        String response = null;

        String departmentName = studentForm.getDepartmentName();
        String subjectName = studentForm.getSubject();
        String year = studentForm.getYear();
        String semister = studentForm.getSemister();

        if (departmentName == null || departmentName.length() == 0 || departmentName.equals("Department")) {
            response = "Department Name is Required !";
            return response;
        }

        if (year == null || year.length() == 0 || year.equals("Select Year")) {
            response = "Year is Required !";
            return response;
        }
        if (semister == null || semister.length() == 0 || semister.equals("Select Semister")) {
            response = "Semister is Required !";
            return response;
        }

//        if (subjectName == null || subjectName.length() == 0 || subjectName.equals("Select Subject")) {
//            response = "Subject Name is Required !";
//            return response;
//        }


        String test = studentForm.getSubject();

        ArrayList<String> items = new ArrayList<String>(Arrays.asList(test.split(",")));
        String subject = items.get(0);
        String mixedString = items.get(items.size() - 1);
        String studentId = mixedString.substring(10);

        

        Department department = ServiceUtils.getDepartmentService().findByDepartmentName(studentForm.getDepartmentName());

        if (department == null) {
            response = "Invalid Department !";
            return response;
        }

//        Subject subjectObject = ServiceUtils.getSubjectService().findBySubjectName(subject);
//
//        if (subjectObject == null) {
//            response = "Invalid Subject !";
//            return response;
//        }
//
        Student studentObject = ServiceUtils.getStudentService().findByStudentId(studentId);
        AppUser appUserObject = ServiceUtils.getAppUserService().findByUserName(studentId);


        if (studentObject != null || appUserObject != null) {
            response = "Student Already Registered with this Number !";
            LOG.debug(response);
            return response;
        }

        Student student = new Student();
        student.setStudentId(studentId);
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setEmail(studentForm.getEmail());
        student.setMobile(studentForm.getMobile());
        student.setAddress(studentForm.getAddress());
        student.setDepartmentName(studentForm.getDepartmentName());
        student.setDepartmentCode(department.getDepartmentCode());
        student.setSubjectName(subject);
        //student.setSubjectCode(subjectObject.getSubjectCode());
        student.setYear(studentForm.getYear());
        student.setSemister(studentForm.getSemister());
        student.setCreatedBy(1);
        student.setCreatedOn(new java.util.Date());
        student.setModifiedBy(1);
        student.setModifiedOn(new java.util.Date());
        student.setActive(1);

        AppUser appUser = new AppUser();
        appUser.setUserName(student.getStudentId());
        appUser.setPassword(PasswordGenarator.genaratePassword());
        appUser.setUserRole("student");
        appUser.setCreatedBy(1);
        appUser.setCreatedOn(new java.util.Date());
        appUser.setModifiedBy(1);
        appUser.setModifiedOn(new java.util.Date());
        appUser.setActive(1);

        ServiceUtils.getAppUserService().create(appUser);
        ServiceUtils.getStudentService().create(student);
        response = "Registration Completed !";
        try {


            AppMailService appMailService = (AppMailService) AppContext.APPCONTEXT.getBean("appMailService");
            appMailService.sendMail(student, appUser);

        } catch (Exception exception) {
            response = "Registration Completed\nUnable to Sent mail to Student";
            LOG.debug("ResgisterStudentController", exception);
            return response;

        }


        LOG.debug("Student : " + student);
        LOG.debug("AppUser : " + appUser);

        return response;
    }
}
