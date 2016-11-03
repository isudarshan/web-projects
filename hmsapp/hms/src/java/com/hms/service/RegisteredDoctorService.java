/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.domain.sub.RegisteredDoctor;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface RegisteredDoctorService {

    void create(RegisteredDoctor registeredDoctor);

    List<RegisteredDoctor> getAll();
    
    RegisteredDoctor get(String doctorId);
    
    List<RegisteredDoctor> getDoctorsBySpecialization(String specialization);
    
    RegisteredDoctor getDoctorByName(String firstName);


}
