/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.StaffLeave;
import com.lms.domain.sub.Staff;
import com.lms.domain.sub.Bal;
import com.lms.service.BalService;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import com.lms.service.RemarksService;
import com.lms.utils.ioc.AppContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/cancelLeave")
public class CancelLeaveController {

    private static Logger LOG = Logger.getLogger(CancelLeaveController.class);
    @RequestMapping(method = RequestMethod.GET, params = {"employeeId", "from", "to"})
    public String cancelLeave(WebRequest request, String employeeId, String from, String to) {
        LOG.debug(employeeId+" "+from+" "+to);

         StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        List<StaffLeave> staffLeaveList = leaveService.findEmployees(employeeId);
        Staff staff = staffService.findByEmployeeId(employeeId);

        LOG.debug("Staff Leave Object : " + staffLeaveList);
        //LOG.debug("Staff Object : "+staff);
        RemarksService remarksService = (RemarksService) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS_SERVICE);
        BalService balService = (BalService) AppContext.APPCONTEXT.getBean(ContextIdNames.BAL_SERVICE);

        for (StaffLeave sl : staffLeaveList) {
            if (sl.getEmployeeId().equals(employeeId) && sl.getLeaveStart().equals(from) && sl.getLeaveEnd().equals(to)) {
                /*Remarks remarks = (Remarks) AppContext.APPCONTEXT.getBean(ContextIdNames.REMARKS);
                remarks.setEmployeeId(staff.getEmployeeId());
                remarks.setRemarks("Leave Approved");
                remarks.setStatus("Approved");
                remarksService.create(remarks);*/
//                sl.setId(sl.getId());
//                sl.setActive(0);
//
//                leaveService.create(sl);

                leaveService.delete(sl.getId());
                Bal bal = balService.findByEmployeeId(sl.getEmployeeId());

                int exist = Integer.parseInt(bal.getTotal());
                int count = Integer.parseInt(sl.getLeaveCount());
                bal.setTotal(String.valueOf(exist-count));
                bal.setId(bal.getId());
                balService.create(bal);
            }
        }





        
        staffLeaveList = leaveService.getAll();
        Map<String, String> map = new HashMap<String, String>();

        for (StaffLeave staffLeave : staffLeaveList) {
            map.put(staffLeave.getEmployeeId(), staffService.findByEmployeeId(staffLeave.getEmployeeId()).getFullName());
        }
        request.setAttribute("staffLeaveList", staffLeaveList, WebRequest.SCOPE_SESSION);
        request.setAttribute("map", map, WebRequest.SCOPE_SESSION);

        request.setAttribute("msg", "Leave Cancelled", WebRequest.SCOPE_REQUEST);

        return "/employeeHome";
    }
}
