/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.RegisteredDoctor;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.RegisterPatientService;
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
public class RegisterPatientServiceImpl implements RegisterPatientService{
    
    public static RegisterPatientService registerPatientService = new RegisterPatientServiceImpl();
    
    private RegisterPatientServiceImpl(){
        
    }
    
    public static RegisterPatientService getInstance(){
        return registerPatientService;
    }

    @Override
    public void create(RegisteredPatient registeredPatient) {
     Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(registeredPatient);
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
    public List<RegisteredPatient> getAll() {
     Session session = HibernateUtils.currentSession();
     List<RegisteredPatient> patients = new ArrayList<RegisteredPatient>();
     try{
         Query query = session.createQuery("from RegisteredPatient registeredPatient");
         patients = query.list();
       
     }catch(Exception exception){
         exception.printStackTrace();
         
     }
     HibernateUtils.closeSession();
     return patients;
    }

    @Override
    public RegisteredPatient getPatient(Long id) {
        Session session = HibernateUtils.currentSession();
        RegisteredPatient registeredPatient = null;
        try{
           
         Query query = session.createQuery("from RegisteredPatient registeredPatient where registeredPatient.id=:id");
        query.setParameter("id", id);
        registeredPatient = (RegisteredPatient) query.uniqueResult();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return registeredPatient;
    }

    @Override
    public RegisteredPatient getPatientByName(String firstName) {
        Session session = HibernateUtils.currentSession();
        RegisteredPatient registeredPatient = null;
        try{
           
         Query query = session.createQuery("from RegisteredPatient registeredPatient where registeredPatient.firstName=:firstName");
        query.setParameter("firstName", firstName);
        registeredPatient = (RegisteredPatient) query.uniqueResult();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return registeredPatient;
    }

    @Override
    public RegisteredPatient getPatientbyPatientId(String patientId) {
       Session session = HibernateUtils.currentSession();
        RegisteredPatient registeredPatient = null;
        try{

         Query query = session.createQuery("from RegisteredPatient registeredPatient where registeredPatient.patientId=:patientId");
        query.setParameter("patientId", patientId);
        registeredPatient = (RegisteredPatient) query.uniqueResult();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return registeredPatient;
    }
    }

   
   
   
      
    
    
    

