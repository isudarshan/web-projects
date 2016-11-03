///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.dmsapp.web.controller;
//
//import com.dmsapp.domain.sub.Attendance;
//import com.dmsapp.domain.sub.TypeOne;
//import com.dmsapp.domain.sub.TypeTwo;
//import com.dmsapp.domain.sub.UpdateObject;
//import com.dmsapp.utils.service.ServiceUtils;
//import com.dmsapp.web.forms.UpdateForm;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.request.WebRequest;
//
///**
// *
// * @author Sudarsan
// */
//@Controller
//@RequestMapping("/update")
//public class UpdateMarksController {
//
//    private static Logger LOG = Logger.getLogger(UpdateMarksController.class);
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String updateMarks(@ModelAttribute UpdateForm updateForm, WebRequest request) {
//
//
//        LOG.debug("Update Form : " + updateForm);
//        LOG.debug("Branch Name From Form : " + updateForm.getBranch());
//
//        String assMarks = updateForm.getAssignmentMarks();
//        String internalMarks = updateForm.getMarks();
//        String attMarks = updateForm.getAttendanceMarks();
//        boolean error = false;
//        if (internalMarks == null || internalMarks.length() == 0) {
//            error = true;
//            LOG.debug("inter marks");
//        }
//        /*if(assMarks == null || assMarks.length() == 0) {
//        error = true;
//        LOG.debug("assmarks");
//        }
//
//
//        if(attMarks == null || attMarks.length() == 0) {
//        error = true;
//        LOG.debug("att marks");
//        }*/
//
//        if (error) {
//            request.setAttribute("msg", "All Fields are required !", WebRequest.SCOPE_REQUEST);
//            return "/updateMarks";
//        }
//
//        Integer marks = Integer.parseInt(internalMarks);
//
//        if ("1".equalsIgnoreCase(updateForm.getInternalType())) {
//
//            if (updateForm.getActive() == null) {
//
//                if (marks <= 20) {
//                    TypeOne typeOne = ServiceUtils.getTypeOneService().findById(updateForm.getId());
//                    //LOG.debug("Type One Object : " + typeOne);
//                    typeOne.setId(updateForm.getId());
//                    typeOne.setInterOneMarks(updateForm.getMarks());
//                    typeOne.setAssignmentMarks(typeOne.getAssignmentMarks());
//                    ServiceUtils.getTypeOneService().create(typeOne);
//                    UpdateObject updateObject = ServiceUtils.getUpdateMarksService().findByStudentId(updateForm.getStudentId().trim(), updateForm.getBranch().trim(), updateForm.getYear().trim(), updateForm.getSemister().trim(), updateForm.getPaper().trim(), updateForm.getInternalType().trim());
//                    request.setAttribute("updateObject", updateObject, WebRequest.SCOPE_SESSION);
//                    request.setAttribute("msgSuccess", "Marks Updated", WebRequest.SCOPE_REQUEST);
//
//                    return "/updateMarks";
//                } else {
//                    request.setAttribute("msg", "Internal Marks Must Lessthan 20", WebRequest.SCOPE_REQUEST);
//                    return "/updateMarks";
//
//                }
//            }
//
//            if (updateForm.getActive() == 1) {
//                if (marks <= 15 && (Integer.parseInt(assMarks) <= 5)) {
//                    TypeOne typeOne = ServiceUtils.getTypeOneService().findById(updateForm.getId());
//                    //LOG.debug("Type One Object : " + typeOne);
//                    typeOne.setId(updateForm.getId());
//                    typeOne.setInterOneMarks(updateForm.getMarks());
//                    typeOne.setAssignmentMarks(updateForm.getAssignmentMarks());
//                    ServiceUtils.getTypeOneService().create(typeOne);
//                    UpdateObject updateObject = ServiceUtils.getUpdateMarksService().findByStudentId(updateForm.getStudentId().trim(), updateForm.getBranch().trim(), updateForm.getYear().trim(), updateForm.getSemister().trim(), updateForm.getPaper().trim(), updateForm.getInternalType().trim());
//                    request.setAttribute("updateObject", updateObject, WebRequest.SCOPE_SESSION);
//                    request.setAttribute("msgSuccess", "Marks Updated", WebRequest.SCOPE_REQUEST);
//
//                    //LOG.debug("Update Form :"+updateForm);
//                    return "/updateMarks";
//                } else {
//                    request.setAttribute("msg", "The Summation of Internal Marks and Assignment Marks must Lessthan or Equal to 20", WebRequest.SCOPE_REQUEST);
//                    return "/updateMarks";
//                }
//            }
//        }
//
//        if ("2".equalsIgnoreCase(updateForm.getInternalType())) {
//
//            Attendance attendance = ServiceUtils.getAttendanceService().findById(updateForm.getYear().trim(), updateForm.getBranch(), updateForm.getSemister(), updateForm.getPaper());
//
//            Integer numberOfWorkingDays = Integer.parseInt(attendance.getNumberOfWorkingDays());
//            Integer updatedWorkingDays = Integer.parseInt(updateForm.getAttendanceMarks());
//
//            if (updatedWorkingDays > numberOfWorkingDays) {
//                request.setAttribute("msg", "Working Days Must Lessthan " + numberOfWorkingDays, WebRequest.SCOPE_REQUEST);
//                return "/updateMarks";
//            }
//
//            if (updateForm.getActive() == null) {
//
//                if (marks <= 20) {
//                    TypeTwo typeTwo = ServiceUtils.getTypeTwoService().findById(updateForm.getId());
//                    //LOG.debug("Type two Object : " + typeTwo);
//                    typeTwo.setId(updateForm.getId());
//                    typeTwo.setInterTwoMarks(updateForm.getMarks());
//                    typeTwo.setAssignmentMarks(typeTwo.getAssignmentMarks());
//                    typeTwo.setAttendanceMarks(updateForm.getAttendanceMarks());
//                    ServiceUtils.getTypeTwoService().create(typeTwo);
//                    UpdateObject updateObject = ServiceUtils.getUpdateMarksService().findByStudentId(updateForm.getStudentId().trim(), updateForm.getBranch().trim(), updateForm.getYear().trim(),updateForm.getSemister().trim(), updateForm.getPaper().trim(), updateForm.getInternalType().trim());
//                    request.setAttribute("updateObject", updateObject, WebRequest.SCOPE_SESSION);
//                    request.setAttribute("msgSuccess", "Marks Updated", WebRequest.SCOPE_REQUEST);
//
//                    //LOG.debug("Update Form :"+updateForm);
//                    return "/updateMarks";
//
//                } else {
//                    // Err Msg for validation (Internal Marks Should Less than 20
//                    request.setAttribute("msg", "Internal Marks Must Lessthan 20", WebRequest.SCOPE_REQUEST);
//                    return "/updateMarks";
//
//                }
//            }
//
//            if (updateForm.getActive() == 1) {
//                if (marks <= 15 && (Integer.parseInt(assMarks) <= 5)) {
//                    TypeTwo typeTwo = ServiceUtils.getTypeTwoService().findById(updateForm.getId());
//                    //LOG.debug("Type two Object : " + typeTwo);
//                    typeTwo.setId(updateForm.getId());
//                    typeTwo.setInterTwoMarks(updateForm.getMarks());
//                    typeTwo.setAssignmentMarks(updateForm.getAssignmentMarks());
//                    typeTwo.setAttendanceMarks(updateForm.getAttendanceMarks());
//                    ServiceUtils.getTypeTwoService().create(typeTwo);
//                    UpdateObject updateObject = ServiceUtils.getUpdateMarksService().findByStudentId(updateForm.getStudentId().trim(), updateForm.getBranch().trim(), updateForm.getYear().trim(),updateForm.getSemister().trim(), updateForm.getPaper().trim(), updateForm.getInternalType().trim());
//                    request.setAttribute("updateObject", updateObject, WebRequest.SCOPE_SESSION);
//                    request.setAttribute("msgSuccess", "Marks Updated", WebRequest.SCOPE_REQUEST);
//
//                    //LOG.debug("Update Form :"+updateForm);
//                    return "/updateMarks";
//                } else {
//                    request.setAttribute("msg", "The Summation of Internal Marks and Assignment Marks must Lessthan or Equal to 20", WebRequest.SCOPE_REQUEST);
//                    return "/updateMarks";
//                }
//            }
//        }
//
//        return "/updateMarks";
//
//    /*UpdateObject updateObject = ServiceUtils.getUpdateMarksService().findByStudentId(updateForm.getStudentId().trim(), updateForm.getBranch().trim(), updateForm.getYear().trim(), Integer.parseInt(updateForm.getSemister().trim()), updateForm.getPaper().trim(), updateForm.getInternalType().trim());
//
//    LOG.debug("Update Object : " + updateObject);
//    request.setAttribute("updateObject", updateObject, WebRequest.SCOPE_SESSION);
//    request.setAttribute("msgSuccess", "Marks Updated", WebRequest.SCOPE_REQUEST);
//
//    //LOG.debug("Update Form :"+updateForm);
//    return "/updateMarks";*/
//    }
//}
