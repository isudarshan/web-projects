/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.web.controller;
import com.lms.context.id.names.ContextIdNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import com.lms.utils.ioc.AppContext;
import com.lms.service.LeaveService;
import com.lms.domain.sub.AppUser;
import com.lms.domain.sub.StaffLeave;
import java.util.List;
/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/employeeHome")
public class EmployeeController {

    @RequestMapping(method= RequestMethod.GET)
    public String showEmployeeHome(WebRequest request) {

        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);
        AppUser appUser = (AppUser) request.getAttribute("appUser", WebRequest.SCOPE_SESSION);

        List<StaffLeave> staffLeaveList = leaveService.findEmployees(appUser.getUserName());
        request.setAttribute("staffLeaveList", staffLeaveList, WebRequest.SCOPE_SESSION);
        return "/employeeHome";
    }

}
