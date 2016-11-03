/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.MarksMasterForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/doPost")
public class DoPostController {

    private static Logger LOG = Logger.getLogger(DoPostController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String doPostForm(MarksMasterForm marksMasterForm) {

        LOG.debug(marksMasterForm);

        String response = null;

        String branchName = null;
        if ("1".equalsIgnoreCase(marksMasterForm.getBranch())) {
            branchName = "BA";
        } else if ("2".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BCOM(GEN)";
        } else if ("3".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BCOM(CS)";
        } else if ("4".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(MPC)";
        } else if ("5".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(MSCS)";
        } else if ("6".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(MPCS)";
        } else if ("7".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(MECS)";
        } else if ("8".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(MSCA)";
        } else if ("9".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(FMC)";
        } else if ("10".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(FMB)";
        } else if ("11".equalsIgnoreCase(marksMasterForm.getBranch().trim())) {
            branchName = "BSC(BZC)";
        } else {
            branchName = "Invalid Branch";
        }

        MarksMaster marksMaster = new MarksMaster();
        marksMaster.setYear(marksMasterForm.getYear().trim());
        marksMaster.setBranch(branchName.trim());
        marksMaster.setSemister(marksMasterForm.getSemister());
        marksMaster.setPaper(marksMasterForm.getPaper());
        marksMaster.setStudentId(marksMasterForm.getStudentId());
        marksMaster.setInternalOne(marksMasterForm.getInternalOne());
        marksMaster.setInternalTwo(marksMasterForm.getInternalTwo());
        marksMaster.setAssignmentMarks(marksMasterForm.getAssignmentMarks());
        marksMaster.setAttendanceMarks(marksMasterForm.getAttendanceMarks());
        marksMaster.setActive(1);

        LOG.debug(marksMaster);



        MarksMaster master = ServiceUtils.getMarksMasterService().checkStatus(marksMaster.getStudentId(), marksMaster.getBranch(), marksMaster.getYear(), marksMaster.getSemister(), marksMaster.getPaper());

        if(master !=null) {
            LOG.debug("=========Marks Already Posted for this Student====");
            response = "Marks Already Posted for this Student";
            return response;
        }
        

        int internalOneMarks = 0;
        int internalTwoMarks = 0;

        int assignmentMarks = 0;
        if (marksMaster.getAssignmentMarks() != null) {
            assignmentMarks = Integer.parseInt(marksMaster.getAssignmentMarks());
        }

        // If Assignment Marks are Not Available
        if (marksMaster.getAssignmentMarks() == null) {

            if (!marksMaster.getInternalOne().equals("A")) {

                internalOneMarks = Integer.parseInt(marksMaster.getInternalOne());
                if (internalOneMarks >= 21) {
                    LOG.debug("============Internal Marks - I Must Be Less Than 20======");
                    response = "Internal Marks - I must be lessthan 20.";
                    return response;
                }
            }

            if (!marksMaster.getInternalTwo().equals("A")) {
                internalTwoMarks = Integer.parseInt(marksMaster.getInternalTwo());

                if (internalTwoMarks >= 21) {
                    LOG.debug("============Internal Marks - II Must Be Less Than 20======");
                    response = "Internal Marks - II must be lessthan 20.";
                    return response;
                }
            }
        }

        // If Assignment Marks are Available
        if (marksMaster.getAssignmentMarks() != null) {

            if (!marksMaster.getInternalOne().equals("A")) {

                internalOneMarks = Integer.parseInt(marksMaster.getInternalOne());
                if (internalOneMarks >= 16) {
                    LOG.debug("============Internal Marks - I Must Be Less Than 15======");
                    response = "Internal Marks - I must be lessthan 15.";
                    return response;
                }
            }

            // Add Else part for above If for Absentisam, if Needed

            if (!marksMaster.getInternalTwo().equals("A")) {
                internalTwoMarks = Integer.parseInt(marksMaster.getInternalTwo());
                if (internalTwoMarks >= 16) {
                    LOG.debug("============Internal Marks - II Must Be Less Than 15======");
                    response = "Internal Marks - II must be lessthan 15.";
                    return response;
                }
            }
            if (assignmentMarks >= 6) {
                LOG.debug("=============Assignment Marks Must Be Less Than 5");
                response = "Assignment Marks must be lessthan 5.";
                return response;
            }


        }


        Attendance attendance = ServiceUtils.getAttendanceService().findById(marksMaster.getYear(), marksMaster.getBranch(), marksMaster.getSemister(), marksMaster.getPaper());

        LOG.debug("====Number of Working Days : ====" + attendance.getNumberOfWorkingDays());
        int noW = Integer.parseInt(marksMaster.getAttendanceMarks());
        int pW = Integer.parseInt(attendance.getNumberOfWorkingDays());

        LOG.debug("NOW : " + noW + " PW : " + pW);
        if (noW > pW) {
            response = "Number of Working Days are :" + pW + "\n" + "Number of Presented Days Lessthan or Equal to Number of Working Days !";
            return response;
        }

        ServiceUtils.getMarksMasterService().create(marksMaster);

        response = "Marks Posted !";
        return response;
    }
}
