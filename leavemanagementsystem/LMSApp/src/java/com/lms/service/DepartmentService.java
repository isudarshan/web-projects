/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service;


import com.lms.domain.sub.Department;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface DepartmentService extends Service{

    void create(Department department);

    List<Department> getAll();

    Department findByDepartmentName(String departmentName);
}
