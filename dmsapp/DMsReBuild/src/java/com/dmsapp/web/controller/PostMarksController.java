package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.TypeOne;
import com.dmsapp.domain.sub.TypeTwo;
import com.dmsapp.service.TypeOneService;
import com.dmsapp.service.TypeTwoService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.InternalForm;
import com.dmsapp.web.forms.MarksForm;
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
@RequestMapping("/postMarks")
public class PostMarksController {

    private static Logger LOG = Logger.getLogger(PostMarksController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showPostMarksForm(@ModelAttribute MarksForm marksForm, WebRequest request) {

        InternalForm internalForm = (InternalForm) request.getAttribute("internalForm", WebRequest.SCOPE_SESSION);

        marksForm.setYear(internalForm.getYear());
        marksForm.setBranch(internalForm.getBranch());
        marksForm.setSemister(String.valueOf(internalForm.getSemister()));
        marksForm.setPaper(internalForm.getPaper());
        marksForm.setInternalType(internalForm.getInternalType());

        LOG.debug("Marks Form : " + marksForm);
        return "/postMarks";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postMarks(@ModelAttribute MarksForm marksForm) {
        String response = null;
        boolean error = false;
        boolean isAbsent = false;

        String studentId = marksForm.getStudentId().trim();
        String surName = marksForm.getSurName().trim();
        String firstName = marksForm.getFirstName().trim();
        String assMarks = marksForm.getAssignmentMarks();
        String internalMarks = marksForm.getMarks();
        String attendanceMarks = marksForm.getAttendanceMarks();
        String rating = marksForm.getRating();


        LOG.debug("Internal Marks : " + marksForm.getMarks());

        if (studentId.length() == 0 || studentId == null) {
            error = true;
        }

        /*if(surName.length() == 0 || surName == null) {
        error = true;
        }

        if(firstName.length() == 0 || firstName == null) {
        error = true;
        }*/

        if (internalMarks == null || internalMarks.length() == 0) {
            LOG.debug("No Internal Marks, Student is Absent");
            error = true;
        }

        /*if (rating == null || rating.length() == 0) {
        error = true;
        }*/

        if (error) {
            LOG.debug("All Fields are required !");
            response = "All Fields are required !";
            return response;
        }

        String type = marksForm.getInternalType();

        assMarks = marksForm.getAssignmentMarks().trim();

        LOG.debug("Assignment Marks :" + assMarks + " " + assMarks.length());

        Integer assignMentMarks = null;
        Integer interMarks = null;
        if (assMarks != null && assMarks.length() > 0) {
            LOG.debug("In Assignment");
            assignMentMarks = Integer.parseInt(assMarks);

            if (internalMarks.equalsIgnoreCase("A")) {
                isAbsent = true;
                LOG.debug("Student Absent");


            } else {
                interMarks = Integer.parseInt(internalMarks);

                if (interMarks >= 16) {
                    response = "Internal Marks Must Lessthan or Equal to 15";
                    return response;
                }

                if (assignMentMarks >= 6) {
                    response = "Assignment Marks Must Lessthan or Equal  to 5";
                    return response;
                }

            }

        }


        if (assMarks == null || assMarks.length() == 0) {
            LOG.debug("In No Assignment");
            if (internalMarks.equalsIgnoreCase("A")) {
                isAbsent = true;
                LOG.debug("Student Absent");

            } else {
                interMarks = Integer.parseInt(marksForm.getMarks());
                if (interMarks >= 21) {
                    response = "Internal Marks Must Lessthan or Equal  to 20";
                    return response;
                }
            }


        }


        TypeOneService typeOneService = ServiceUtils.getTypeOneService();
        TypeOne typeOne = typeOneService.checkStatus(marksForm.getStudentId(), marksForm.getBranch(), marksForm.getYear(), String.valueOf(marksForm.getSemister()), marksForm.getPaper());

        TypeTwoService typeTwoService = ServiceUtils.getTypeTwoService();
        TypeTwo typeTwo = typeTwoService.checkStatus(marksForm.getStudentId(), marksForm.getBranch(), marksForm.getYear(), String.valueOf(marksForm.getSemister()), marksForm.getPaper());

        if (type.equalsIgnoreCase("2")) {

            if (attendanceMarks.length() == 0 || attendanceMarks == null) {
                response = "Attendance Marks are required !";
                return response;
            }


            Attendance attendance = ServiceUtils.getAttendanceService().findById(marksForm.getYear().trim(), marksForm.getBranch().trim(), marksForm.getSemister().trim(), marksForm.getPaper().trim());

            LOG.debug("Number of Working Days : "+attendance.getNumberOfWorkingDays());

            int noW = Integer.parseInt(marksForm.getAttendanceMarks());
            int pW = Integer.parseInt(attendance.getNumberOfWorkingDays());

            LOG.debug("NOW : "+noW+" PW : "+pW);
            if(noW > pW) {
                response = "Number of Working Days are :"+pW+"\n"+"Number of Presented Days Lessthan or Equal to Number of Working Days !";
                return response;
            }
            
            if (typeTwo == null) {
                typeTwo = new TypeTwo();
                typeTwo.setYear(marksForm.getYear());
                typeTwo.setBranch(marksForm.getBranch());
                typeTwo.setSemister(Integer.parseInt(marksForm.getSemister()));
                typeTwo.setPaper(marksForm.getPaper());
                typeTwo.setInternalType(marksForm.getInternalType());
                typeTwo.setStudentId(marksForm.getStudentId());
                typeTwo.setSurName(marksForm.getSurName());
                if (isAbsent) {
                    typeTwo.setInterTwoMarks(marksForm.getMarks());
                } else {
                    typeTwo.setInterTwoMarks(String.valueOf(interMarks));
                }


                if (assMarks == null || assMarks.length() == 0) {
                    typeTwo.setAssignmentMarks("0");
                } else {
                    typeTwo.setAssignmentMarks(String.valueOf(assignMentMarks));
                    typeTwo.setActive(1);
                }

                typeTwo.setAttendanceMarks(marksForm.getAttendanceMarks());
                typeTwo.setRating(marksForm.getRating());

                typeTwoService.create(typeTwo);
                LOG.debug("This is First Post for Type 2");
                response = "Marks Posted !";
                return response;
            } else {
                response = "Marks Alredy Posted !";
                return response;
            }
        }

        if (type.equalsIgnoreCase("1")) {

            if (typeOne == null) {
                typeOne = new TypeOne();
                typeOne.setYear(marksForm.getYear());
                typeOne.setBranch(marksForm.getBranch());
                typeOne.setSemister(Integer.parseInt(marksForm.getSemister()));
                typeOne.setPaper(marksForm.getPaper());
                typeOne.setInternalType(marksForm.getInternalType());
                typeOne.setStudentId(marksForm.getStudentId());
                typeOne.setSurName(marksForm.getSurName());
                if (isAbsent) {
                    typeOne.setInterOneMarks(marksForm.getMarks());
                } else {
                    typeOne.setInterOneMarks(String.valueOf(interMarks));
                }


                if (assMarks == null || assMarks.length() == 0) {
                    LOG.debug("In Ass Marks One");
                    typeOne.setAssignmentMarks("0");
                } else {
                    typeOne.setAssignmentMarks(String.valueOf(assignMentMarks));
                    typeOne.setActive(1);
                }
                typeOne.setAttendanceMarks("0");
                typeOne.setRating(marksForm.getRating());

                typeOneService.create(typeOne);
                LOG.debug("This is First Post for Type 1");
                response = "Marks Posted";
                return response;
            } else {
                response = "Marks Alredy Posted !";
                LOG.debug("Marks Already Posted for this Type 1");
                return response;
            }
        }
        return response;
    }
}
