/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.service;

import com.dmsapp.domain.sub.MarksMaster;

/**
 *
 * @author Sudarsan
 */
public interface UpdateMarksService extends Service{

    MarksMaster findByStudentId(String studentId, String branch, String year, String semister, String papaer);
}
