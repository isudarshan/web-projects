
package org.bankapp.bankservices.impl;

import java.util.List;
import org.bankapp.bankservices.DummyService;
import org.apache.log4j.Logger;
import org.bankapp.domain.Dummy;
import org.bankapp.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class DummyServiceImpl implements DummyService {

    private static final Logger LOG = Logger.getLogger(DummyServiceImpl.class);
    private static final DummyServiceImpl IMPL = new DummyServiceImpl();

    private DummyServiceImpl() {

    }

    public static DummyService getDummyService() {
        return IMPL;
    }

    @Override
    public void create(Dummy dummy) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(dummy);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("", exception);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }

    }

    public List<Dummy> getAll() {
        List<Dummy> list = null;

        Session session = HibernateUtils.currentSession();
        try {
            Query query = session.createQuery("from Dummy");
            list = query.list();
        } catch (Exception exception) {
            LOG.warn("", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return list;
    }

    public void delete(Dummy dummy) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.delete(dummy);
            tx.commit();
            rollback = false;
        } catch (Exception ex) {
            LOG.debug("", ex);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }

    public Dummy getDummy(Long id) {
        Dummy dummy = null;
        try {
            Session session = HibernateUtils.currentSession();
            dummy = (Dummy) session.get(Dummy.class, id);
            HibernateUtils.closeSession();
        } catch (Exception ex) {
            LOG.debug("Dummy not Found :" + id);
            LOG.warn("", ex);
        }
        return dummy;
    }

}
