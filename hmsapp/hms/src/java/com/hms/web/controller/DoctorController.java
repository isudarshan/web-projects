/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.Doctor_Patient;
import com.hms.domain.sub.LabAdmin;
import com.hms.domain.sub.Prescription;
import com.hms.domain.sub.RegisteredDoctor;
import com.hms.service.AppUserService;
import com.hms.service.Doctor_PatientService;
import com.hms.service.LabAdminService;
import com.hms.service.PrescriptionService;
import com.hms.service.RegisteredDoctorService;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.InputStream;
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
import org.hibernate.Session;

/**
 *
 * @author cmc
 */
public class DoctorController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget========");
        String action = request.getParameter("action");
        if (("viewProfile").equalsIgnoreCase(action)) {
            AppUser appUser = (AppUser) request.getSession().getAttribute("user");
            System.out.println("appUser:"+appUser);
            RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
            RegisteredDoctor registeredDoctor = registeredDoctorService.get(appUser.getUserName());
            request.setAttribute("Doctor", registeredDoctor);
            System.out.println("RegDoctor :"+registeredDoctor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewProfile.jsp");
            dispatcher.forward(request, response);
        }

        if ("viewDoctors".equalsIgnoreCase(action)) {
            RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
            List<RegisteredDoctor> doctors = registeredDoctorService.getAll();
            request.setAttribute("Doctors", doctors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewAllDoctors.jsp");
            dispatcher.forward(request, response);

        }
        if (("viewPatient").equalsIgnoreCase(action)) {
            String doctorName = request.getParameter("doctorName");
            Doctor_PatientService doctor_PatientService = ServiceUtils.getDoctor_PatientService();
            List<Doctor_Patient> doctor_Patients = doctor_PatientService.get(doctorName);

            HttpSession session = request.getSession();
            session.setAttribute("Doctor_Patients", doctor_Patients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPatients.jsp");
            dispatcher.forward(request, response);
        }
        if(("viewReports").equalsIgnoreCase(action)){
            System.out.println("viewReports===");
            String doctorName=request.getParameter("doctorName");
           LabAdminService labAdminService = ServiceUtils.getLabAdminService();
           List<LabAdmin> list = labAdminService.getByDoctor(doctorName);
           HttpSession session = request.getSession();
           session.setAttribute("list", list);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPatientReports.jsp");
           dispatcher.forward(request, response);
                   
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (("submitPrescription").equalsIgnoreCase(action)) {
            String patientId = request.getParameter("patientId");
            String patientName = request.getParameter("patientName");
            String prescription = request.getParameter("prescription");
            String testSuggested = request.getParameter("tests");
            String doctorName = request.getParameter("doctorName");
            System.out.println(doctorName);
            String doctorId = request.getParameter("doctorId");



            Prescription prescription1 = new Prescription();
            prescription1.setDoctorId(doctorId);
            prescription1.setDoctorName(doctorName);
            prescription1.setPatientId(patientId);
            prescription1.setPatientName(patientName);
            prescription1.setPrescription(prescription);
            prescription1.setTestSuggested(testSuggested);

            PrescriptionService prescriptionService = ServiceUtils.getPrescriptionService();
            prescriptionService.create(prescription1);
            request.setAttribute("successMsg", "Prescription sent to the patient!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPatients.jsp");
            dispatcher.forward(request, response);

        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            boolean error = false;
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            FileItem userName = fileItems.get(0);
            String username = userName.getString();

            FileItem doctorId = fileItems.get(1);
            String doctorid = doctorId.getString();

            FileItem firstName = fileItems.get(2);
            String firstname = firstName.getString();

            FileItem lastName = fileItems.get(3);
            String lastname = lastName.getString();

            FileItem gender = fileItems.get(4);
            String sex = gender.getString();

            FileItem specialization = fileItems.get(5);
            String specializatn = specialization.getString();

            FileItem mobileNumber = fileItems.get(6);
            String mobile = mobileNumber.getString();

            FileItem email = fileItems.get(7);
            String emailId = email.getString();

            FileItem experience = fileItems.get(8);
            String experienc = experience.getString();

            FileItem photograph = fileItems.get(9);

            byte[] imageBytes = photograph.get();


            if (username.length() == 0 || username == null) {
                error = true;
            }

            if (doctorid.length() == 0 || doctorid == null) {
                error = true;
            }
            if (firstname.length() == 0 || firstname == null) {
                error = true;
            }
            if (lastname.length() == 0 || lastname == null) {
                error = true;
            }
            if (specializatn.length() == 0 || specializatn == null) {
                error = true;
            }
            if (sex.length() == 0 || sex == null) {
                error = true;
            }
            if (mobile.length() == 0 || mobile == null) {
                error = true;
            }
            if (emailId.length() == 0 || emailId == null) {
                error = true;
            }
            if (imageBytes.length == 0) {
                error = true;
            }
            if (error) {
                request.setAttribute("clientError", "All fields are mandatory");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/registeredDoctors.jsp");
                dispatcher.forward(request, response);
                return;
            }

            RegisteredDoctor registeredDoctor = new RegisteredDoctor();
            registeredDoctor.setUserName(username);
            registeredDoctor.setActive(1L);
            registeredDoctor.setCreatedBy("bbb");
            registeredDoctor.setCreatedOn(new java.util.Date());
            registeredDoctor.setModifiedBy("ccc");
            registeredDoctor.setModifiedOn(new java.util.Date());
            registeredDoctor.setDoctorId(doctorid);
            registeredDoctor.setFirstName(firstname);
            registeredDoctor.setLastName(lastname);
            registeredDoctor.setEmail(emailId);
            registeredDoctor.setExperience(experienc);
            registeredDoctor.setGender(sex);
            registeredDoctor.setMobileNumber(mobile);
            registeredDoctor.setPhotoGraph(imageBytes);
            registeredDoctor.setSpecialization(specializatn);
            AppUser appUser = new AppUser();
            appUser.setUserName(username);
            appUser.setPassword("password");
            appUser.setSecurityQuestion("What is your RegistrationId?");
            appUser.setAnswer(doctorid);
            appUser.setUserRole("doctor");

            AppUserService appUserService = ServiceUtils.getAppUserService();
            appUserService.create(appUser);

            RegisteredDoctorService registeredDoctorService = ServiceUtils.getRegisteredDoctorService();
            registeredDoctorService.create(registeredDoctor);

            request.setAttribute("created", "Doctor created successfully...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
            dispatcher.forward(request, response);



        } catch (Exception exception) {
            exception.printStackTrace();
        }



        



    }
}
