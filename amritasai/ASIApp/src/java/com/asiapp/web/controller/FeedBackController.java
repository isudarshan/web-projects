/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.FacultyMap;
import com.asiapp.domain.sub.FeedBack;
import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.FeedBackForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/feedback")
public class FeedBackController {

    private static Logger LOG = Logger.getLogger(FeedBackController.class);

    @RequestMapping(method = RequestMethod.GET, params = {"subjectName"})
    public String showFeedbackForm(@ModelAttribute FeedBackForm feedBackForm, @RequestParam String subjectName, WebRequest request) {
        Student student = (Student) request.getAttribute("student", WebRequest.SCOPE_SESSION);
        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);

        LOG.debug(feedBackForm);
        FacultyMap facultyMap = ServiceUtils.getFacultyMapService().findFacultyBySubject(subjectName);
        LOG.debug("Faculty Subject & name : " + facultyMap.getSubjectName() + " " + facultyMap.getFacultyName());

         FeedBack feedBackObj = ServiceUtils.getFeedbackService().checkForFeedBack(student.getStudentId(), student.getDepartmentName(), student.getYear(), student.getSemister(), subjectName);
        if (feedBackObj != null) {
            LOG.debug("FeedBack Posted for this Subject");
            request.setAttribute("msg", "FeedBack Already Given For the Subject !", WebRequest.SCOPE_REQUEST);
            return "/studentHome";
        }

        request.setAttribute("facultyMap", facultyMap, WebRequest.SCOPE_SESSION);

        return "/feedback";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postFeedback(@ModelAttribute FeedBackForm feedBackForm, WebRequest request) {

       

        String[] pun = feedBackForm.getPun();
        String[] comm = feedBackForm.getComm();
        String[] cls = feedBackForm.getCls();
        String[] dbts = feedBackForm.getDbts();
        String[] subd = feedBackForm.getSubd();
        String[] busg = feedBackForm.getBusg();

        if(pun == null || comm == null || cls == null || dbts == null || subd == null || busg == null) {
            request.setAttribute("msg", "You Must Select All the Parameters to Give FeedBack", WebRequest.SCOPE_REQUEST);
            return "feedback";
        }

        LOG.debug(feedBackForm);

        LOG.debug(pun[0]);
        LOG.debug(comm[0]);
        LOG.debug(cls[0]);
        LOG.debug(dbts[0]);
        LOG.debug(subd[0]);
        LOG.debug(busg[0]);

        String totalFeedBackMarks = String.valueOf(Integer.parseInt(pun[0]) + Integer.parseInt(comm[0]) + Integer.parseInt(cls[0]) + Integer.parseInt(dbts[0]) + Integer.parseInt(subd[0]) + Integer.parseInt(busg[0]));

        Department department = ServiceUtils.getDepartmentService().findByDepartmentName(feedBackForm.getDepartmentName());
        Subject subject = ServiceUtils.getSubjectService().findBySubjectName(feedBackForm.getSubName());


        FeedBack feedBack = new FeedBack();
        feedBack.setDepartmentName(feedBackForm.getDepartmentName());
        feedBack.setSubjectName(feedBackForm.getSubName());
        feedBack.setYear(feedBackForm.getYear());
        feedBack.setSemister(feedBackForm.getSemister());
        feedBack.setFacultyName(feedBackForm.getFacultyName());
        feedBack.setStudentId(feedBackForm.getStudentId());
        feedBack.setFeedBackTotal(totalFeedBackMarks);
        feedBack.setDepartmentCode(department.getDepartmentCode());
        feedBack.setSubjectCode(subject.getSubjectCode());
        feedBack.setActive(1);

        ServiceUtils.getFeedbackService().create(feedBack);
        request.setAttribute("successMsg", "Feedback Posted for the Subject " + feedBack.getSubjectName(), WebRequest.SCOPE_REQUEST);

        return "/studentHome";
    }
}
