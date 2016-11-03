/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lms.service.impl;

import com.lms.domain.sub.Remarks;
import com.lms.service.RemarksService;
import com.lms.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class RemarksServiceImpl extends ServiceImpl implements RemarksService{

    private static Logger LOG = Logger.getLogger(RemarksServiceImpl.class);
    private static RemarksServiceImpl remarksServiceImpl = new RemarksServiceImpl();
    private RemarksServiceImpl() {
    }

    public static RemarksService getInstance() {
        return remarksServiceImpl;
    }

    public void create(Remarks remarks) {
       Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(remarks);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("RemarksServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }


    



}
