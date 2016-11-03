/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service;

import com.dmsapp.domain.sub.TypeTwo;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface TypeTwoService extends Service {

    void create(TypeTwo marks);

    TypeTwo checkStatus(String studentId, String branch, String year, String semister, String paper);

    List<TypeTwo> getMarks(String year, String branch, String semister, String paper);

    TypeTwo findById(Integer id);
}
