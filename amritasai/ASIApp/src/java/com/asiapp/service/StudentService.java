/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.service;

import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface StudentService extends Service {

    void create(Student student);

    Student findByStudentId(String studentId);

    List<Subject> getSubjects(String studentId);
}
