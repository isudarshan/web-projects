/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.web.controller;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.domain.sub.Branch;
import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.domain.sub.ReportObject;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.service.BranchService;
import com.dmsapp.service.MasterService;
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
@RequestMapping("/report")
public class DataReportController {

    private static Logger LOG = Logger.getLogger(DataReportController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showReportParams(@ModelAttribute HomeForm homeForm, Model model, WebRequest request) {

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
        return "/report";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String genarateReport(@ModelAttribute HomeForm homeForm, WebRequest webRequest, HttpServletRequest request, HttpServletResponse response) {

        MasterService masterService = ServiceUtils.getMasterService();

        String errorResponse = null;
        LOG.debug(homeForm);
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



        AttendanceService attendanceService = ServiceUtils.getAttendanceService();
        LOG.debug("Branch Name : " + branchName.trim() + "Year : " + homeForm.getYear() + "Sem : " + homeForm.getSemister() + " paper :" + homeForm.getPaper());
        Attendance attendance = attendanceService.findById(homeForm.getYear().trim(), branchName.trim(), homeForm.getSemister().trim(), homeForm.getPaper().trim());

        if (attendance == null) {
            // TO DO for Attendance is Not Posted.
        }


        Integer numberOfWorkingDays = Integer.parseInt(attendance.getNumberOfWorkingDays());

        if (numberOfWorkingDays == 0) {
            errorResponse = "Working Hours are Not Posted or Marks are Not Posted for this Request.";
            webRequest.setAttribute("errorResponse", errorResponse, WebRequest.SCOPE_REQUEST);
            return "/report";
        }


        List<MarksMaster> marksList = ServiceUtils.getMarksMasterService().getMarks(homeForm.getYear(), branchName, homeForm.getSemister(), homeForm.getPaper());


        if (marksList.size() == 0) {
            errorResponse = "Working Hours are Not Posted or Marks are Not Posted for this Request.";
            webRequest.setAttribute("errorResponse", errorResponse, WebRequest.SCOPE_REQUEST);
            return "/report";
        }

        List<String> typeOneMarks = new ArrayList<String>();
        List<String> typeTwoMarks = new ArrayList<String>();
        List<String> internalSum = new ArrayList<String>();
        List<String> studentIds = new ArrayList<String>();
        List<String> attendanceMarks = new ArrayList<String>();
        List<String> assignMenteMarks1 = new ArrayList<String>();
        List<String> absentList = new ArrayList<String>();

        String year = null;
        String branch = null;
        String semister = null;
        String paper = null;
        String assignment = null;
        String paperCode = masterService.findByPaperName(homeForm.getPaper().trim(), homeForm.getYear().trim(), branchName.trim(), homeForm.getSemister()).getPaperCode();


        MarksMaster util = marksList.get(0);
        year = util.getYear();
        branch = util.getBranch();
        semister = String.valueOf(util.getSemister());
        paper = util.getPaper();
        assignment = util.getAssignmentMarks();

        for (MarksMaster typeOne : marksList) {
            typeOneMarks.add(typeOne.getInternalOne());
            studentIds.add(typeOne.getStudentId());
            assignMenteMarks1.add(typeOne.getAssignmentMarks());
        }

        for (MarksMaster typeTwo : marksList) {
            attendanceMarks.add(typeTwo.getAttendanceMarks());
            typeTwoMarks.add(typeTwo.getInternalTwo());
        //assignMenteMarks2.add(typeTwo.getAssignmentMarks());

        }

        for (int i = 0; i < typeTwoMarks.size(); i++) {


            //internalSum.add(typeOneMarks.get(i) + typeTwoMarks.get(i));
            if (typeOneMarks.get(i).equalsIgnoreCase("A") || typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                absentList.add(typeOneMarks.get(i));

            } else {
                internalSum.add(String.valueOf(Integer.parseInt(typeOneMarks.get(i)) + Integer.parseInt(typeTwoMarks.get(i))));
            }
        }



        List<ReportObject> reportObjects = new ArrayList<ReportObject>();

        for (int i = 0; i < internalSum.size() + absentList.size(); i++) {
            ReportObject reportObject = new ReportObject();
            reportObject.setStudentId(studentIds.get(i));
            //reportObject.setStudentName(names.get(i));

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


            reportObject.setNumberOfPresentedDays(String.valueOf(numberOfWorkingDays));
            reportObject.setNumberOfWorkingDays(attendanceMarks.get(i));
            reportObject.setAttendance(String.valueOf(attMarks));

            if (assignMenteMarks1.get(i) != null) {
                reportObject.setAssignment(String.valueOf(Integer.parseInt(assignMenteMarks1.get(i))));
            } else {
                reportObject.setAssignment("NA");
            }


            if (typeOneMarks.get(i).equalsIgnoreCase("A") || typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                // Absent List
                reportObject.setInternalOne(typeOneMarks.get(i));
                reportObject.setInternalTwo(typeTwoMarks.get(i));

                if (typeOneMarks.get(i).equalsIgnoreCase("A") && typeTwoMarks.get(i).equalsIgnoreCase("A")) {
                    reportObject.setTotalMarks(0);

                    LOG.debug("===========Both A and A" + assignMenteMarks1.get(i) + "\t" + reportObject.getAttendance());
                    if (assignMenteMarks1.get(i) == null) {
                        reportObject.setGrandTotal(String.valueOf(Integer.parseInt(reportObject.getAttendance())));
                    } else {
                        reportObject.setGrandTotal(String.valueOf(Integer.parseInt(assignMenteMarks1.get(i)) + Integer.parseInt(reportObject.getAttendance())));
                    }
                //reportObject.setGrandTotal(String.valueOf(Integer.parseInt(assignMenteMarks1.get(i)) + Integer.parseInt(reportObject.getAttendance())));
                //reportObject.setGrandTotal("NA");
                }

                if (!typeOneMarks.get(i).equalsIgnoreCase("A")) {

                    if (typeOneMarks.get(i).equals("A")) {
                        LOG.debug("In Absent =============");

                    } else {
                        LOG.debug("Total Marks : ==========" + Integer.parseInt(typeOneMarks.get(i)) / 2);
                    }


                    reportObject.setTotalMarks(Integer.parseInt(typeOneMarks.get(i)) / 2);


                    if (assignMenteMarks1.get(i) != null) {
                        int tot = (Integer.parseInt(typeOneMarks.get(i)) / 2) + Integer.parseInt(reportObject.getAttendance()) + Integer.parseInt(assignMenteMarks1.get(i));
                        LOG.debug(typeOneMarks.get(i) + "===========" + assignMenteMarks1.get(i) + "=============" + attendanceMarks.get(i) + "===============TOT : " + tot);
                        reportObject.setGrandTotal(String.valueOf(tot));

                    } else {
                        int tot = (Integer.parseInt(typeOneMarks.get(i)) / 2) + Integer.parseInt(reportObject.getAttendance());
                        //LOG.debug(typeOneMarks.get(i) + "===========" + assignMenteMarks1.get(i) + "=============" + attendanceMarks.get(i) + "===============TOT : " + tot);
                        reportObject.setGrandTotal(String.valueOf(tot));

                    }


                } else if (!typeTwoMarks.get(i).equalsIgnoreCase("A")) {

                    if (typeOneMarks.get(i).equals("A")) {
                        LOG.debug("In Absent =============");
                    } else {
                        LOG.debug("Total Marks : ==========" + Integer.parseInt(typeOneMarks.get(i)) / 2);
                    }


                    reportObject.setTotalMarks(Integer.parseInt(typeTwoMarks.get(i)) / 2);
                    //
                    //reportObject.setGrandTotal(String.valueOf(Integer.parseInt(typeTwoMarks.get(i)) / 2) + Integer.parseInt(reportObject.getAttendance()) + Integer.parseInt(attendanceMarks.get(i)));
                    //reportObject.setGrandTotal(String.valueOf(reportObject.getTotalMarks() / 2) + Integer.parseInt(reportObject.getAttendance()) + Integer.parseInt(attendanceMarks.get(i)));


                    LOG.debug(typeTwoMarks.get(i) + "===========Attendance :" + reportObject.getAttendance() + "============= Assignments:" + assignMenteMarks1.get(i));
                    if (assignMenteMarks1.get(i) != null) {
                        int tot = (Integer.parseInt(typeTwoMarks.get(i)) / 2) + Integer.parseInt(reportObject.getAttendance()) + Integer.parseInt(assignMenteMarks1.get(i));
                        LOG.debug(typeTwoMarks.get(i) + "===========" + reportObject.getAttendance() + "=============" + assignMenteMarks1.get(i) + "===============TOT : " + tot);
                        reportObject.setGrandTotal(String.valueOf(tot));

                    } else {
                        int tot = (Integer.parseInt(typeTwoMarks.get(i)) / 2) + Integer.parseInt(reportObject.getAttendance());
                        //LOG.debug(typeTwoMarks.get(i) + "===========" + reportObject.getAttendance() + "=============" + assignMenteMarks1.get(i) + "===============TOT : " + tot);
                        reportObject.setGrandTotal(String.valueOf(tot));
                    }


                }

            } else {
                // Presented List

                reportObject.setInternalOne(typeOneMarks.get(i));
                reportObject.setInternalTwo(typeTwoMarks.get(i));
                reportObject.setTotalMarks((Integer.parseInt(typeOneMarks.get(i)) + Integer.parseInt(typeTwoMarks.get(i))) / 2);
                Integer totalMarks = reportObject.getTotalMarks();
                Integer grandTotal = totalMarks + Integer.parseInt(reportObject.getAttendance());

                reportObject.setGrandTotal(String.valueOf(grandTotal));

                if (assignMenteMarks1.get(i) != null) {
                    reportObject.setGrandTotal(String.valueOf(reportObject.getTotalMarks() + Integer.parseInt(reportObject.getAttendance()) + Integer.parseInt(assignMenteMarks1.get(i))));
                }

            }


            reportObject.setYear(year);
            reportObject.setBranch(branch);
            reportObject.setSemister(semister);
            reportObject.setPaper(paper);
            reportObject.setPaperCode(paperCode);

            if (assignment == null) {
                LOG.debug("In Assignment ================Check");

                reportObject.setAssignment("NA");
                reportObject.setHasAssignment("NA");
                reportObject.setHowMany("20 M");
            } else {
                //reportObject.setAssignment("5");
                reportObject.setHasAssignment("5");
                reportObject.setHowMany("15 M");
            }


            reportObjects.add(reportObject);

        }

        LOG.debug(reportObjects);


        String reportTitle = paperCode.trim() + "(" + util.getBranch() + "(Year-" + util.getYear() + "Semister-" + util.getSemister() + ")";
        response.setContentType("application/pdf");
        response.setHeader("Cache-Control", "max-age=0");
        response.setHeader("Content-Disposition", "attachment" + "; filename=" + reportTitle+".pdf");

        ServletOutputStream servletOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;

        inputStream = request.getSession().getServletContext().getResourceAsStream("/WEB-INF/report.jrxml");
        try {
            servletOutputStream = response.getOutputStream();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        // Report Code


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
