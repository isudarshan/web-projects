/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.LabAdmin;
import com.hms.domain.sub.Prescription;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.AppUserService;
import com.hms.service.LabAdminService;
import com.hms.service.PrescriptionService;
import com.hms.service.RegisterPatientService;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author cmc
 */
public class PatientController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (("viewPatients").equalsIgnoreCase(action)) {
            RegisterPatientService registerPatientService = ServiceUtils.getRegisteredPatientService();
            List<RegisteredPatient> patients = registerPatientService.getAll();

            request.setAttribute("Patients", patients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewAllPatients.jsp");
            dispatcher.forward(request, response);
        }
        if (("viewMyPrescription").equalsIgnoreCase(action)) {
            String patientName = request.getParameter("patientName");
            PrescriptionService prescriptionService = ServiceUtils.getPrescriptionService();

            List<Prescription> prescriptions = prescriptionService.getPrescriptionByPatientName(patientName);

            HttpSession session = request.getSession();

            session.setAttribute("prescriptions", prescriptions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPrescriptions.jsp");
            dispatcher.forward(request, response);

        }
        if (("prescription").equalsIgnoreCase(action)) {
            String patientId = request.getParameter("patientId");
            String patientName = request.getParameter("patientName");
            String doctorId = request.getParameter("doctorId");
            String doctorName = request.getParameter("doctorName");

            PrescriptionService prescriptionService = ServiceUtils.getPrescriptionService();
            List<Prescription> prescriptions = prescriptionService.getPrescriptionByPatientName(patientName);

            if (prescriptions.size() == 0) {
            request.setAttribute("patientId", patientId);
            request.setAttribute("patientName", patientName);
            request.setAttribute("doctorId", doctorId);
            request.setAttribute("doctorName", doctorName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/prescription.jsp");
            dispatcher.forward(request, response);
            return;

            }
            request.setAttribute("msg1", "Presciption is already sent to this patient!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPatients.jsp");
            dispatcher.forward(request, response);

        }
        if (("conductTest").equalsIgnoreCase(action)) {
            System.out.println("in conductTest");
            String doctorId = request.getParameter("doctorId");
            String patientName = request.getParameter("patientName");
            String doctorName = request.getParameter("doctorName");
            String patientId = request.getParameter("patientId");
            String test = request.getParameter("test");

            LabAdmin labAdmin = new LabAdmin();
            labAdmin.setDoctorId(doctorId);
            labAdmin.setDoctorName(doctorName);
            labAdmin.setPatientId(patientId);
            labAdmin.setPatientName(patientName);
            labAdmin.setTestSuggested(test);

            LabAdminService labAdminService = ServiceUtils.getLabAdminService();
            labAdminService.create(labAdmin);

            request.setAttribute("msg", "Your request is sent to the lab");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyPrescriptions.jsp");
            dispatcher.forward(request, response);

        }
        if (("viewMyReports").equalsIgnoreCase(action)) {
            System.out.println("in view My reports");

            AppUser appUser = (AppUser) request.getSession().getAttribute("user");

            LabAdminService labAdminService = ServiceUtils.getLabAdminService();
            List<LabAdmin> list = labAdminService.getByName(appUser.getUserName());
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMyReport.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {





        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            boolean error = false;

            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            FileItem userName = fileItems.get(0);
            String Username = userName.getString();

            FileItem firstName = fileItems.get(1);
            String Firstname = firstName.getString();

            FileItem lastName = fileItems.get(2);
            String Lastname = lastName.getString();

            FileItem patientId = fileItems.get(3);
            String Patientid = patientId.getString();

            FileItem month = fileItems.get(4);
            String Mon = month.getString();

            FileItem day = fileItems.get(5);
            String Day = day.getString();

            FileItem year = fileItems.get(6);
            String Year = year.getString();

            FileItem age = fileItems.get(7);
            String Age = age.getString();

            FileItem gender = fileItems.get(8);
            String Gender = gender.getString();

            FileItem height = fileItems.get(9);
            String Height = height.getString();

            FileItem weight = fileItems.get(10);
            String Weight = weight.getString();

            FileItem address = fileItems.get(11);
            String Address = address.getString();


            FileItem phoneNumber = fileItems.get(12);
            String PhoneNumber = phoneNumber.getString();

            FileItem requestedConsultant = fileItems.get(13);
            String RequestedConsultant = requestedConsultant.getString();

            FileItem observation = fileItems.get(14);
            String Observation = observation.getString();

            FileItem medicalReports = fileItems.get(15);
            String MedicalReports = medicalReports.getString();

            FileItem consultationFee = fileItems.get(16);
            String ConsultationFee = consultationFee.getString();


            FileItem photograph = fileItems.get(17);
            byte[] imageBytes = photograph.get();




            if (Username.length() == 0 || Username == null) {
                error = true;
            }
            if (Firstname.length() == 0 || Firstname == null) {
                error = true;
            }

            if (Lastname.length() == 0 || Lastname == null) {
                error = true;
            }

            if (Patientid.length() == 0 || Patientid == null) {
                error = true;
            }

            if (Age.length() == 0 || Age == null) {
                error = true;
            }

            if (Gender.length() == 0 || Gender == null) {
                error = true;
            }
            if (Height.length() == 0 || Height == null) {
                error = true;
            }
            if (Weight.length() == 0 || Weight == null) {
                error = true;
            }
            if (PhoneNumber.length() == 0 || PhoneNumber == null) {
                error = true;
            }
            if (Address.length() == 0 || Address == null) {
                error = true;
            }
            if (RequestedConsultant.length() == 0 || RequestedConsultant == null) {
                error = true;
            }
            if (Observation.length() == 0 || Observation == null) {
                error = true;
            }
            if (MedicalReports.length() == 0 || MedicalReports == null) {
                error = true;
            }
            if (ConsultationFee.length() == 0 || ConsultationFee == null) {
                error = true;
            }
            if (error) {
                request.setAttribute("clientError", "All fields are mandatory!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/registerPatient.jsp");
                dispatcher.forward(request, response);
                return;
            }

            RegisteredPatient registeredPatient = new RegisteredPatient();


            registeredPatient.setActive(1L);
            registeredPatient.setCreatedBy("bbb");
            registeredPatient.setCreatedOn(new java.util.Date());
            registeredPatient.setModifiedBy("bbb");
            registeredPatient.setModifiedOn(new java.util.Date());
            registeredPatient.setFirstName(Firstname);
            registeredPatient.setLastName(Lastname);
            registeredPatient.setAddress(Address);
            registeredPatient.setGender(Gender);
            registeredPatient.setAge(Age);
            registeredPatient.setConsultationFee(Double.parseDouble(ConsultationFee));
            registeredPatient.setDateOfBirth(Day + "/" + Mon + "/" + Year);
            registeredPatient.setWeight(Weight);
            registeredPatient.setHeight(Height);
            registeredPatient.setRequestedConsultant(RequestedConsultant);
            registeredPatient.setMedicalHistory(MedicalReports);
            registeredPatient.setMobileNumber(PhoneNumber);
            registeredPatient.setObservation(Observation);
            registeredPatient.setPhotograph(imageBytes);

            RegisterPatientService registerPatientService = ServiceUtils.getRegisteredPatientService();
            registerPatientService.create(registeredPatient);

            AppUser appUser = new AppUser();
            appUser.setUserName(Username);
            appUser.setAnswer(registeredPatient.getDateOfBirth());
            appUser.setPassword("password");
            appUser.setSecurityQuestion("What is your date of birth?");
            appUser.setUserRole("patient");

            AppUserService appUserService = ServiceUtils.getAppUserService();
            appUserService.create(appUser);

            request.setAttribute("success", "Patient Created Successfull..");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
            dispatcher.forward(request, response);



        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
