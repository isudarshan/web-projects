/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.service.impl;

import com.hms.domain.sub.Pharmacist;
import com.hms.service.PharmacistService;
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
public class PharmacistServiceImpl implements PharmacistService{

    @Override
    public void create(Pharmacist pharmacist) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(pharmacist);
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
    public List<Pharmacist> getrAll() {
Session session = HibernateUtils.currentSession();
        List<Pharmacist> pharmacists = new ArrayList<Pharmacist>();
        try {
            Query query = session.createQuery("from Pharmacist pharmacist");
            pharmacists = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return pharmacists;
    }

    @Override
    public Pharmacist getByName(String pharmacistName) {
       Session session = HibernateUtils.currentSession();
        Pharmacist pharmacist = null;
        try{

         Query query = session.createQuery("from Pharmacist pharmacist where pharmacist.pharmacistName=:pharmacistName");
        query.setParameter("pharmacistName", pharmacistName);
        pharmacist = (Pharmacist) query.uniqueResult();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return pharmacist;
    }

}
