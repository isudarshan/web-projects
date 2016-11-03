/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class AttendanceServiceImpl extends ServiceImpl implements AttendanceService {
    private static Logger LOG = Logger.getLogger(AttendanceServiceImpl.class);
    private static AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();

    private AttendanceServiceImpl() {
    }

    public static AttendanceService getInstance() {
        return attendanceServiceImpl;
    }

    public void create(Attendance attendance) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx =  session.beginTransaction();
            session.saveOrUpdate(attendance);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("AttendanceServiceImpl", exception);
        } finally {

            if(tx!=null && rollback) {
                tx.rollback();
            }

            HibernateUtils.closeSession();
        }
    }

    public Attendance findById(String year, String branch, String semsiter, String paper) {

        LOG.debug("====Year"+year+" Branch"+branch+" Sem"+semsiter+" Paper"+paper);
        Attendance attendance = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Attendance attendance where attendance.branch=:branch and attendance.year=:year and attendance.semister=:semister and attendance.paper=:paper");
            query.setParameter("branch", branch.trim());
            query.setParameter("year", year.trim());
            query.setParameter("semister", semsiter.trim());
            query.setParameter("paper", paper.trim());
            attendance = (Attendance) query.uniqueResult();
            LOG.debug("Attendance Object in Service ======"+attendance);
        }catch(Exception exception) {
            LOG.debug("AttendanceServiceImpl",exception);
        }finally {
            HibernateUtils.closeSession();
        }
        return attendance;
    }

  

}
