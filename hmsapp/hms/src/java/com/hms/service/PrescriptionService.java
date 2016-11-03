/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.domain.sub.Prescription;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface PrescriptionService {
    
    void create(Prescription prescription);
    
    List<Prescription> getAll();
    
    List<Prescription> getPrescriptionByPatientName(String patientName);
    
    
    
}
