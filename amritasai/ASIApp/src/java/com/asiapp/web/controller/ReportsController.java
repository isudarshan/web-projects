/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.web.controller;

import com.asiapp.domain.sub.Department;
import com.asiapp.domain.sub.Faculty;
import com.asiapp.domain.sub.FeedBack;
import com.asiapp.domain.sub.ReportObject;
import com.asiapp.utils.service.ServiceUtils;
import com.asiapp.web.forms.FacultyMapForm;
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
    public String showReportHome(@ModelAttribute FacultyMapForm facultyMapForm, WebRequest request) {
        List<Department> departments = ServiceUtils.getDepartmentService().getAll();
        request.setAttribute("departments", departments, WebRequest.SCOPE_SESSION);

        List<Faculty> faculties = ServiceUtils.getFacultyService().getAll();
        request.setAttribute("faculties", faculties, WebRequest.SCOPE_SESSION);
        return "/reports";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showReport(@ModelAttribute FacultyMapForm facultyMapForm, HttpServletRequest request, HttpServletResponse response, WebRequest webRequest) {
        String res = null;
        boolean error = false;
        if (facultyMapForm.getDepartmentName().equals("Department")) {
            error = true;
        }

        if (facultyMapForm.getYear().equals("Select Year")) {
            error = true;
        }

        if (facultyMapForm.getSemister().equals("Select Semister")) {
            error = true;
        }

        if (facultyMapForm.getSubject().equals("Select Subject")) {
            error = true;
        }

        if (facultyMapForm.getFacultyName().equals("Select Faculty Name")) {
            error = true;
        }

        if(error) {
            res = "All Fields are required !";
            webRequest.setAttribute("msg", res, WebRequest.SCOPE_SESSION);
            return "/reports";
        }

        List<FeedBack> list = ServiceUtils.getFeedbackService().getTotalFeedBackPoints(facultyMapForm.getDepartmentName(), facultyMapForm.getYear(), facultyMapForm.getSemister(), facultyMapForm.getSubject(), facultyMapForm.getFacultyName());

        if (list.size() == 0) {
            res = "Could't Genarate Report, FeedBack not Available for the Selected Faculty !";
            webRequest.setAttribute("msg", res, webRequest.SCOPE_SESSION);
            return "/reports";
        }
        Integer totalMarks = 0;
        LOG.debug("Number of Persons Given FeedBack : " + list.size());
        LOG.debug("Total Number of Points  : " + (list.size() * 30));
        for (FeedBack feedBack : list) {
            totalMarks = totalMarks + Integer.parseInt(feedBack.getFeedBackTotal());
        }

        LOG.debug("Faculty Score : " + totalMarks);

        ReportObject reportObject = new ReportObject();
        reportObject.setFacultyName(facultyMapForm.getFacultyName());
        reportObject.setDepartmentName(facultyMapForm.getDepartmentName());
        reportObject.setYear(facultyMapForm.getYear());
        reportObject.setSemister(facultyMapForm.getSemister());
        reportObject.setSubjectName(facultyMapForm.getSubject());
        reportObject.setTotalStudents(String.valueOf(list.size()));
        reportObject.setTotalPoints(String.valueOf(list.size() * 30));
        reportObject.setGainedPoints(String.valueOf(totalMarks));

        List<ReportObject> reportObjects = new ArrayList<ReportObject>();
        reportObjects.add(reportObject);
        response.setContentType("application/pdf");
        ServletOutputStream servletOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;

        inputStream = request.getSession().getServletContext().getResourceAsStream("/WEB-INF/feedbackReport.jrxml");
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
