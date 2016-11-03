/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.Branch;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.service.BranchService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.HomeForm;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/attendance")
public class AttendanceController {

    private static Logger LOG = Logger.getLogger(AttendanceController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showAttendanceForm(@ModelAttribute HomeForm homeForm, Model model, WebRequest request) {
        List<Branch> branchList = null;
        try {
            BranchService branchService = ServiceUtils.getBranchService();
            branchList = branchService.getAll();

        } catch (Exception exception) {
            LOG.warn("AttendanceController", exception);
        }
        model.addAttribute(new HomeForm());
        LOG.debug("Branch List : " + branchList);
        request.setAttribute("branchList", branchList, WebRequest.SCOPE_SESSION);
        return "/attendance";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String postAttendance(@ModelAttribute HomeForm homeForm) {
        String response = null;
        
        LOG.debug(homeForm);

        String branchName = null;
        if ("1".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BA";
        } else if ("2".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BCOM(GEN)";
        } else if ("3".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BCOM(CS)";
        } else if ("4".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(MPC)";
        } else if ("5".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(MSCS)";
        } else if ("6".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(MPCS)";
        } else if ("7".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(MECS)";
        } else if ("8".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(MSCA)";
        } else if ("9".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(FMC)";
        } else if ("10".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(FMB)";
        } else if ("11".equalsIgnoreCase(homeForm.getBranch().trim())) {
            branchName = "BSC(BZC)";
        } else {
            branchName = "Invalid Branch";
        }


        String numberOfWorkingDays = homeForm.getNumberOfWorkingDays();
        LOG.debug("Attendance : "+numberOfWorkingDays);
        
        if (numberOfWorkingDays == null || numberOfWorkingDays.length() == 0) {
            response = "Number of Working Days are required !";
            return response;
        }

        AttendanceService attendanceService = ServiceUtils.getAttendanceService();

        Attendance attendance = attendanceService.findById(homeForm.getYear().trim(), branchName.trim(), String.valueOf(homeForm.getSemister()).trim(), homeForm.getPaper().trim());

        if (attendance == null) {
            attendance = new Attendance();
            attendance.setYear(homeForm.getYear());
            attendance.setBranch(branchName);
            attendance.setSemister(homeForm.getSemister());
            attendance.setPaper(homeForm.getPaper());
            attendance.setNumberOfWorkingDays(homeForm.getNumberOfWorkingDays());
            attendanceService.create(attendance);
            response = "Working Days entered Successfully !";
        } else {
            LOG.debug("In Update");
            attendance.setId(attendance.getId());
            attendance.setYear(homeForm.getYear());
            attendance.setBranch(branchName);
            attendance.setSemister(homeForm.getSemister());
            attendance.setPaper(homeForm.getPaper());
            attendance.setNumberOfWorkingDays(homeForm.getNumberOfWorkingDays());
            attendanceService.create(attendance);
            response = "Working Days Update Successfully !";
        }

        return response;
    }
}
