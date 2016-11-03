/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.LabAdmin;
import com.hms.service.LabAdminService;
import com.hms.utils.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cmc
 */
public class LabAdminServiceImpl implements LabAdminService{
public static LabAdminServiceImpl labAdminServiceImpl = new LabAdminServiceImpl();
private LabAdminServiceImpl(){
    
}
public static LabAdminService getInstance(){
    return labAdminServiceImpl;
}
    @Override
    public void create(LabAdmin labAdmin) {
         Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(labAdmin);
            tx.commit();
            rollBack = false;
        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();

        } finally {
            if (rollBack && tx != null) {
                tx.rollback();
                HibernateUtils.closeSession();
            }
    }
    
    }

    @Override
    public List<LabAdmin> getAll() {
       Session session = HibernateUtils.currentSession();
        List<LabAdmin> labAdminList = new ArrayList<LabAdmin>();
        try {
            Query query = session.createQuery("from LabAdmin labAdmin");
            labAdminList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return labAdminList;
}

    @Override
    public LabAdmin get(Long id) {
       Session session=HibernateUtils.currentSession();
       LabAdmin labAdmin = null;
       try{
           Query query=session.createQuery("from LabAdmin labAdmin where labAdmin.id=:id");
           query.setParameter("id", id);
           
           labAdmin = (LabAdmin)query.uniqueResult();
                   
       }catch(Exception exception){
           exception.printStackTrace();
       } HibernateUtils.closeSession();
       return labAdmin;
    }

    @Override
    public List<LabAdmin> getByName(String patientName) {
        Session session = HibernateUtils.currentSession();
        List<LabAdmin> labAdminList = new ArrayList<LabAdmin>();
        try {
            Query query = session.createQuery("from LabAdmin labAdmin where labAdmin.patientName=:patientName");
            query.setParameter("patientName", patientName);
            labAdminList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return labAdminList;
    }

    @Override
    public List<LabAdmin> getByDoctor(String doctorName) {
     Session session = HibernateUtils.currentSession();
        List<LabAdmin> labAdminList = new ArrayList<LabAdmin>();
        try {
            Query query = session.createQuery("from LabAdmin labAdmin where labAdmin.doctorName=:doctorName");
            query.setParameter("doctorName", doctorName);
            labAdminList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return labAdminList;
    }

    @Override
    public List<LabAdmin> getByUserName(String userName) {
      Session session = HibernateUtils.currentSession();
        List<LabAdmin> labAdminList = new ArrayList<LabAdmin>();
        try {
            Query query = session.createQuery("from LabAdmin labAdmin where labAdmin.userName=:userName");
            query.setParameter("userName", userName);
            labAdminList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return labAdminList;
    }
    }


