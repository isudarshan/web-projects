/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.service.impl;

import com.asiapp.domain.sub.Department;
import com.asiapp.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl implements DepartmentService {

    private static DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();
    private static Logger LOG = Logger.getLogger(DepartmentServiceImpl.class);
    private DepartmentServiceImpl() {
        
    }

    public static DepartmentService getInstance() {
        return departmentServiceImpl;
    }
    public void create(Department department) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(department);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("DepartmentServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public Department findByDepartmentName(String departmentName) {

        Department department = null;
           Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Department department where department.departmentName=:departmentName");
            query.setParameter("departmentName", departmentName);
            department = (Department) query.uniqueResult();
        }catch(Exception exception){
            LOG.debug("DepartmentServiceImpl", exception);
        }finally {
            HibernateUtils.closeSession();
        }
        return department;
    }

    public List<Department> getAll() {
       List<Department> departmentList = null;
       Session session = HibernateUtils.currentSession();
       try {
           Query query = session.createQuery("from Department department");
           departmentList = query.list();
       }catch(Exception exception){
           LOG.debug("DepartmentServiceImpl", exception);
       }finally {
           HibernateUtils.closeSession();
       }
       return departmentList;
    }



}
