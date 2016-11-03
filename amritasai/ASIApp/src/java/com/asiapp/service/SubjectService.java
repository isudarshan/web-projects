/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.service;

import com.asiapp.domain.sub.Subject;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface SubjectService extends Service{

    void create(Subject subject);

    List<Subject> getAll();

    Subject findBySubjectName(String subjectName);

    List<Subject> find(String departmentName, String year, String semister);
}
