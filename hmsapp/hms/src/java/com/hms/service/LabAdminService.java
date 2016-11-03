/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service;

import com.hms.domain.sub.LabAdmin;
import java.util.List;

/**
 *
 * @author cmc
 */
public interface LabAdminService {
    
    void create(LabAdmin labAdmin);
    
    List<LabAdmin> getAll();
    
    LabAdmin get(Long id);
    
    List<LabAdmin> getByName(String patientName);
    
     List<LabAdmin> getByDoctor(String doctorName);

     List<LabAdmin> getByUserName(String userName);
     
     LabAdmin get(String userName);


}
