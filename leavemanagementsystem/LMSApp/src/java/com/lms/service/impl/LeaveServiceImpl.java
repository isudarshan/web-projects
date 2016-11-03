/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service.impl;

import com.lms.domain.sub.StaffLeave;
import com.lms.service.LeaveService;
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
public class LeaveServiceImpl extends ServiceImpl implements LeaveService {

    private static Logger LOG = Logger.getLogger(LeaveServiceImpl.class);
    private static LeaveServiceImpl leaveServiceImpl = new LeaveServiceImpl();

    private LeaveServiceImpl() {
    }

    public static LeaveService getInstance() {
        return leaveServiceImpl;
    }

    public void create(StaffLeave staffLeave) {
        LOG.debug(staffLeave);

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(staffLeave);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("LeaveServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public StaffLeave findByEmployeeId(String employeeId) {
        StaffLeave staffLeave = null;
        Session session = HibernateUtils.currentSession();

        try {

            Query query = session.createQuery("from StaffLeave staffLeave where staffLeave.employeeId=:employeeId");
            query.setParameter("employeeId", employeeId);
            staffLeave = (StaffLeave) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("LeaveServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return staffLeave;
    }

    public List<StaffLeave> getAll() {
        List<StaffLeave> staffLeaveList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from StaffLeave staffLeave");
            staffLeaveList = query.list();
        } catch (Exception exception) {
            LOG.debug("LeaveServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return staffLeaveList;
    }

    public List<StaffLeave> findEmployees(String employeeId) {
        List<StaffLeave> staffLeaveList = null;
        Session session = HibernateUtils.currentSession();
        try {

            Query query = session.createQuery("from StaffLeave staffLeave where staffLeave.employeeId=:employeeId");
            query.setParameter("employeeId", employeeId);
            staffLeaveList = query.list();
        } catch (Exception exception) {
            LOG.debug("LeaveServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return staffLeaveList;
    }

    public void delete(Integer id) {
        Session session = HibernateUtils.currentSession();

         Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            StaffLeave staffLeave = (StaffLeave) session.get(StaffLeave.class, id);

            if(staffLeave!=null) {
                session.delete(staffLeave);
            }
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("LeaveServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }
}
