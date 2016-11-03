
package com.lms.web.controller;

import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import com.lms.context.id.names.ContextIdNames;
import com.lms.service.AppUserService;
import com.lms.domain.sub.Staff;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/delete")
public class DeleteEmployeeController {

    @RequestMapping(method = RequestMethod.GET, params = {"employeeId"})
    public String deleteEmployee(@RequestParam String employeeId, WebRequest request) {

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        staffService.remove(employeeId);
        AppUserService appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        appUserService.remove(employeeId);
        request.setAttribute("errMsg", "Employee Deleted !", WebRequest.SCOPE_REQUEST);

         
        List<Staff> staffList = staffService.getAll();
        request.setAttribute("staffList", staffList, WebRequest.SCOPE_SESSION);
        return "/adminHome";
    }
}
