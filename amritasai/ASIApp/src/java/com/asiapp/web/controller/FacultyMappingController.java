/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.Faculty;
import com.asiapp.domain.sub.FacultyMap;
import com.asiapp.domain.sub.Subject;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.FacultyMapForm;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/facultyMap")
public class FacultyMappingController {
    private static Logger LOG = Logger.getLogger(FacultyMappingController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String showMapPage(@ModelAttribute FacultyMapForm facultyMapForm, WebRequest request) {
        List<Department> departments = ServiceUtils.getDepartmentService().getAll();
        request.setAttribute("departments", departments, WebRequest.SCOPE_SESSION);

//        List<Subject> subjects = ServiceUtils.getSubjectService().getAll();
//        request.setAttribute("subjects", subjects, WebRequest.SCOPE_SESSION);

        List<Faculty> faculties = ServiceUtils.getFacultyService().getAll();
        request.setAttribute("faculties", faculties, WebRequest.SCOPE_SESSION);

        return "/facultyMap";
    }


    @RequestMapping(method = RequestMethod.GET, params = {"departmentName", "year", "semValue"})
    @ResponseBody
    public String getSubjectForDepartment(@ModelAttribute FacultyMapForm facultyMapForm, @RequestParam String departmentName, String year, String semValue) {
        LOG.debug("=============="+departmentName+" ======"+year+"============"+semValue);


        List<Subject> subjectList = ServiceUtils.getSubjectService().find(departmentName, year, semValue);
        LOG.debug(subjectList);
        JSONArray array = new JSONArray();
        Iterator<Subject> iterator = subjectList.iterator();
        while (iterator.hasNext()) {

                Subject subject = iterator.next();
                
                array.put(subject.getSubjectName());

            }

        return array.toString();
    }

    @RequestMapping(method = RequestMethod.GET, params={"departmentName", "year", "semValue","subject"})
    @ResponseBody
    public String getFacultyName(@ModelAttribute FacultyMapForm facultyMapForm, @RequestParam String departmentName, String year, String semValue, String subject) {
        FacultyMap facultyMap = ServiceUtils.getFacultyMapService().find(departmentName, year, semValue, subject);
        return facultyMap.getFacultyName();
       
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postFacultyMap(@ModelAttribute FacultyMapForm facultyMapForm) {
        String response = null;

        String departmentName = facultyMapForm.getDepartmentName();
        String subjectName = facultyMapForm.getSubject();
        String year = facultyMapForm.getYear();
        String semister = facultyMapForm.getSemister();
        String facultyName = facultyMapForm.getFacultyName();

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

        if (subjectName == null || subjectName.length() == 0 || subjectName.equals("Select Subject")) {
            response = "Subject Name is Required !";
            return response;
        }

        if (facultyName == null || facultyName.length() == 0 || facultyName.equals("Select Faculty Name")) {
            response = "Faculty Name is Required !";
            return response;
        }

        Department department = ServiceUtils.getDepartmentService().findByDepartmentName(departmentName);

        if (department == null) {
            response = "Invalid Department !";
            return response;
        }

        Subject subject = ServiceUtils.getSubjectService().findBySubjectName(subjectName);

        if (subject == null) {
            response = "Invalid Subject !";
            return response;
        }

        FacultyMap facultyMap = new FacultyMap();
        facultyMap.setDepartmentName(departmentName);
        facultyMap.setDepartmentCode(department.getDepartmentCode());
        facultyMap.setSubjectName(subjectName);
        facultyMap.setSubjectCode(subject.getSubjectCode());
        facultyMap.setYear(year);
        facultyMap.setSemister(semister);
        facultyMap.setFacultyName(facultyName);

        ServiceUtils.getFacultyMapService().create(facultyMap);

        return "Faculty Mapping Completed !";
    }
}
