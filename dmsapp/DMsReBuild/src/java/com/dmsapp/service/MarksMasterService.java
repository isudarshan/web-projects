/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service;

import com.dmsapp.domain.sub.MarksMaster;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface MarksMasterService extends Service{

    void create(MarksMaster marksMaster);

    MarksMaster checkStatus(String studentId, String branch, String year, String semister, String paper);

    List<MarksMaster> getMarks(String year, String branch, String semister, String paper);

    MarksMaster findById(Integer id);
}
