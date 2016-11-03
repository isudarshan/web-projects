/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.FeedBack;
import com.asiapp.service.FeedBackService;
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
public class FeedBackServiceImpl extends ServiceImpl implements FeedBackService {

    private static FeedBackServiceImpl feedBackServiceImpl = new FeedBackServiceImpl();
    private static Logger LOG = Logger.getLogger(FeedBackServiceImpl.class);

    private FeedBackServiceImpl() {
    }

    public static FeedBackService getInstance() {
        return feedBackServiceImpl;
    }

    public void create(FeedBack feedBack) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(feedBack);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("FeedBackServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public FeedBack checkForFeedBack(String studentId, String departmentName, String year, String semister, String subjectName) {
        FeedBack feedBack = null;

        Session session = HibernateUtils.currentSession();

        try {

            Query query = session.createQuery("from FeedBack feedBack where feedBack.studentId=:studentId and feedBack.departmentName=:departmentName and feedBack.year=:year and feedBack.semister=:semister and feedBack.subjectName=:subjectName");
            query.setParameter("studentId", studentId);
            query.setParameter("departmentName", departmentName);
            query.setParameter("year", year);
            query.setParameter("semister", semister);
            query.setParameter("subjectName", subjectName);
            feedBack = (FeedBack) query.uniqueResult();
        }catch(Exception exception){
            exception.printStackTrace();
        }finally {
            HibernateUtils.closeSession();
        }
        
        return feedBack;
    }

    public List<FeedBack> getTotalFeedBackPoints(String departmentName, String year, String semister, String subjectName, String facultyName) {
        List<FeedBack> feedBackList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from FeedBack feedBack where feedBack.departmentName=:departmentName and feedBack.year=:year and feedBack.semister=:semister and feedBack.subjectName=:subjectName and feedBack.facultyName=:facultyName");
            query.setParameter("departmentName", departmentName);
            query.setParameter("year", year);
            query.setParameter("semister", semister);
            query.setParameter("subjectName", subjectName);
            query.setParameter("facultyName", facultyName);
            feedBackList = query.list();
        }catch(Exception exception) {
            exception.printStackTrace();
        }finally {
            HibernateUtils.closeSession();
        }

        return feedBackList;
    }
    
}
