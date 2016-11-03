package com.lms.web.controller;

import com.lms.context.id.names.ContextIdNames;

import com.lms.domain.sub.Bal;
import com.lms.domain.sub.Staff;
import com.lms.domain.sub.StaffLeave;
import com.lms.service.BalService;
import com.lms.service.LeaveService;
import com.lms.service.StaffService;
import com.lms.utils.ioc.AppContext;
import com.lms.web.forms.LeaveForm;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/leave")
public class ApplyLeaveController {

    private static Logger LOG = Logger.getLogger(ApplyLeaveController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showLeaveForm(@ModelAttribute LeaveForm leaveForm, WebRequest request) {

        return "/leave";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String applyLeave(@ModelAttribute LeaveForm leaveForm) {

        String response = null;

        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        int diffInDays = 0;
        try {

            LOG.debug(leaveForm.getFromDate());
            Date fromDate = simpleDateFormat.parse(leaveForm.getFromDate());
            Date toDate = simpleDateFormat.parse(leaveForm.getToDate());

            LOG.debug("From Date : \n"+fromDate);
            LOG.debug("To Date : \n"+toDate);
            
            diffInDays = (int) ((fromDate.getTime() - toDate.getTime()) / DAY_IN_MILLIS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StaffService staffService = (StaffService) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_SERVICE);
        LeaveService leaveService = (LeaveService) AppContext.APPCONTEXT.getBean(ContextIdNames.LEAVE_SERVICE);

        Staff staff = staffService.findByEmployeeId(leaveForm.getEmployeeId());

        if (staff.getGender().equalsIgnoreCase("F")) {
        } else {

            if (diffInDays > 4) {
                response = "You Must Apply Only Four Days of Leave in Current Month !";
                return response;
            }
        }

        LOG.debug("Number of Days Applied for Leaves : " + diffInDays);
        LOG.debug(leaveForm);



        //StaffLeave leave = (StaffLeave) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_LEAVE);

        StaffLeave leave = leaveService.findByEmployeeId(leaveForm.getEmployeeId());
        BalService balService = (BalService) AppContext.APPCONTEXT.getBean(ContextIdNames.BAL_SERVICE);
        Bal existBal = balService.findByEmployeeId(leaveForm.getEmployeeId());

        if(leave == null) {

        }





        int existingCount = 0;

        if (existBal == null) {
            leave = (StaffLeave) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_LEAVE);
            int totalCount = diffInDays + existingCount;
            leave.setLeaveCount(String.valueOf(totalCount));

            existBal = (Bal) AppContext.APPCONTEXT.getBean(ContextIdNames.BAL);

            existBal.setEmployeeId(leaveForm.getEmployeeId());
            existBal.setTotal(String.valueOf(totalCount));
            existBal.setCreatedOn(new java.util.Date());
            balService.create(existBal);
        } else {

            existingCount = Integer.parseInt(existBal.getTotal());



            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();

            calendar1.setTime(existBal.getCreatedOn());

            LOG.debug("DB Time : " + calendar1.getTime());

            LOG.debug("Current Month : " + calendar.get(Calendar.MONTH) + " DB Month : " + calendar1.get(Calendar.MONTH));

            if (calendar.get(Calendar.MONTH) == calendar1.get(Calendar.MONTH)) {
                existingCount = existingCount + diffInDays;

                if (existingCount > 4) {
                    LOG.debug("No More Leaves are Availbale for this Month !");
                    response = "No More Leaves are Availbale for this Month !";
                    return response;
                }
            }else {
                LOG.debug("Next Month========================");
                existingCount = existingCount + diffInDays;
            }

            existBal.setId(existBal.getId());
            existBal.setEmployeeId(leaveForm.getEmployeeId());
            existBal.setTotal(String.valueOf(existingCount));
            existBal.setCreatedOn(new java.util.Date());
            balService.create(existBal);

        }


        leave = (StaffLeave) AppContext.APPCONTEXT.getBean(ContextIdNames.STAFF_LEAVE);
        leave.setEmployeeId(leaveForm.getEmployeeId());
        leave.setLeaveStart(leaveForm.getFromDate());
        leave.setLeaveEnd(leaveForm.getToDate());
        leave.setType(leaveForm.getLeaveType());
        leave.setLeaveCount(String.valueOf(diffInDays));
        leave.setReasons(leaveForm.getReasonsforLeave());
        leave.setAddress(leaveForm.getContactAddress());
        leave.setMobile(leaveForm.getMobile());
        leave.setCreatedOn(new java.util.Date());
        leave.setCreatedBy(1);
        leave.setModifiedOn(new java.util.Date());
        leave.setModifiedBy(1);
        leave.setActive(1);


        leaveService.create(leave);


        response = "Leave Application is sent to Admin !";

        return response;
    }
}
