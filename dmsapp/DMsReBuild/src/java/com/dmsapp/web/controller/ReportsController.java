/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.Branch;
import com.dmsapp.domain.sub.ReportObject;
import com.dmsapp.domain.sub.TypeOne;
import com.dmsapp.domain.sub.TypeTwo;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.service.BranchService;
import com.dmsapp.service.MasterService;
import com.dmsapp.service.TypeOneService;
import com.dmsapp.service.TypeTwoService;
import com.dmsapp.utils.service.ServiceUtils;
import com.dmsapp.web.forms.HomeForm;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
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
@RequestMapping("/reports")
public class ReportsController {

    private static Logger LOG = Logger.getLogger(ReportsController.class);

    @RequestMapping(method = RequestMethod.GET)
    
    public String showReportsPage(@ModelAttribute HomeForm homeForm, WebRequest request, Model model) {

        LOG.debug("Paper Code : " + homeForm.getPapaerCode());
        List<Branch> branchList = null;
        try {
            BranchService branchService = ServiceUtils.getBranchService();
            branchList = branchService.getAll();

        } catch (Exception exception) {
            LOG.warn("MarksHomeController", exception);
        }
        model.addAttribute(new HomeForm());
        LOG.debug("Branch List : " + branchList);
        request.setAttribute("branchList", branchList, WebRequest.SCOPE_SESSION);

        return "/reportsHome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showReport(@ModelAttribute HomeForm homeForm, HttpServletRequest request, HttpServletResponse response, WebRequest webRequest) {
        //LOG.debug("Home Form : " + homeForm);
        //LOG.debug("======================================\n");

        String errorResponse = null;

        String branchName = null;
        if ("1".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BA";
        } else if ("2".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BCOM(GEN)";
        } else if ("3".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BCOM(CS)";
        } else if ("4".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MPC)";
        } else if ("5".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MSCS)";
        } else if ("6".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MPCS)".trim();
        } else if ("7".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MECS)";
        } else if ("8".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(MSCA)";
        } else if ("9".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(FMC)";
        } else if ("10".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(FMB)";
        } else if ("11".equalsIgnoreCase(homeForm.getBranch())) {
            branchName = "BSC(BZC)";
        } else {
            branchName = "Invalid Branch";
        }


        MasterService masterService = ServiceUtils.getMasterService();

        AttendanceService attendanceService = ServiceUtils.getAttendanceService();
        LOG.debug("Branch Name : " + branchName.trim() + "Year : " + homeForm.getYear() + "Sem : " + homeForm.getSemister() + " paper :" + homeForm.getPaper());
        Attendance attendance = attendanceService.findById(homeForm.getYear().trim(), branchName.trim(), String.valueOf(homeForm.getSemister()).trim(), homeForm.getPaper().trim());

        LOG.debug("Atten dance : " + attendance);

        Integer numberOfWorkingDays = Integer.parseInt(attendance.getNumberOfWorkingDays());
        LOG.debug("No.Working Days :" + numberOfWorkingDays);

        if (numberOfWorkingDays == 0) {
            errorResponse = "Working Hours are Not Posted or Marks are Not Posted for this Request.";
            webRequest.setAttribute("errorResponse", errorResponse, WebRequest.SCOPE_REQUEST);
            LOG.debug("Number of Working days are Not defined for this Request");
            return "/reportsHome";
        }

        TypeOneService typeOneService = ServiceUtils.getTypeOneService();
        List<TypeOne> typeOneList = typeOneService.getMarks(homeForm.getYear().trim(), branchName.trim(), String.valueOf(homeForm.getSemister()).trim(), homeForm.getPaper().trim());

        TypeTwoService typeTwoService = ServiceUtils.getTypeTwoService();
        List<TypeTwo> typeTwoList = typeTwoService.getMarks(homeForm.getYear().trim(), branchName.trim(), String.valueOf(homeForm.getSemister()).trim(), homeForm.getPaper().trim());

        LOG.debug("Type One Marks :" + typeOneList.size() + "Type Two Marks : " + typeOneList.size() + "\n");

        if (typeOneList.size() == 0 || typeTwoList.size() == 0) {
            errorResponse = "Working Hours are Not Posted or Marks are Not Posted for this Request.";
            LOG.debug("Type One Marks :" + typeOneList.size() + "Type Two Marks : " + typeOneList.size() + "\n");
            LOG.debug("Report Can't be genarated, Since Marks are Not Posted");
            webRequest.setAttribute("errorResponse", errorResponse, WebRequest.SCOPE_REQUEST);
            return "/reportsHome";
        }


        List<String> typeOneMarks = new ArrayList<String>();
        List<String> typeTwoMarks = new ArrayList<String>();

        List<String> internalSum = new ArrayList<String>();

        List<String> names = new ArrayList<String>();
        List<String> studentIds = new ArrayList<String>();
        List<String> attendanceMarks = new ArrayList<String>();
        List<String> assignMenteMarks1 = new ArrayList<String>();
        List<String> assignMenteMarks2 = new ArrayList<String>();
        List<String> absentList = new ArrayList<String>();

        String year = null;
        String branch = null;
        String semister = null;
        String paper = null;

        LOG.debug("============================" + homeForm.getYear());
        String paperCode = masterService.findByPaperName(homeForm.getPaper().trim(), homeForm.getYear().trim(), branchName.trim(), String.valueOf(homeForm.getSemister())).getPaperCode();

        List<ReportObject> reportObjects = new ArrayList<ReportObject>();

        TypeOne util = typeOneList.get(0);
        year = util.getYear();
        branch = util.getBranch();
        semister = String.valueOf(util.getSemister());
        paper = util.getPaper();

        for (TypeOne typeOne : typeOneList) {

            typeOneMarks.add(typeOne.getInterOneMarks());

            names.add(typeOne.getSurName() + " " + typeOne.getFirstName());
            studentIds.add(typeOne.getStudentId());
            assignMenteMarks1.add(typeOne.getAssignmentMarks());
        }

        for (TypeTwo typeTwo : typeTwoList) {
            attendanceMarks.add(typeTwo.getAttendanceMarks());

            typeTwoMarks.add(typeTwo.getInterTwoMarks());
            assignMenteMarks2.add(typeTwo.getAssignmentMarks());

        }

        LOG.debug("Assignment Marks I : " + assignMenteMarks1 + " " + "Assignment Marks II : " + assignMenteMarks2);


        LOG.debug("Size of Type One :" + typeOneMarks.size() + " Size of Type Two : " + typeTwoMarks.size());

        for (int i = 0; i < typeTwoMarks.size(); i++) {


            //internalSum.add(typeOneMarks.get(i) + typeTwoMarks.get(i));
            if (typeOneMarks.get(i).equalsIgnoreCase("A") || typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                absentList.add(typeOneMarks.get(i));

            } else {
                internalSum.add(String.valueOf(Integer.parseInt(typeOneMarks.get(i)) + Integer.parseInt(typeTwoMarks.get(i))));
            }
        }


        LOG.debug("Internal Sum List : " + internalSum);
        LOG.debug("Abset List : " + absentList);


        // Report Genaration

        for (int i = 0; i < internalSum.size() + absentList.size(); i++) {
            ReportObject reportObject = new ReportObject();
            reportObject.setStudentId(studentIds.get(i));
            reportObject.setStudentName(names.get(i));

            LOG.debug(attendanceMarks.get(i));
            Integer percentage = (100 * Integer.parseInt(attendanceMarks.get(i))) / (numberOfWorkingDays);
            Integer attMarks = null;

            if (percentage >= 91) {
                attMarks = 5;
            } else if (percentage >= 86 && percentage <= 90) {
                attMarks = 4;
            } else if (percentage >= 81 && percentage <= 85) {
                attMarks = 3;
            } else if (percentage >= 76 && percentage <= 80) {
                attMarks = 2;
            } else if (percentage >= 60 && percentage <= 75) {
                attMarks = 0;
            } else {
                attMarks = 0;
            }

            LOG.debug("No.Days : " + attendanceMarks.get(i) + "Att Marks : " + attMarks + "Per :" + percentage);

            reportObject.setNumberOfPresentedDays(String.valueOf(numberOfWorkingDays));
            reportObject.setNumberOfWorkingDays(attendanceMarks.get(i));
            reportObject.setAttendance(String.valueOf(attMarks));
            reportObject.setAssignment(String.valueOf(Integer.parseInt(assignMenteMarks1.get(i)) + Integer.parseInt(assignMenteMarks2.get(i))));

            if (typeOneMarks.get(i).equalsIgnoreCase("A") || typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                // Absent List
                reportObject.setInternalOne(typeOneMarks.get(i));
                reportObject.setInternalTwo(typeTwoMarks.get(i));

                if (typeOneMarks.get(i).equalsIgnoreCase("A") && typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                    reportObject.setTotalMarks(0);
                    //reportObject.setGrandTotal(String.valueOf(Integer.parseInt(typeOneMarks.get(i)) + Integer.parseInt(reportObject.getAttendance())));
                    reportObject.setGrandTotal("NA");
                }

                if (!typeOneMarks.get(i).equalsIgnoreCase("A")) {
                    reportObject.setTotalMarks(Integer.parseInt(typeOneMarks.get(i)) / 2);
                    reportObject.setGrandTotal(String.valueOf(Integer.parseInt(typeOneMarks.get(i)) / 2 + Integer.parseInt(reportObject.getAttendance())));
                } else if (!typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                    reportObject.setTotalMarks(Integer.parseInt(typeTwoMarks.get(i)) / 2);
                    reportObject.setGrandTotal(String.valueOf(Integer.parseInt(typeTwoMarks.get(i)) / 2 + Integer.parseInt(reportObject.getAttendance())));

                }

            } else {
                // Presented List

                reportObject.setInternalOne(typeOneMarks.get(i));
                reportObject.setInternalTwo(typeTwoMarks.get(i));
                reportObject.setTotalMarks((Integer.parseInt(typeOneMarks.get(i)) + Integer.parseInt(typeTwoMarks.get(i))) / 2);
                Integer totalMarks = reportObject.getTotalMarks();
                Integer grandTotal = totalMarks + Integer.parseInt(reportObject.getAttendance());

                reportObject.setGrandTotal(String.valueOf(grandTotal));
                reportObject.setGrandTotal(String.valueOf(reportObject.getTotalMarks() + Integer.parseInt(reportObject.getAttendance())));
            }


            reportObject.setYear(year);
            reportObject.setBranch(branch);
            reportObject.setSemister(semister);
            reportObject.setPaper(paper);
            reportObject.setPaperCode(paperCode);

            reportObjects.add(reportObject);

            LOG.debug("Internal Count : " + i);
        }

        LOG.debug(reportObjects);

        LOG.debug(reportObjects);

        response.setContentType("application/pdf");
        ServletOutputStream servletOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        
        inputStream = request.getSession().getServletContext().getResourceAsStream("/WEB-INF/report.jrxml");
        try {
            servletOutputStream = response.getOutputStream();
            LOG.debug("Available  : " + inputStream.available());
        } catch (Exception exception) {
            exception.printStackTrace();
        }



        try {
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Map map = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(reportObjects));

            JasperExportManager.exportReportToPdfStream(jasperPrint,
                    byteArrayOutputStream);

            response.setContentLength(byteArrayOutputStream.size());
            byteArrayOutputStream.writeTo(servletOutputStream);

            inputStream.close();
        
            LOG.debug("Done Report to Pdf");
        } catch (Exception exception) {
            LOG.debug("ReportsController", exception);
        } finally {
            try {
                if (servletOutputStream != null) {
                    servletOutputStream.flush();
                    servletOutputStream.close();
                }
            } catch (Exception exception) {
                LOG.debug(exception);
            }
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                }
            } catch (Exception exception) {
                LOG.debug(exception);
            }

            try {
                inputStream.close();
            } catch (Exception exception) {
                LOG.debug(exception);
            }


        }
        return "";
    }
}
