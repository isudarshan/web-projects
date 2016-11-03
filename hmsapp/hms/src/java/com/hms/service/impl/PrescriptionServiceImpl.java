/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.Prescription;
import com.hms.service.PrescriptionService;
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
public class PrescriptionServiceImpl implements PrescriptionService{
public static  PrescriptionServiceImpl prescriptionServiceImpl = new PrescriptionServiceImpl();
    private PrescriptionServiceImpl() {
    }
    public static PrescriptionService getInstance(){
        return prescriptionServiceImpl;
    }

     
    @Override
    public void create(Prescription prescription) {
         Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(prescription);
            tx.commit();
            rollBack = false;
        } catch (Exception exception) {
            exception.printStackTrace();


        } finally {
            if (rollBack && tx != null) {
                tx.rollback();
                HibernateUtils.closeSession();
            }
        }
    }

    @Override
    public List<Prescription> getAll() {
         Session session = HibernateUtils.currentSession();
        List<Prescription> prescriptions = new ArrayList<Prescription>();
        try {
            Query query = session.createQuery("from Prescription prescription");
            prescriptions = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return prescriptions;
    }

    @Override
    public List<Prescription> getPrescriptionByPatientName(String patientName) {
        Session session = HibernateUtils.currentSession();
       List<Prescription> prescriptions= new ArrayList<Prescription>();
        try{
            Query query = session.createQuery("from Prescription prescription where prescription.patientName=:patientName");
            query.setParameter("patientName", patientName);
            prescriptions = query.list();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
      return prescriptions;
    }
    
    
}
