/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lms.domain.sub.Bal;
import com.lms.service.BalService;
import com.lms.utils.ioc.AppContext;
import com.lms.context.id.names.ContextIdNames;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/perYear")
public class BalanceLeavePerYearController {
    private static Logger LOG = Logger.getLogger(BalanceLeavePerYearController.class);

    @RequestMapping(method = RequestMethod.GET, params = {"employeeId"})
    @ResponseBody
    public String balancePerYear(@RequestParam String employeeId) {
    LOG.debug("In Controller : "+employeeId);
        String response = null;
        BalService balService = (BalService) AppContext.APPCONTEXT.getBean(ContextIdNames.BAL_SERVICE);
        Bal bal = balService.findByEmployeeId(employeeId);

        if(bal == null) {
            response = "Leaves Available for this Year : 28";
            return response;
        }
        LOG.debug("Bal Object : "+bal);
        if (Integer.parseInt(bal.getTotal()) == 28) {
            response = "No Leaves Availiable for this Month";
            return response;
        }
        int left = 28 - Integer.parseInt(bal.getTotal());
        response =  "Leaves Available for this Year : " + left;
        return response;
    }
}
