/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.AppUser;
import com.asiapp.service.AppUserService;
import com.asiapp.utils.hibernate.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class AppUserServiceImpl extends ServiceImpl implements AppUserService {

    private static Logger LOG = Logger.getLogger(AppUserServiceImpl.class);
    private static AppUserServiceImpl appUserServiceImpl = new AppUserServiceImpl();

    private AppUserServiceImpl() {
    }

    public static AppUserService getInstance() {
        return appUserServiceImpl;
    }

    public void create(AppUser appUser) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(appUser);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("AppUserServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public AppUser authenticate(String userName, String password) {
        AppUser appUser = null;
        Session session = HibernateUtils.currentSession();

        try {

            Query query = session.createQuery("from AppUser appUser where appUser.userName=:userName and appUser.password=:password");
            query.setString("userName", userName);
            query.setString("password", password);
            appUser = (AppUser) query.uniqueResult();
        } catch (Exception exception) {
            LOG.warn("AppUserServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return appUser;
    }

    public AppUser findByUserName(String userName) {
        AppUser appUser = null;
        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from AppUser appUser where appUser.userName=:userName");
            query.setParameter("userName", userName);
            appUser = (AppUser) query.uniqueResult();
        } catch (Exception exception) {
            LOG.debug("AppUserServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return appUser;
    }
}
