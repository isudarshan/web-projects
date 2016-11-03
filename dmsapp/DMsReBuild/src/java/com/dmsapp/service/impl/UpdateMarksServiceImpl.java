/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.MarksMaster;
import com.dmsapp.domain.sub.UpdateObject;
import com.dmsapp.service.UpdateMarksService;
import com.dmsapp.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sudarsan
 */
public class UpdateMarksServiceImpl extends ServiceImpl implements UpdateMarksService {

    private static Logger LOG = Logger.getLogger(UpdateMarksServiceImpl.class);
    private static UpdateMarksServiceImpl updateMarksServiceImpl = new UpdateMarksServiceImpl();

    private UpdateMarksServiceImpl() {
    }

    public static UpdateMarksService getInstance() {
        return updateMarksServiceImpl;
    }

    public MarksMaster findByStudentId(String studentId, String branch, String year, String semister, String paper) {

        LOG.debug(studentId + " " + year + " " + branch + " " + " " + semister + " " + paper + " ");
        UpdateObject updateObject = null;
        MarksMaster marksMaster = null;
        Session session = HibernateUtils.currentSession();
        try {


            LOG.debug("In One");
            Query query = session.createQuery("from MarksMaster marksMaster where marksMaster.studentId=:studentId and marksMaster.year=:year and marksMaster.branch=:branch and marksMaster.semister=:semister and marksMaster.paper=:paper");
            query.setParameter("studentId", studentId.trim());
            query.setParameter("year", year.trim());
            query.setParameter("branch", branch.trim());
            query.setParameter("semister", semister.trim());
            query.setParameter("paper", paper.trim());

            marksMaster = (MarksMaster) query.uniqueResult();





        } catch (Exception exception) {
            LOG.debug("UpdateMarksServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return marksMaster;
    }
}
