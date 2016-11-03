/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.utils;

import com.hms.service.AppUserService;
import com.hms.service.Doctor_PatientService;
import com.hms.service.LabAdminService;
import com.hms.service.PrescriptionService;
import com.hms.service.RegisterPatientService;
import com.hms.service.RegisteredDoctorService;
import com.hms.service.impl.AppUserServiceImpl;
import com.hms.service.impl.Doctor_PatientServiceImpl;
import com.hms.service.impl.LabAdminServiceImpl;
import com.hms.service.impl.PrescriptionServiceImpl;
import com.hms.service.impl.RegisterPatientServiceImpl;
import com.hms.service.impl.RegisteredDoctorServiceImpl;

/**
 *
 * @author cmc
 */
public class ServiceUtils {
    
    
    public static AppUserService getAppUserService() {
        return AppUserServiceImpl.getInstance();
    }
    public static RegisteredDoctorService getRegisteredDoctorService(){
        return RegisteredDoctorServiceImpl.getInstance();
    }
     public static RegisterPatientService getRegisteredPatientService() {
        return RegisterPatientServiceImpl.getInstance();
    }
     public static  Doctor_PatientService getDoctor_PatientService(){
         return Doctor_PatientServiceImpl.getInstance();
     }
     public static  PrescriptionService getPrescriptionService(){
         return PrescriptionServiceImpl.getInstance();
     }
     public static LabAdminService getLabAdminService(){
         return LabAdminServiceImpl.getInstance();
     }
     
}
