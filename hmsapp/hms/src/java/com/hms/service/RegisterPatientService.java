/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;


import com.hms.domain.sub.RegisteredPatient;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface RegisterPatientService {

    void create(RegisteredPatient registeredPatient);

    List<RegisteredPatient> getAll();
    
    RegisteredPatient getPatient(Long id);

    RegisteredPatient getPatientbyPatientId(String patientId);

    
    RegisteredPatient getPatientByName(String firstName);
    
}
