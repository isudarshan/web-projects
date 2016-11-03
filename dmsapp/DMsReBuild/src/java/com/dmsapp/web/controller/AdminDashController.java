/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Master;
import com.dmsapp.domain.sub.SubMaster;
import com.dmsapp.service.MasterService;
import com.dmsapp.utils.service.CustomGenericResponse;
import com.dmsapp.utils.service.CustomUserResponse;
import com.dmsapp.utils.service.ServiceUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Sudarsan
 */
@Controller
@RequestMapping("/adminDash")
public class AdminDashController {

    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "/adminDash";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/crud")
    @ResponseBody
    public CustomUserResponse getAll(@RequestParam("rows") String rows, @RequestParam("page") String page, @RequestParam("sidx") String sidx, @RequestParam("sord") String sord) {

        System.out.println("In Controller ============================");
        CustomUserResponse customUserResponse = new CustomUserResponse();
        System.out.println("=====" + rows + "=====" + page + "=====" + sidx + "====" + sord);
        int rowsCount = Integer.parseInt(rows);
        int pages = Integer.parseInt(page);

        List<Master> masterList = ServiceUtils.getMasterService().getStudentsByPage(rowsCount, pages, sidx, sord);

        List<SubMaster> list = new ArrayList<SubMaster>();
        for (Master master : masterList) {
            SubMaster subMaster = new SubMaster();
            subMaster.setId(master.getId());
            subMaster.setYear(master.getYear());
            subMaster.setBranch(master.getBranch());
            subMaster.setSemister(String.valueOf(master.getSemister()));
            subMaster.setPaper(master.getPaper());
            subMaster.setPaperCode(master.getPaperCode());
            list.add(subMaster);
        }

        customUserResponse.setRows(list);
        int count = ServiceUtils.getMasterService().getNoOfRecords();
        customUserResponse.setRecords(String.valueOf(masterList.size()));
        int total = count % rowsCount == 0 ? (int) Math.ceil(count / rowsCount) : (int) Math.ceil(count / rowsCount) + 1;
        System.out.println("List Size : "+list.size());      
        

        System.out.println("Total"+total+"count"+count);
        customUserResponse.setTotal(String.valueOf(total));
        customUserResponse.setRecords(String.valueOf(count));
        customUserResponse.setPage(String.valueOf(pages));       


        return customUserResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public CustomGenericResponse add(@RequestParam("year") String year, @RequestParam("branch") String branch, @RequestParam("semister") String semister, @RequestParam("paper") String paper, @RequestParam("paperCode") String paperCode) {

        System.out.println("================In Add" + year + " ====" + branch + "====" + semister + "===" + paper + "====" + paperCode);
        CustomGenericResponse customGenericResponse = new CustomGenericResponse();
        Master master = new Master();
        master.setYear(year);
        master.setBranch(branch);
        master.setSemister(semister);
        master.setPaper(paper);
        master.setPaperCode(paperCode);
        master.setCreatedBy(1);
        master.setCreatedOn(new java.util.Date());
        master.setModifiedBy(1);
        master.setModifiedOn(new java.util.Date());
        master.setActive(1);


        MasterService masterService = ServiceUtils.getMasterService();
        Boolean success = masterService.create(master);

        if (success) {
            customGenericResponse.setSuccess(true);
            customGenericResponse.setMessage("New Paper Added Successfully");
        } else {
            customGenericResponse.setSuccess(false);
            customGenericResponse.setMessage("Action Failed");
        }

        return customGenericResponse;
    }


    @RequestMapping(method = RequestMethod.POST, value="/edit")
    @ResponseBody
    public CustomGenericResponse edit(@RequestParam("id") Integer id, @RequestParam("year") String year, @RequestParam("branch") String branch, @RequestParam("semister") String semister, @RequestParam("paper") String paper, @RequestParam("paperCode") String paperCode) {
        CustomGenericResponse customGenericResponse = new CustomGenericResponse();
        System.out.println("===="+id+"===="+year+"===="+branch+"===="+semister+"===="+paper+"==="+paperCode);

        Master master = new Master();
        master.setId(id);
        master.setYear(year);
        master.setBranch(branch);
        master.setSemister(semister);
        master.setPaper(paper);
        master.setPaperCode(paperCode);
        master.setCreatedBy(1);
        master.setModifiedBy(1);
        master.setCreatedOn(new java.util.Date());
        master.setModifiedOn(new java.util.Date());
        master.setActive(1);

        Boolean success =  ServiceUtils.getMasterService().create(master);

        if(success) {
            customGenericResponse.setMessage("Record Updated !");
            customGenericResponse.setSuccess(true);
        }else {
            customGenericResponse.setMessage("Action Failed");
            customGenericResponse.setSuccess(false);
        }
        return customGenericResponse;
    }

    @RequestMapping(method = RequestMethod.POST, value="/delete")
    @ResponseBody
    public CustomGenericResponse delete(@RequestParam("id") Integer id) {
        CustomGenericResponse customGenericResponse = new CustomGenericResponse();
        System.out.println("===="+id+"====");

        
        Master master = new Master();
        master.setId(id);
//        master.setYear(year);
//        master.setBranch(branch);
//        master.setSemister(Integer.parseInt(semister));
//        master.setPaper(paper);
//        master.setPaperCode(paperCode);
//        master.setCreatedBy(1);
//        master.setModifiedBy(1);
//        master.setCreatedOn(new java.util.Date());
//        master.setModifiedOn(new java.util.Date());
//        master.setActive(1);

        Boolean success =  ServiceUtils.getMasterService().delete(master);

        if(success) {
            customGenericResponse.setMessage("Record Deleted!");
            customGenericResponse.setSuccess(true);
        }else {
            customGenericResponse.setMessage("Action Failed");
            customGenericResponse.setSuccess(false);
        }
        return customGenericResponse;
    }

}
