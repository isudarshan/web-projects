/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;


import com.lms.domain.sub.StaffLeave;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface LeaveService extends Service {

    void create(StaffLeave staffLeave);

    StaffLeave findByEmployeeId(String employeeId);

    List<StaffLeave> getAll();

    List<StaffLeave> findEmployees(String employeeId);

    void delete(Integer id);
}
