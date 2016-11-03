/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.Remarks;
import com.lms.domain.sub.StaffLeave;
import com.lms.domain.sub.Staff;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import com.lms.service.RemarksService;
import com.lms.utils.ioc.AppContext;
import com.lms.utils.ioc.GsmWrite;
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
@RequestMapping("/approve")
public class ApproveLeaveController {

    private static Logger LOG = Logger.getLogger(ApproveLeaveController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String approveLeave(String employeeId, String from, String to, WebRequest request) {

        LOG.debug("In Approve Controller================");
        LOG.debug("FROM : " + from + "TO : " + to);
        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        List<StaffLeave> staffLeaveList = leaveService.findEmployees(employeeId);
        Staff staff = staffService.findByEmployeeId(employeeId);

        LOG.debug("Staff Leave Object : " + staffLeaveList);
        //LOG.debug("Staff Object : "+staff);
        RemarksService remarksService = (RemarksService) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS_SERVICE);


        for (StaffLeave sl : staffLeaveList) {
            if (sl.getEmployeeId().equals(employeeId) && sl.getLeaveStart().equals(from) && sl.getLeaveEnd().equals(to)) {
                Remarks remarks = (Remarks) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS);
                remarks.setEmployeeId(staff.getEmployeeId());
                remarks.setRemarks("Leave Approved");
                remarks.setStatus("Approved");
                remarksService.create(remarks);
                sl.setId(sl.getId());
                sl.setActive(0);

                leaveService.create(sl);
            }
        }

        staffLeaveList = leaveService.getAll();
        Map<String, String> map = new HashMap<String, String>();

        for (StaffLeave staffLeave : staffLeaveList) {
            map.put(staffLeave.getEmployeeId(), staffService.findByEmployeeId(staffLeave.getEmployeeId()).getFullName());
        }
        request.setAttribute("staffLeaveList", staffLeaveList, WebRequest.SCOPE_SESSION);
        request.setAttribute("map", map, WebRequest.SCOPE_SESSION);






        // for GSM

        for (StaffLeave sl : staffLeaveList) {
            if (sl.getEmployeeId().equals(employeeId) && sl.getLeaveStart().equals(from) && sl.getLeaveEnd().equals(to)) {
                GsmWrite gsmWrite = new GsmWrite();
                try {
                    gsmWrite.doIt(staff.getMobile(), "Your Leave from "+sl.getLeaveStart()+" "+sl.getLeaveEnd()+"is Approved !, Have a Nice Day !");
                } catch (Exception exception) {
                    LOG.debug(exception);
                }
            }
        }


        // For Mail

        /*AppMailService appMailService = (AppMailService) AppContext.APPCONTEXT.getBean("appMailService");
        for (StaffLeave sl : staffLeaveList) {
            if (sl.getEmployeeId().equals(employeeId) && sl.getLeaveStart().equals(from) && sl.getLeaveEnd().equals(to)) {

                try {
                    appMailService.sendApproveMail(sl, staff);

                } catch (Exception exception) {
                    LOG.debug(exception);
                }
            }
        }*/






        //gsmWrite.write("91"+staff.getMobile(), "Your Leave is Approved !");

        request.setAttribute("msg", "Process Completed !", WebRequest.SCOPE_REQUEST);
        return "/leaveView";
    }
}
