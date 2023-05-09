package ir.dotin.facilitiesdemo.repository;

import ir.dotin.facilitiesdemo.models.LegalCustomer;
import ir.dotin.facilitiesdemo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LegalCustomerDao {

    public void saveCustomer(LegalCustomer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }

    public void updateCustomer(LegalCustomer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }

    public void deleteCustomer(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            LegalCustomer customer = session.get(LegalCustomer.class, id);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        }
    }

    public LegalCustomer getCustomer(int id) {
        Transaction transaction = null;
        LegalCustomer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            customer = session.get(LegalCustomer.class, id);
            transaction.commit();
        }
        return customer;
    }

    public List<LegalCustomer> getAllCustomer() {
        Transaction transaction = null;
        List<LegalCustomer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            customers = session.createQuery("from LegalCustomer ").getResultList();
            transaction.commit();
        }
        return customers;
    }

    public List<LegalCustomer> searchCustomerByName(String name) {
        String hql = "from LegalCustomer c where c.companyName like :name";
        List<LegalCustomer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            customers = query.list();
        }
        return customers;
    }



}
