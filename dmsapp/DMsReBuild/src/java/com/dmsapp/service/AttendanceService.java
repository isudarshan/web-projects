/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.service;

import com.dmsapp.domain.sub.Attendance;

/**
 *
 * @author Sudarsan
 */
public interface AttendanceService extends Service{

    void create(Attendance attendance);

    Attendance findById(String year, String branch, String semsiter, String paper);
        
    
}
