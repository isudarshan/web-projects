/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.service.MarksMasterService;
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
public class MarksMasterServiceImpl extends ServiceImpl implements MarksMasterService {

    private static Logger LOG = Logger.getLogger(MarksMasterServiceImpl.class);
    private static MarksMasterServiceImpl marksMasterServiceImpl = new MarksMasterServiceImpl();

    private MarksMasterServiceImpl() {
    }

    public static MarksMasterService getInstance() {
        return marksMasterServiceImpl;
    }

    public MarksMaster findById(Integer id) {

        MarksMaster marksMaster = null;

        Session session = HibernateUtils.currentSession();
        try {

            marksMaster = (MarksMaster) session.get(MarksMaster.class, id);
        } catch (Exception exception) {
            LOG.debug("MarksMasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return marksMaster;
    }

    public void create(MarksMaster marksMaster) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(marksMaster);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("MarksMasterServiceImpl", exception);
        } finally {

            if (tx != null && rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }

    }

    public MarksMaster checkStatus(String studentId, String branch, String year, String semister, String paper) {

        Session session = HibernateUtils.currentSession();
        MarksMaster marksMaster = null;
        try {
            Query query = session.createQuery("from MarksMaster marksMaster where marksMaster.studentId=:studentId and marksMaster.branch=:branch and marksMaster.year=:year and marksMaster.semister=:semister and marksMaster.paper=:paper");
            query.setParameter("studentId", studentId.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("year", year.trim());
            query.setParameter("semister", semister.trim());
            query.setParameter("paper", paper.trim());
            marksMaster = (MarksMaster) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("MarksMasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return marksMaster;
    }

    public List<MarksMaster> getMarks(String year, String branch, String semister, String paper) {
        List<MarksMaster> marksList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from MarksMaster marksMaster where marksMaster.year=:year and marksMaster.branch=:branch and marksMaster.semister=:semister and marksMaster.paper=:paper");
            query.setParameter("year", year.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("semister", semister.trim());
            query.setParameter("paper", paper.trim());
            marksList = query.list();

        } catch (Exception exception) {
            LOG.debug("MarksMasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return marksList;
    }
}
