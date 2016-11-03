/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.service.impl;

import com.dmsapp.domain.sub.Branch;
import com.dmsapp.service.BranchService;
import com.dmsapp.utils.hibernate.HibernateUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sudarsan
 */
public class BranchServiceImpl extends ServiceImpl implements BranchService {

    private static Logger LOG = Logger.getLogger(BranchServiceImpl.class);
    private static BranchServiceImpl branchServiceImpl = new BranchServiceImpl();

    private BranchServiceImpl() {
    }

    public static BranchService getInstance() {
        return branchServiceImpl;
    }

    public void create(Branch branch) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Branch> getAll() {
        List<Branch> branchList = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Branch branch");
            branchList = query.list();
        } catch (Exception exception) {
            LOG.warn("BranchServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }

        return branchList;
    }
}
