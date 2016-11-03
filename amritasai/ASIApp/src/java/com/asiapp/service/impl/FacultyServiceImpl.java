/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.Faculty;
import com.asiapp.service.FacultyService;
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
public class FacultyServiceImpl extends ServiceImpl implements FacultyService {

    private static FacultyServiceImpl facultyServiceImpl = new FacultyServiceImpl();
    private static Logger LOG = Logger.getLogger(FacultyServiceImpl.class);

    private FacultyServiceImpl() {
    }

    public static FacultyService getInstance() {
        return facultyServiceImpl;
    }

    public void create(Faculty faculty) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(faculty);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("FacultyServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public List<Faculty> getAll() {
        List<Faculty> facultyList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Faculty faculty");
            facultyList = query.list();
        } catch (Exception exception) {
            LOG.debug("FacultyServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return facultyList;
    }
}
