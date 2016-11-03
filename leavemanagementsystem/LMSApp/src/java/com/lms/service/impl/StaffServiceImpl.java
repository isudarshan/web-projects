/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service.impl;

import com.lms.domain.sub.Staff;
import com.lms.service.StaffService;
import com.lms.utils.hibernate.HibernateUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class StaffServiceImpl extends ServiceImpl implements StaffService {

    private static StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
    private static Logger LOG = Logger.getLogger(StaffServiceImpl.class);

    private StaffServiceImpl() {
    }

    public StaffService getInstance() {
        return staffServiceImpl;
    }

    public void create(Staff staff) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(staff);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("StaffServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public Staff findByEmployeeId(String employeeId) {
        Staff staff = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Staff staff where staff.employeeId=:employeeId");
            query.setParameter("employeeId", employeeId);
            staff = (Staff) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("StaffServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return staff;
    }

    public List<Staff> getAll() {
        List<Staff> staffList = null;

        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Staff staff");
            staffList = query.list();
        } catch (Exception exception) {
            LOG.debug("StaffServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return staffList;
    }

    public void remove(String employeeId) {
        

        Staff staff = findByEmployeeId(employeeId);
        
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();

            session.delete(staff);
            tx.commit();
            rollback = false;
        } catch (Exception e) {
            LOG.debug("StaffServiceImpl", e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }


    }
}
