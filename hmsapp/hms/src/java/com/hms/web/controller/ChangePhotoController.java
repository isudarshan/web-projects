/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.LabAdmin;
import com.hms.domain.sub.Pharmacist;
import com.hms.domain.sub.RegisteredDoctor;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.AppUserService;
import com.hms.service.LabAdminService;
import com.hms.service.PharmacistService;
import com.hms.service.RegisterPatientService;
import com.hms.service.RegisteredDoctorService;
import com.hms.service.impl.PharmacistServiceImpl;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author cmc
 */
public class ChangePhotoController extends HttpServlet {

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

            FileItem photograph = fileItems.get(1);
            byte[] imageBytes = photograph.get();

            if (error) {
                request.setAttribute("clientError", "All fields are mandatory!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/registerPatient.jsp");
                dispatcher.forward(request, response);
                return;
            }

            AppUserService appUserService = ServiceUtils.getAppUserService();
            AppUser appUser = appUserService.findByUserName(Username);

            if (appUser.getUserRole().equalsIgnoreCase("patient")) {

                RegisterPatientService patientService = ServiceUtils.getRegisteredPatientService();

                RegisteredPatient registeredPatient = patientService.getPatientByName(Username);


                registeredPatient.setPhotograph(imageBytes);
                registeredPatient.setModifiedOn(new java.util.Date());

                patientService.create(registeredPatient);

                request.setAttribute("success", "Photo Changed Successfully..");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/patientHome.jsp");
                dispatcher.forward(request, response);
            }



            if (appUser.getUserRole().equalsIgnoreCase("doctor")) {

                RegisteredDoctorService doctorService = ServiceUtils.getRegisteredDoctorService();

                RegisteredDoctor doctor = doctorService.getDoctorByName(Username);
                doctor.setPhotoGraph(imageBytes);
                doctor.setModifiedOn(new java.util.Date());

                doctorService.create(doctor);

                request.setAttribute("success", "Photo Changed Successfully..");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorHome.jsp");
                dispatcher.forward(request, response);
            }

            if (appUser.getUserRole().equalsIgnoreCase("labAdmin")) {


                LabAdminService adminService = ServiceUtils.getLabAdminService();
                List<LabAdmin> admin = adminService.getByUserName(Username);
                LabAdmin labAdmin = null;
                for (int i = 0; i < admin.size(); i++) {

                    labAdmin = admin.get(i);
                    labAdmin.setPhoto(imageBytes);
                }


                adminService.create(labAdmin);

                request.setAttribute("success", "Photo Changed Successfully..");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/labAdminHome.jsp");
                dispatcher.forward(request, response);
            }

             if (appUser.getUserRole().equalsIgnoreCase("pharmacist")) {


                PharmacistService service = new PharmacistServiceImpl();
                Pharmacist p = service.getByName(Username);

                p.setPharmacistName(Username);
                p.setPhotograph(imageBytes);

                service.create(p);

                request.setAttribute("success", "Photo Changed Successfully..");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pharmacyAdminHome.jsp");
                dispatcher.forward(request, response);
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
