/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service;

import com.asiapp.domain.sub.FeedBack;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface FeedBackService extends Service {

    void create(FeedBack feedBack);

    FeedBack checkForFeedBack(String studentId, String departmentName, String year, String semister, String subjectName);

    List<FeedBack> getTotalFeedBackPoints(String departmentName, String year, String semister, String subjectName, String facultyName);

}
