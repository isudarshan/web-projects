package org.bankapp.bankservices.impl;


import java.util.List;
import org.apache.log4j.Logger;
import org.bankapp.bankservices.BankServices;
import org.bankapp.domain.Balance;
import org.bankapp.domain.Bankuser;
import org.bankapp.domain.Customer;
import org.bankapp.domain.Details;
import org.bankapp.utils.HibernateUtils;
import org.bankapp.web.utils.MailUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankServicesImpl implements BankServices {

    private static final Logger LOG = Logger.getLogger(BankServicesImpl.class);
    private static BankServicesImpl IMPL = new BankServicesImpl();

    public static BankServices getInstance() {
        return IMPL;
    }

    private BankServicesImpl() {
    }

    public void createAccount(Customer customer) {

        boolean rollback = true;
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
            rollback = false;
            MailUtils.mail(customer);

        } catch (Exception ex) {
            LOG.debug(ex);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();

            }
            HibernateUtils.closeSession();
        }
    }

    public void deleteAccount(Customer customer) {
        boolean rollback = true;
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(customer);
            tx.commit();
            rollback = false;

        } catch (Exception e) {
            LOG.debug(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();

            }
        }

        HibernateUtils.closeSession();

    }

    public void changeAccountDetails(Customer customer) {
        boolean rollback = true;
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.merge(customer);
            tx.commit();
            rollback = false;
        } catch (Exception e) {
            LOG.debug(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
        }

        HibernateUtils.closeSession();

    }

    public void createDebitCard(Customer customer) {
        // TODO
    }

    public void createCreditCard(Customer customer) {
        // TODO
    }

    public List<Customer> retrieveList() {
        List<Customer> list = null;

        try {
            Session session = HibernateUtils.currentSession();
            Query query = session.createQuery("from Customer");
            list = query.list();
            HibernateUtils.closeSession();
        } catch (Exception e) {
            LOG.debug(e);
        }

        return list;


    }

    public Customer getCustomerById(Long id) {
        Customer customer = null;

        try {
            Session session = HibernateUtils.currentSession();
            Query q = session.createQuery("from Customer customer where customer.customerId=:customerId");
            q.setParameter("customerId", new Long(id));
            customer = (Customer) q.uniqueResult();
        } catch (Exception e) {
            LOG.debug(e);
        }

        HibernateUtils.closeSession();
        return customer;
    }

    public Bankuser getBankUserById(Long userId) {

        Bankuser bankuser = null;

        try {
            Session session = HibernateUtils.currentSession();
            Query q = session.createQuery("from Bankuser bankUser where bankUser.userId=:userId");
            q.setParameter("userId", new Long(userId));
            bankuser = (Bankuser) q.uniqueResult();
        } catch (Exception e) {
            LOG.debug(e);
        }

        HibernateUtils.closeSession();
        return bankuser;

    }

    public Balance getBalanceByAcctId(Long accountId) {
        Balance balance = null;

        try {
            Session session = HibernateUtils.currentSession();
            Query q = session.createQuery("from Balance balance where balance.accountId=:acctId");
            q.setParameter("acctId", new Long(accountId));
            balance = (Balance) q.uniqueResult();
        } catch (Exception e) {
            LOG.debug(e);
        }

        HibernateUtils.closeSession();
        return balance;
    }

    public void changeAccountDetails(Bankuser bankuser) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;

        try {
            tx = session.beginTransaction();
            session.merge(bankuser);
            tx.commit();
            rollback = false;
        } catch (Exception e) {
            LOG.debug(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();

            }
        }
        HibernateUtils.closeSession();
    }

    public void changeAccountDetails(Balance balance) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;

        try {
            tx = session.beginTransaction();
            session.merge(balance);
            tx.commit();
            rollback = false;
        } catch (Exception e) {
            LOG.debug(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
        }

        HibernateUtils.closeSession();
    }

    public String withdrawMoney(Long accountId, Double amount) {

        //Customer c = new Customer();
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        String status = null;

        try {
            tx = session.beginTransaction();
            Balance balance = getBalanceByAcctId(accountId);
            if (balance != null) {
                Query q = session.createQuery("from Customer customer where customer.accountId=:accountId");
                q.setParameter("accountId", balance);
                Customer c = (Customer) q.uniqueResult();
                Double minBal = c.getDetaildId().getMinimumBalance();
                if ((balance.getBalance() - amount) < minBal) {
                    status = "Low Balance";
                } else {
                    balance.setBalance((balance.getBalance()) - amount);
                    session.merge(balance);
                    tx.commit();
                    rollback = false;
                    status = "Withdrawn";
                }
            }
        } catch (Exception e) {
            LOG.debug(e);
        } finally {

            if (rollback && tx != null) {
                tx.rollback();

            }
        }

        HibernateUtils.closeSession();
        return status;
    }

    public String depositMoney(Long accountId, Double amount) {

        Session session = HibernateUtils.currentSession();
        Transaction tx = session.beginTransaction();
        String status = null;
        boolean rollback = true;

        try {

            Balance balance = getBalanceByAcctId(accountId);
            if (balance != null) {
                balance.setBalance(balance.getBalance() + amount);
                session.merge(balance);
                tx.commit();
                rollback = false;
                status = "Deposited";
            }
        } catch (Exception e) {
            LOG.debug(e);
        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
        }

        HibernateUtils.closeSession();
        return status;
    }

    public Details getDetails(Long accountId) {

        Details details = null;
        try {
            Session session = HibernateUtils.currentSession();
            Balance balance = getBalanceByAcctId(accountId);
            if (balance != null) {
                Query q = session.createQuery("from Customer c where c.accountId=:acctId");
                q.setParameter("acctId", balance);
                Customer c = (Customer) q.uniqueResult();
                details = c.getDetaildId();
            }
        } catch (Exception e) {
            LOG.debug(e);
        }
        HibernateUtils.closeSession();
        return details;
    }

    private void sendPasswordMail(String eMail, Customer customer) {
        try {
            MailUtils.mail(eMail, customer);
        } catch (Exception e) {
            LOG.debug(e);
        }
    }

    public void forgetPassword(Long accountNumber) {
        try {
            Session session = HibernateUtils.currentSession();
            String mailId = null;
            Balance balance = getBalanceByAcctId(accountNumber);
            if (balance != null) {
                Query q = session.createQuery("from Customer c where c.accountId=:acctId");
                q.setParameter("acctId", balance);
                Customer customer = (Customer) q.uniqueResult();
                mailId = customer.getDetaildId().getEmailId();
                sendPasswordMail(mailId, customer);
            }
        } catch (Exception e) {
            LOG.debug(e);
        }
        HibernateUtils.closeSession();
    }
}
