/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.service;

import com.asiapp.domain.sub.FacultyMap;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface FacultyMapService extends Service {

    void create(FacultyMap facultyMap);

    List<FacultyMap> getAll();

    FacultyMap findFacultyBySubject(String subjectName);

    FacultyMap find(String departmentName, String year, String semister, String subjectName);
    
}
