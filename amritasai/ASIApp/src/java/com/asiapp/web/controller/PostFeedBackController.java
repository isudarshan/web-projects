/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.FacultyMap;
import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import com.asiapp.utils.service.ServiceUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/postFeedBack")
public class PostFeedBackController {

    private static Logger LOG = Logger.getLogger(PostFeedBackController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String showFeedbackForm(WebRequest request) {
        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);
        Student student = (Student) request.getAttribute("student", WebRequest.SCOPE_SESSION);

        List<Subject> subjectList = (List<Subject>) request.getAttribute("subjectList", WebRequest.SCOPE_SESSION);
        Map<String, String> map = new HashMap<String, String>();
        
        for(Subject subject : subjectList) {
            FacultyMap facultyMap = ServiceUtils.getFacultyMapService().findFacultyBySubject(subject.getSubjectName());
            map.put(facultyMap.getSubjectName(), facultyMap.getFacultyName());
        }
        LOG.debug("Subject List ==========="+subjectList);

        LOG.debug("Map Values : "+map.values());

        request.setAttribute("map", map, WebRequest.SCOPE_SESSION);

        if (appUser != null) {
            request.setAttribute("student", student, WebRequest.SCOPE_SESSION);
            return "/postFeedBack";
        } else {
            return "/home";
        }



    }
}
