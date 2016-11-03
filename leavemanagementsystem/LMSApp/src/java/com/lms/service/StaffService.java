/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;

import com.lms.domain.sub.Staff;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface StaffService extends Service{

    void create(Staff staff);

    Staff findByEmployeeId(String employeeId);

    List<Staff> getAll();

    void remove(String employeeId);
}
