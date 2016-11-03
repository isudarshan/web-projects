/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.TypeOne;
import com.dmsapp.service.TypeOneService;
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
public class TypeOneServiceImpl extends ServiceImpl implements TypeOneService {

    private static Logger LOG = Logger.getLogger(TypeOneServiceImpl.class);
    private static TypeOneServiceImpl typeOneServiceImpl = new TypeOneServiceImpl();

    private TypeOneServiceImpl() {
    }

    public static TypeOneService getInstance() {
        return typeOneServiceImpl;
    }

    public TypeOne findById(Integer id) {

        TypeOne typeOne = null;

        Session session = HibernateUtils.currentSession();
        try {

            typeOne = (TypeOne) session.get(TypeOne.class, id);
        }catch(Exception exception) {
            LOG.debug("TypeOneServiceImpl", exception);
        }finally {
            HibernateUtils.closeSession();
        }
        return typeOne;
    }

    public void create(TypeOne marks) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(marks);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("TypeOneServiceImpl", exception);
        } finally {

            if (tx != null && rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }

    }

    public TypeOne checkStatus(String studentId, String branch, String year, String semister, String paper) {

        Session session = HibernateUtils.currentSession();
        TypeOne marks = null;
        try {
            Query query = session.createQuery("from TypeOne typeOne where typeOne.studentId=:studentId and typeOne.branch=:branch and typeOne.year=:year and typeOne.semister=:semister and typeOne.paper=:paper");
            query.setParameter("studentId", studentId.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("year", year.trim());
            query.setParameter("semister", new Integer(semister));
            query.setParameter("paper", paper.trim());
            marks = (TypeOne) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("TypeOneServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return marks;
    }

    public List<TypeOne> getMarks(String year, String branch, String semister, String paper) {
        List<TypeOne> marksList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from TypeOne typeOne where typeOne.year=:year and typeOne.branch=:branch and typeOne.semister=:semister and typeOne.paper=:paper");
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
