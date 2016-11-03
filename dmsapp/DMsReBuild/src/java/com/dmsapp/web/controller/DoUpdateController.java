/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.service.MarksMasterService;
import com.dmsapp.service.impl.MarksMasterServiceImpl;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.UpdateForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/doUpdate")
public class DoUpdateController {

    private static Logger LOG = Logger.getLogger(DoUpdateController.class);

    @RequestMapping(method = RequestMethod.POST)
    public String updateMarks(@ModelAttribute UpdateForm updateForm, WebRequest request) {


        LOG.debug(updateForm);

        LOG.debug("Update Form : " + updateForm);
        LOG.debug("Branch Name From Form : " + updateForm.getBranch());

        String assMarks = updateForm.getAssignmentMarks();
        String inter1 = updateForm.getInternalOne();
        String inter2 = updateForm.getInternalTwo();
        String attMarks = updateForm.getAttendanceMarks();
        String msg = null;

        boolean error = false;

        if (inter1 == null || inter1.length() == 0) {
            error = true;
            msg = "Internal - I Marks are required !";
            LOG.debug("inter marks");
        }

        if (inter2 == null || inter2.length() == 0) {
            msg = "Internal - II Marks are required !";
            error = true;
        }

        if (attMarks == null || attMarks.length() == 0) {
            msg = "Attendance is required !";
            error = true;
        }

        if (assMarks != null) {
            if (assMarks == null || assMarks.length() == 0) {
                msg = "Assignment Marks are required !";
                error = true;
            }
            if (Integer.parseInt(assMarks) > 6) {
                msg = "Assignment Marks must be lessthan 5.";
                error = true;
            }
        }
        if (error) {
            request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
            return "/updateMarks";
        }

        int internalOne = 0;
        int internalTwo = 0;


        MarksMaster marksMaster = ServiceUtils.getMarksMasterService().findById(updateForm.getId());

        if (assMarks != null) {

            if (inter1.equals("A")) {
                //internalOne = Integer.parseInt(inter1);

                //if (internalOne <= 15) {

                    marksMaster.setInternalOne(inter1);
                /*} else {
                    LOG.debug("In Else Part");
                    msg = "Internal Marks Must Lessthan 15";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }*/
            } else {
                internalOne = Integer.parseInt(inter1);

                if (internalOne <= 15) {
                    marksMaster.setInternalOne(inter1);
                } else {
                    msg = "Internal Marks Must Lessthan 15";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }


            }


            if (inter2.equals("A")) {
                //internalTwo = Integer.parseInt(inter2);
                //if (internalTwo <= 15) {
                    marksMaster.setInternalTwo(inter2);
                /*} else {
                    msg = "Internal Marks Must Lessthan 15";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }*/

            } else {

                internalTwo = Integer.parseInt(inter2);
                if (internalTwo <= 15) {
                    marksMaster.setInternalTwo(inter2);
                } else {
                    msg = "Internal Marks Must Lessthan 15";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }

            }

        }




        if (assMarks == null) {


            LOG.debug("Ass Marks Null ===============");
            if (inter1.equals("A")) {
                //internalOne = Integer.parseInt(inter1);

                //if (internalOne <= 20) {

                    marksMaster.setInternalOne(inter1);
                /*} else {
                    LOG.debug("In Else Part");
                    msg = "Internal Marks Must Lessthan 20";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }*/
            } else {
                internalOne = Integer.parseInt(inter1);

                if (internalOne <= 20) {
                    marksMaster.setInternalOne(inter1);
                } else {
                    msg = "Internal Marks Must Lessthan 20";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }


            }


            if (inter2.equals("A")) {
               // internalTwo = Integer.parseInt(inter2);
                //if (internalTwo <= 20) {
                    marksMaster.setInternalTwo(inter2);
                /*} else {
                    msg = "Internal Marks Must Lessthan 20";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }*/

            } else {

                internalTwo = Integer.parseInt(inter2);
                if (internalTwo <= 20) {
                    marksMaster.setInternalTwo(inter2);
                } else {
                    msg = "Internal Marks Must Lessthan 20";
                    request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
                    return "/updateMarks";
                }

            }



        }


        Attendance attendance = ServiceUtils.getAttendanceService().findById(updateForm.getYear(), updateForm.getBranch(), updateForm.getSemister(), marksMaster.getPaper());

        LOG.debug("====Number of Working Days : ====" + attendance.getNumberOfWorkingDays());
        int noW = Integer.parseInt(updateForm.getAttendanceMarks());
        int pW = Integer.parseInt(attendance.getNumberOfWorkingDays());

        LOG.debug("NOW : " + noW + " PW : " + pW);
        if (noW > pW) {
            msg = "Number of Working Days are :" + pW + "\n" + "Number of Presented Days Lessthan or Equal to Number of Working Days !";
            request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);
            return "/updateMarks";
        }





        marksMaster.setAssignmentMarks(assMarks);
        marksMaster.setId(updateForm.getId());
        marksMaster.setAttendanceMarks(attMarks);
        

        LOG.debug(marksMaster);

        MarksMasterService marksMasterService = ServiceUtils.getMarksMasterService();
        marksMasterService.create(marksMaster);
        
        

        msg = "Marks Updated";
        request.setAttribute("msg", msg, WebRequest.SCOPE_REQUEST);               


        return "/updateMarks";
    }
}
