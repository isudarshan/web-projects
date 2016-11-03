/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Branch;
import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.domain.sub.UpdateObject;
import com.dmsapp.service.BranchService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.HomeForm;
import com.dmsapp.web.forms.SearchForm;
import com.dmsapp.web.forms.UpdateForm;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/editMarks")
public class DoEditController {

    private static Logger LOG = Logger.getLogger(DoEditController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showEditForm(@ModelAttribute HomeForm homeForm, SearchForm searchForm, Model model, WebRequest request) {
        LOG.debug("Paper Code : " + homeForm.getPapaerCode());
        List<Branch> branchList = null;
        try {
            BranchService branchService = ServiceUtils.getBranchService();
            branchList = branchService.getAll();

        } catch (Exception exception) {
            LOG.warn("MarksEditController", exception);
        }
        model.addAttribute(new HomeForm());
        LOG.debug("Branch List : " + branchList);
        request.setAttribute("branchList", branchList, WebRequest.SCOPE_SESSION);

        return "/editMarks";


    }

    @RequestMapping(method = RequestMethod.POST)
    public String displayStudent(@ModelAttribute SearchForm searchForm, UpdateForm updateForm, WebRequest request) {
        try {

            String studentId = searchForm.getStudentId().trim();

            if(studentId == null || studentId.length() == 0){
                request.setAttribute("msg", "Student Registration Number is required !", WebRequest.SCOPE_REQUEST);
                return "/editMarks";
            }

            String branchName = null;
            if ("1".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BA";
            } else if ("2".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BCOM(GEN)";
            } else if ("3".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BCOM(CS)";
            } else if ("4".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(MPC)";
            } else if ("5".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(MSCS)";
            } else if ("6".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(MPCS)".trim();
            } else if ("7".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(MECS)";
            } else if ("8".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(MSCA)";
            } else if ("9".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(FMC)";
            } else if ("10".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(FMB)";
            } else if ("11".equalsIgnoreCase(searchForm.getBranch())) {
                branchName = "BSC(BZC)";
            } else {
                branchName = "Invalid Branch";
            }

            LOG.debug("Branch Name : "+branchName);
            MarksMaster marksMaster = ServiceUtils.getUpdateMarksService().findByStudentId(searchForm.getStudentId().trim(), branchName.trim(), searchForm.getYear().trim(), searchForm.getSemister().trim(), searchForm.getPaper().trim());

            LOG.debug(marksMaster);

            if(marksMaster == null) {
                LOG.debug("In UpdateObject Null =====================");
                request.setAttribute("msg", "Student Record Not Found / Marks are Not Posted for this Request.", WebRequest.SCOPE_REQUEST);
                return "/editMarks";
            }
            LOG.debug(marksMaster);

            request.setAttribute("updateObject", marksMaster, WebRequest.SCOPE_SESSION);

        } catch (Exception exception) {
            LOG.debug("MarksEditController", exception);
        }
        return "/updateMarks";
    }
}
