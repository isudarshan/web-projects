/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.TypeTwo;
import com.dmsapp.service.TypeTwoService;
import com.dmsapp.utils.hibernate.HibernateUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class TypeTwoServiceImpl extends ServiceImpl implements TypeTwoService {

    private static TypeTwoServiceImpl typeTwoServiceImpl = new TypeTwoServiceImpl();
    private static Logger LOG = Logger.getLogger(TypeTwoServiceImpl.class);

    private TypeTwoServiceImpl() {
    }

    public static TypeTwoService getInstance() {
        return typeTwoServiceImpl;
    }

    public TypeTwo findById(Integer id) {

        TypeTwo typeTwo = null;

        Session session = HibernateUtils.currentSession();
        try {

            typeTwo = (TypeTwo) session.get(TypeTwo.class, id);
        } catch (Exception exception) {
            LOG.debug("TypeTwoServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return typeTwo;
    }

    public TypeTwo checkStatus(String studentId, String branch, String year, String semister, String paper) {
        Session session = HibernateUtils.currentSession();
        TypeTwo marks = null;
        try {
            Query query = session.createQuery("from TypeTwo typeTwo where typeTwo.studentId=:studentId and typeTwo.branch=:branch and typeTwo.year=:year and typeTwo.semister=:semister and typeTwo.paper=:paper");
            query.setParameter("studentId", studentId.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("year", year.trim());
            query.setParameter("semister", new Integer(semister));
            query.setParameter("paper", paper.trim());
            marks = (TypeTwo) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("TypeTwoServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return marks;
    }

    public void create(TypeTwo marks) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(marks);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("TypeTwoServiceImpl", exception);
        } finally {

            if (tx != null && rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }

    }

    public List<TypeTwo> getMarks(String year, String branch, String semister, String paper) {
        List<TypeTwo> marksList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from TypeTwo typeTwo where typeTwo.year=:year and typeTwo.branch=:branch and typeTwo.semister=:semister and typeTwo.paper=:paper");
            query.setParameter("year", year.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("semister", new Integer(semister));
            query.setParameter("paper", paper.trim());
            marksList = query.list();

        } catch (Exception exception) {
            LOG.debug("TypeOneServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return marksList;
    }
}
