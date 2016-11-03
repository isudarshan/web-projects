/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Branch;
import com.dmsapp.domain.sub.Master;
import com.dmsapp.service.BranchService;
import com.dmsapp.service.MasterService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.HomeForm;
import com.dmsapp.web.forms.InternalForm;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/marksHome")
public class MarksHomeController {


    // TO Do for Attendance and Assignment Marks
    // Jasper Update for Attendance and Assignment
    // Update Spring Controller, for the Session
    private Logger LOG = Logger.getLogger(MarksHomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showMarksHome(@ModelAttribute HomeForm homeForm, Model model, WebRequest request) {
        List<Branch> branchList = null;
        try {
            BranchService branchService = ServiceUtils.getBranchService();
            branchList = branchService.getAll();

        } catch (Exception exception) {
            LOG.warn("MarksHomeController", exception);
        }
        model.addAttribute(new HomeForm());
        LOG.debug("Branch List : " + branchList);
        request.setAttribute("branchList", branchList, WebRequest.SCOPE_SESSION);
        return "/marksHome";
    }

    @RequestMapping(method = RequestMethod.GET, params = {"year", "branch", "semValue"})
    @ResponseBody
    public String getPapaers(@ModelAttribute HomeForm homeForm, @RequestParam String year, String branch, String semValue) {

        LOG.debug("Params ================" + year + " " + branch + " " + semValue);
        String branchName = null;
        if ("1".equalsIgnoreCase(branch)) {
            branchName = "BA";
        } else if ("2".equalsIgnoreCase(branch)) {
            branchName = "BCOM(GEN)";
        } else if ("3".equalsIgnoreCase(branch)) {
            branchName = "BCOM(CS)";
        } else if ("4".equalsIgnoreCase(branch)) {
            branchName = "BSC(MPC)";
        } else if ("5".equalsIgnoreCase(branch)) {
            branchName = "BSC(MSCS)";
        } else if ("6".equalsIgnoreCase(branch)) {
            branchName = "BSC(MPCS)";
        } else if ("7".equalsIgnoreCase(branch)) {
            branchName = "BSC(MECS)";
        } else if ("8".equalsIgnoreCase(branch)) {
            branchName = "BSC(MSCA)";
        } else if ("9".equalsIgnoreCase(branch)) {
            branchName = "BSC(FMC)";
        } else if ("10".equalsIgnoreCase(branch)) {
            branchName = "BSC(FMB)";
        } else if ("11".equalsIgnoreCase(branch)) {
            branchName = "BSC(BZC)";
        } else {
            branchName = "Invalid Branch";
        }

        List<Master> masterList = null;
        JSONArray array = new JSONArray();
        try {
            MasterService masterService = ServiceUtils.getMasterService();
            masterList = masterService.findBy(year, branchName, semValue);
            Iterator<Master> iteratorMaster = masterList.iterator();
            LOG.debug("Total Number of Papers" + masterList.size() + "\n");
            LOG.debug("YEAR\tBRANCH\tSEM\tPAPER\n");
            LOG.debug("==================================================\n\n");
            while (iteratorMaster.hasNext()) {

                Master master = iteratorMaster.next();
                LOG.debug(master.getYear() + "\t" + master.getBranch() + "\t" + master.getSemister() + "\t" + master.getPaper());
                array.put(master.getPaper());

            }
        } catch (Exception exception) {
            LOG.warn("MarksController", exception);
        }

        LOG.debug(array);

        return array.toString();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showInternalMarksHome(@ModelAttribute InternalForm internalForm, HomeForm homeForm, WebRequest request) {
        LOG.debug(homeForm.getYear() + " " + homeForm.getBranch() + " " + homeForm.getSemister() + " " + homeForm.getSemister());

        String branchName = null;
       if ("1".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BA";
        } else if ("2".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BCOM(GEN)";
        } else if ("3".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BCOM(CS)";
        } else if ("4".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MPC)";
        } else if ("5".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MSCS)";
        } else if ("6".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MPCS)";
        } else if ("7".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MECS)";
        } else if ("8".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MSCA)";
        } else if ("9".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(FMC)";
        } else if ("10".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(FMB)";
        } else if ("11".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(BZC)";
        } else {
            branchName = "Invalid Branch";
        }

        Master master = new Master();
        master.setYear(homeForm.getYear());
        master.setBranch(branchName);
        master.setSemister(homeForm.getSemister());
        master.setPaper(homeForm.getPaper());

        LOG.debug("Master Object :" + master);
        LOG.debug("Paper : " + master.getPaper());
        request.setAttribute("master", master, WebRequest.SCOPE_SESSION);
        return "/postInternal";
    }
}
