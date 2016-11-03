/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;
import com.lms.domain.sub.StaffLeave;
import com.lms.utils.ioc.AppContext;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/approvedList")
public class ApprovedListController {

    @RequestMapping(method = RequestMethod.GET)
    public String showApprovedList(WebRequest request) {

        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        List<StaffLeave> staffLeaveList = leaveService.getAll();
        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        Map<String, String> map = new HashMap<String, String>();

        for (StaffLeave staffLeave : staffLeaveList) {
            map.put(staffLeave.getEmployeeId(), staffService.findByEmployeeId(staffLeave.getEmployeeId()).getFullName());
        }
        request.setAttribute("staffLeaveList", staffLeaveList, WebRequest.SCOPE_SESSION);
        request.setAttribute("map", map, WebRequest.SCOPE_SESSION);

        return "/approvedList";
    }
}
