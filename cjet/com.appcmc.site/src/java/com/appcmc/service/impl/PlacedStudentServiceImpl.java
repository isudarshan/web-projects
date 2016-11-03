/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appcmc.service.impl;

import com.appcmc.domain.sub.PlacedStudent;
import com.appcmc.query.utils.PlacedStudentQueryUtils;
import com.appcmc.service.PlacedStudentService;
import com.appcmc.utils.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cmc
 */
public class PlacedStudentServiceImpl implements PlacedStudentService{
    
    private static Logger LOG = Logger.getLogger(AppUserServiceImpl.class);
    
    
    /**
     *
     * @param placedStudent
     */
    @Override
    public void create(PlacedStudent placedStudent){
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try{
            tx = session.beginTransaction();
            session.saveOrUpdate(placedStudent);
            tx.commit();
            rollback = false;
        }catch(Exception exception){
             LOG.warn("PlacedStudentServiceImpl", exception);
        }finally{
            if(rollback && tx != null){
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<PlacedStudent> getAll(){
          List<PlacedStudent> placedStudentList  = null;
        try{
            Session session = HibernateUtils.currentSession();
            Query query = session.createQuery(PlacedStudentQueryUtils.GETALL);
            placedStudentList = (List<PlacedStudent>) query.list();
        }catch(Exception exception){
            LOG.warn("PlacedStudentServiceImpl",exception);
        }finally{
             HibernateUtils.closeSession();
            }
        
        return placedStudentList;
    }
    
}
