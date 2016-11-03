/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.Master;
import com.dmsapp.service.MasterService;
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
public class MasterServiceImpl extends ServiceImpl implements MasterService {

    private static Logger LOG = Logger.getLogger(MasterServiceImpl.class);
    private static MasterServiceImpl masterServiceImpl = new MasterServiceImpl();
    private static int NO_OF_RECORDS;

    private MasterServiceImpl() {
        // SingleTon
    }

    public static MasterService getInstance() {
        return masterServiceImpl;
    }

    public List<Master> findBy(String year, String branch, String semister) {

        Session session = HibernateUtils.currentSession();
        List<Master> masterList = null;
        try {
            Query query = session.createQuery("from Master master where master.year=:year and master.branch=:branch and master.semister=:semister");
            query.setParameter("year", year.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("semister", semister);
            masterList = query.list();
        } catch (Exception exception) {
            LOG.warn("MasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return masterList;
    }

    public List<Master> getAll() {
        List<Master> masterList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Master master");
            masterList = query.list();
        } catch (Exception exception) {
            LOG.warn("MasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return masterList;
    }

    public Master findByPaperName(String paper, String year, String branch, String sem) {
        LOG.debug("Paper Name : " + paper + "Year : " + year + "Sem : " + sem);
        Master master = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Master master where master.paper=:paper and master.year=:year and master.branch=:branch and master.semister=:semister");
            query.setParameter("paper", paper.trim());
            query.setParameter("year", year.trim());
            query.setParameter("branch", branch);
            query.setParameter("semister", sem);
            master = (Master) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("MasterServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return master;
    }

    public Boolean create(Master master) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(master);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.debug("MasterSericeImpl", exception);
        } finally {
            if (tx != null & rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }

        return true;
    }

    public List<Master> getStudentsByPage(int pageSize, int page, String sidx, String sord) {
        Session session = HibernateUtils.currentSession();
        List<Master> list = null;
        try {

            Query query = session.createQuery("from Master order by " + sidx + " " + sord);
            NO_OF_RECORDS = query.list().size();
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            list = (List<Master>) query.list();
        } catch (Exception exception) {
            LOG.debug("MasterSericeImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return list;
    }

    public int getNoOfRecords() {
        return NO_OF_RECORDS;
    }

    public Boolean delete(Master master) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            Master impl = (Master) session.get(Master.class, master.getId());
            if (impl != null) {
                session.delete(impl);
                tx.commit();
                rollback = false;
            }


        } catch (Exception exception) {
            LOG.debug("MasterSericeImpl", exception);
        } finally {
            if (tx != null & rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }

        return true;
    }
}
