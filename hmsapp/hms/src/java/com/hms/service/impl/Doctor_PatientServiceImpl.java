/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.Doctor_Patient;
import com.hms.domain.sub.RegisteredPatient;
import com.hms.service.Doctor_PatientService;
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
public class Doctor_PatientServiceImpl implements Doctor_PatientService {

    public static Doctor_PatientServiceImpl doctor_PatientServiceImpl = new Doctor_PatientServiceImpl();

    private Doctor_PatientServiceImpl() {
    }

    public static Doctor_PatientService getInstance() {
        return doctor_PatientServiceImpl;
    }

    @Override
    public void create(Doctor_Patient doctor_Patient) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(doctor_Patient);
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
    public List<Doctor_Patient> getAll() {
        Session session = HibernateUtils.currentSession();
        List<Doctor_Patient> doctor_Patients = new ArrayList<Doctor_Patient>();
        try {
            Query query = session.createQuery("from Doctor_Patient doctor_Patient");
            doctor_Patients = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();

        }
        HibernateUtils.closeSession();
        return doctor_Patients;

    }

    @Override
    public List<Doctor_Patient> get(String doctorName) {
        Session session = HibernateUtils.currentSession();
        List<Doctor_Patient> doctor_Patients = new ArrayList<Doctor_Patient>();
        try {
            Query query = session.createQuery("from Doctor_Patient doctor_Patient where doctor_Patient.doctorName=:doctorName");
            query.setParameter("doctorName", doctorName);
            doctor_Patients = query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        HibernateUtils.closeSession();
        return doctor_Patients;

    }
}
