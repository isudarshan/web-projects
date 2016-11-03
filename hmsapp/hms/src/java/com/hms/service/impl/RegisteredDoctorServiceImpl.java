/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.AppUser;
import com.hms.domain.sub.RegisteredDoctor;
import com.hms.service.RegisteredDoctorService;
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
public class RegisteredDoctorServiceImpl implements RegisteredDoctorService{
    private static RegisteredDoctorServiceImpl registeredDoctorServiceImpl = new RegisteredDoctorServiceImpl();
    private RegisteredDoctorServiceImpl(){

}
     public static RegisteredDoctorService getInstance() {
        return registeredDoctorServiceImpl;
    }
    

    @Override
    public void create(RegisteredDoctor registeredDoctor) {
   
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(registeredDoctor);
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
   public List<RegisteredDoctor> getAll(){
         Session session = HibernateUtils.currentSession();
        List<RegisteredDoctor> doctorList = new ArrayList<RegisteredDoctor>();
        try {
            Query query = session.createQuery("from RegisteredDoctor registeredDoctor");
           doctorList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return doctorList;
    }

    @Override
    public RegisteredDoctor get(String doctorId) {
        Session session = HibernateUtils.currentSession();
        RegisteredDoctor registeredDoctor = null;
        try{
            Query query = session.createQuery("from RegisteredDoctor registeredDoctor where registeredDoctor.doctorId=:doctorId");
            query.setParameter("doctorId", doctorId);
           
            registeredDoctor = (RegisteredDoctor) query.uniqueResult();
      
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }


        return registeredDoctor;
        }

    @Override
    public List<RegisteredDoctor> getDoctorsBySpecialization(String specialization) {
        Session session = HibernateUtils.currentSession();
        List<RegisteredDoctor> doctors = new ArrayList<RegisteredDoctor>();
        System.out.println("DoctorServiceImpl");
        try{
            Query query = session.createQuery("from RegisteredDoctor registeredDoctor where registeredDoctor.specialization=:specialization");
        query.setParameter("specialization", specialization);
        doctors = query.list();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return doctors;
    }

    @Override
    public RegisteredDoctor getDoctorByName(String firstName) {
     Session session = HibernateUtils.currentSession();
        RegisteredDoctor registeredDoctor = null;
        try{
            Query query = session.createQuery("from RegisteredDoctor registeredDoctor where registeredDoctor.firstName=:firstName");
            query.setParameter("firstName", firstName);
           
            registeredDoctor = (RegisteredDoctor) query.uniqueResult();
      
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }


        return registeredDoctor;
        }
    }
      
    
        
        
    

    

    
