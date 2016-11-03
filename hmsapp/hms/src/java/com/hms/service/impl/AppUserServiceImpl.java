/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.service.impl;

import com.hms.domain.sub.AppUser;
import com.hms.service.AppUserService;
import com.hms.utils.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cmc
 */
public class AppUserServiceImpl extends ServiceImpl implements AppUserService {

    private static AppUserServiceImpl appUserServiceImpl = new AppUserServiceImpl();

    private AppUserServiceImpl() {
    }

    public static AppUserService getInstance() {
        return appUserServiceImpl;
    }

    @Override
    public void create(AppUser appUser) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollBack = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(appUser);
            tx.commit();
            rollBack = false;
        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();

        } finally {
            if (rollBack && tx != null) {
                tx.rollback();
                HibernateUtils.closeSession();
            }
        }
    }

    @Override
    public List<AppUser> getAll() {
        Session session = HibernateUtils.currentSession();
        List<AppUser> appUserList = new ArrayList<AppUser>();
        try {
            Query query = session.createQuery("from AppUser appUser");
            appUserList = query.list();

        } catch (Exception exception) {
            exception.printStackTrace();
            HibernateUtils.closeSession();
        }
        HibernateUtils.closeSession();
        return appUserList;
    }

    @Override
    public AppUser authenticate(String userName, String password) {
        Session session = HibernateUtils.currentSession();
        AppUser appUser = null;
        try {
            Query query = session.createQuery("from AppUser appUser where appUser.userName=:userName and appUser.password=:password");
            query.setParameter("userName", userName);
            query.setParameter("password", password);
            appUser = (AppUser) query.uniqueResult();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }


        return appUser;
    }

    @Override
    public AppUser forgotPassword(String securityQuestion, String answer, String userName) {
        Session session = HibernateUtils.currentSession();
        AppUser appUser = null;
        try {
            Query query = session.createQuery("from AppUser appUser where appUser.userName=:userName and appUser.securityQuestion=:securityQuestion and appUser.answer=:answer");
            query.setParameter("userName", userName);
            query.setParameter("securityQuestion", securityQuestion);
            query.setParameter("answer", answer);
            appUser = (AppUser) query.uniqueResult();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }

        return appUser;

    }

    @Override
    public AppUser findByUserName(String userName) {

        Session session = HibernateUtils.currentSession();
        AppUser appUser = null;
        try {
            Query query = session.createQuery("from AppUser appUser where appUser.userName=:userName");
            query.setParameter("userName", userName);
            appUser = (AppUser) query.uniqueResult();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            HibernateUtils.closeSession();
        }

        return appUser;
    }
}
