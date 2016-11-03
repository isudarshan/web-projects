/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.*;
import com.hms.service.LabAdminService;
import com.hms.utils.ServiceUtils;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author cmc
 */
class SendText implements IOutboundMessageNotification {

    @Override
    public void process(AGateway arg0, OutboundMessage arg1) {
        //do nothing
    }
}

public class LabAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In LabAdminController");
        String action = request.getParameter("action");
        if (("generateReport").equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/generateReport.jsp");
            dispatcher.forward(request, response);

        }
        if (("viewRequests").equalsIgnoreCase(action)) {
            LabAdminService labAdminService = ServiceUtils.getLabAdminService();
            List<LabAdmin> labAdminList = labAdminService.getAll();
            HttpSession session = request.getSession();
            for (LabAdmin labAdmin : labAdminList) {
                System.out.println(labAdmin);
            }
            session.setAttribute("labAdminList", labAdminList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/tests.jsp");
            dispatcher.forward(request, response);
        }

        if (("viewCompletedTests").equalsIgnoreCase(action)) {
            LabAdminService labAdminService = ServiceUtils.getLabAdminService();
            List<LabAdmin> list = labAdminService.getAll();
            List<LabAdmin> newList = new ArrayList<LabAdmin>();
            for (LabAdmin labAdmin : list) {
                if (labAdmin.getTestFee() != null) {
                    newList.add(labAdmin);
                }

            }
            HttpSession session = request.getSession();
            session.setAttribute("newList", newList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCompletedTests.jsp");
            dispatcher.forward(request, response);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Id = null;

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {

            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            FileItem report = fileItems.get(0);
            String Report = report.getString();

            FileItem testFee = fileItems.get(1);
            String TestFee = testFee.getString();

            FileItem uploadReport = fileItems.get(2);

            byte[] imageBytes = uploadReport.get();

            FileItem id = fileItems.get(3);
            Id = id.getString();
            System.out.println("Id===" + Id);

            LabAdminService labAdminService = ServiceUtils.getLabAdminService();
            LabAdmin labAdmin = labAdminService.get(Long.parseLong(Id));
            labAdmin.setId(labAdmin.getId());
            labAdmin.setDoctorId(labAdmin.getDoctorId());
            labAdmin.setDoctorName(labAdmin.getDoctorName());
            labAdmin.setPatientId(labAdmin.getPatientId());
            labAdmin.setPatientName(labAdmin.getPatientName());
            labAdmin.setTestSuggested(labAdmin.getTestSuggested());
            labAdmin.setReport(Report);
            labAdmin.setTestFee(TestFee);
            labAdmin.setUploadReport(imageBytes);


            labAdminService.create(labAdmin);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        request.setAttribute("msg", "Report sent to patient and doctor");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/labAdminHome.jsp");
        dispatcher.forward(request, response);

        SendText sendText = new SendText();
        LabAdmin labAdmin1 = ServiceUtils.getLabAdminService().get(Long.parseLong(Id));
        System.out.println("Id Second===" + Id);
        RegisteredPatient patient = ServiceUtils.getRegisteredPatientService().getPatientbyPatientId(labAdmin1.getPatientId());

        SerialModemGateway gateway = new SerialModemGateway("com9", "COM9", 115200, "", "");

        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSmscNumber("+919885005444");

        try {
            Service.getInstance().startService();
            Service.getInstance().addGateway(gateway);
            Service.getInstance().setOutboundMessageNotification(sendText);

            OutboundMessage message = new OutboundMessage(patient.getMobileNumber(), "Your medical report is sent!!Please login to view");
            Service.getInstance().sendMessage(message);
            Service.getInstance().stopService();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", Id);
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/patientHome.jsp");
        dispatcher1.forward(request, response);


    }
}
