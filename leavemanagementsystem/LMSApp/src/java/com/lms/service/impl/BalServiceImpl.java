/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service.impl;

import com.lms.domain.sub.Bal;
import com.lms.service.BalService;
import com.lms.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class BalServiceImpl extends ServiceImpl implements BalService {

    private static Logger LOG = Logger.getLogger(BalServiceImpl.class);
    private static BalServiceImpl balServiceImpl = new BalServiceImpl();

    public static BalService getInstance() {
        return balServiceImpl;
    }

    private BalServiceImpl() {
    }

    public void create(Bal bal) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(bal);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("BalServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public Bal findByEmployeeId(String employeeId) {
        Bal bal = null;
        Session session = HibernateUtils.currentSession();

        try {

            Query query = session.createQuery("from Bal bal where bal.employeeId=:employeeId");
            query.setParameter("employeeId", employeeId);
            bal = (Bal) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("BalServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return bal;
    }
}
