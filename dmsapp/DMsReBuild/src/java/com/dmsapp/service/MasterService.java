/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.service;

import com.dmsapp.domain.sub.Master;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface MasterService extends Service{

   List<Master> findBy(String year, String branch, String semister);

    List<Master> getAll();

    Master findByPaperName(String paper,String year, String branch, String sem);

    Boolean create(Master master);

    List<Master> getStudentsByPage(int pageSize, int page, String sidx, String sord);

    int getNoOfRecords() ;

    Boolean delete(Master master);
}
