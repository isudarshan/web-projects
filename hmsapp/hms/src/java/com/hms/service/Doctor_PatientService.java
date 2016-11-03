/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.domain.sub.Doctor_Patient;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface Doctor_PatientService {
    
    void create(Doctor_Patient doctor_Patient);
    
    List<Doctor_Patient> getAll();
    
    List<Doctor_Patient> get(String doctorName);
    
    
}
