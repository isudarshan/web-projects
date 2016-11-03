/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.service;

import com.dmsapp.domain.sub.TypeOne;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface TypeOneService {

    void create(TypeOne marks);

    TypeOne checkStatus(String studentId, String branch, String year, String semister, String paper);

    List<TypeOne> getMarks(String year, String branch, String semister, String paper);

    TypeOne findById(Integer id);
    
}
