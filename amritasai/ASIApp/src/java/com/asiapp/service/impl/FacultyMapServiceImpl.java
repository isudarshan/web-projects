/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.FacultyMap;
import com.asiapp.service.FacultyMapService;
import com.asiapp.utils.hibernate.HibernateUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class FacultyMapServiceImpl extends ServiceImpl implements FacultyMapService {

    private static FacultyMapServiceImpl facultyMapServiceImpl = new FacultyMapServiceImpl();
    private static Logger LOG = Logger.getLogger(FacultyMapServiceImpl.class);

    private FacultyMapServiceImpl() {
    }

    public static FacultyMapService getInstance() {
        return facultyMapServiceImpl;
    }

    public void create(FacultyMap facultyMap) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(facultyMap);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("FacultyMapServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public List<FacultyMap> getAll() {
        List<FacultyMap> facultyMapList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from FacultyMap facultyMap");
            facultyMapList = query.list();
        } catch (Exception exception) {
            LOG.debug("FacultyMapServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return facultyMapList;
    }

    public FacultyMap findFacultyBySubject(String subjectName) {
        FacultyMap facultyMap = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from FacultyMap facultyMap where facultyMap.subjectName=:subjectName");
            query.setParameter("subjectName", subjectName);
            facultyMap = (FacultyMap) query.uniqueResult();

        } catch (Exception exception) {
            LOG.debug("FacultyMapServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }


        return facultyMap;
    }

    public FacultyMap find(String departmentName, String year, String semister, String subjectName) {
        FacultyMap facultyMap = null;

        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from FacultyMap facultyMap where facultyMap.departmentName=:departmentName and facultyMap.year=:year and facultyMap.semister=:semister and facultyMap.subjectName=:subjectName");
            query.setParameter("departmentName", departmentName);
            query.setParameter("year", year);
            query.setParameter("semister", semister);
            query.setParameter("subjectName", subjectName);
            facultyMap = (FacultyMap) query.uniqueResult();

        }catch(Exception exception){
            LOG.debug("FacultyMapServiceImpl", exception);
        }finally {
            HibernateUtils.closeSession();
        }

        return facultyMap;
    }

}
