/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.Subject;
import com.asiapp.service.SubjectService;
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
public class SubjectServiceImpl extends ServiceImpl implements SubjectService {

    private static SubjectServiceImpl subjectServiceImpl = new SubjectServiceImpl();
    private static Logger LOG = Logger.getLogger(SubjectServiceImpl.class);

    private SubjectServiceImpl() {
    }

    public static SubjectService getInstance() {
        return subjectServiceImpl;
    }

    public void create(Subject subject) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(subject);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("SubjectServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public List<Subject> getAll() {
        List<Subject> subjectList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Subject subject");
            subjectList = query.list();
        } catch (Exception exception) {
            LOG.debug("SubjectServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return subjectList;
    }

    public Subject findBySubjectName(String subjectName) {

        Subject subject = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Subject subject where subject.subjectName=:subjectName");
            query.setParameter("subjectName", subjectName);
            subject = (Subject) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("SubjectServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return subject;
    }

    public List<Subject> find(String departmentName, String year, String semister) {

        Session session = HibernateUtils.currentSession();
        List<Subject> subjectList = null;

        try {
            Query query = session.createQuery("from Subject subject where subject.departmentName=:departmentName and subject.year=:year and subject.semister=:semister");
            query.setParameter("departmentName", departmentName);
            query.setParameter("year", year);
            query.setParameter("semister", semister);
            subjectList = query.list();
        } catch (Exception exception) {
            LOG.debug("SubjectServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return subjectList;
    }
}
