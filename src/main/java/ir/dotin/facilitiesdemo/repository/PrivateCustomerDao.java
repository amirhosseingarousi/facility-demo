package ir.dotin.facilitiesdemo.repository;

import ir.dotin.facilitiesdemo.util.HibernateUtil;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class PrivateCustomerDao {

    public void saveCustomer(PrivateCustomer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            try {
                session.save(customer);
                transaction.commit();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCustomer(PrivateCustomer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deleteCustomer(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            PrivateCustomer customer = session.get(PrivateCustomer.class, id);
            if (customer != null) {
                session.delete(customer);
                System.out.println("Customer is deleted.");
            }

            transaction.commit();
        }
    }

    public PrivateCustomer getCustomer(int id) {
        Transaction transaction = null;
        PrivateCustomer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            customer = session.get(PrivateCustomer.class, id);
            transaction.commit();
        }
        return customer;
    }

    public PrivateCustomer getCustomerByNumber(String number) {
        Transaction transaction = null;
        PrivateCustomer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("from PrivateCustomer c where c.number = " + number);
            List<PrivateCustomer> privateCustomers = query.list();
            for (PrivateCustomer customer1 : privateCustomers) {
                int id = customer1.getId();
                String firstName = customer1.getFirstName();
                String lastName = customer1.getLastName();
                String fatherName = customer1.getFatherName();
                LocalDate dob = customer1.getDob();
                String nationalId = customer1.getNationalID();
                String customerNumber = customer1.getNumber();

                customer = new PrivateCustomer(id, firstName, lastName, fatherName, dob, nationalId, customerNumber);
            }
            transaction.commit();
        }
        return customer;
    }

    public List<PrivateCustomer> getAllCustomer() {
        Transaction transaction = null;
        List<PrivateCustomer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            customers = session.createQuery("from PrivateCustomer").getResultList();
            transaction.commit();
        }
        return customers;
    }

    public List<PrivateCustomer> searchCustomerByName(String name) {
        String hql = "from PrivateCustomer c where c.firstName like :name";
        List<PrivateCustomer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("name", "%" + name + "%");
            customers = query.list();
        }
        return customers;
    }

}
