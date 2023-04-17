package ir.dotin.facilitiesdemo.dao;

import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.util.HibernateUtil;
import ir.dotin.facilitiesdemo.models.GrantCondition;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GrantConditionDao {

    public void saveGrantCondition(GrantCondition grantCondition) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(grantCondition);
            transaction.commit();
        }
    }

    public void updateGrantCondition(GrantCondition grantCondition) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(grantCondition);
            transaction.commit();
        }
    }

    public void deleteGrantCondition(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            GrantCondition grantCondition = session.get(GrantCondition.class, id);
            if (grantCondition != null) {
                session.delete(grantCondition);
                System.out.println("Grant condition is deleted");
            }
            transaction.commit();
        }
    }

    public GrantCondition getGrantCondition(int id) {
        Transaction transaction = null;
        GrantCondition grantCondition = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            grantCondition = session.get(GrantCondition.class, id);
            transaction.commit();
        }
        return grantCondition;
    }

    public List<GrantCondition> getAllGrantCondition() {
        Transaction transaction = null;
        List<GrantCondition> grantConditions = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            grantConditions = session.createQuery("from GrantCondition ").getResultList();
            transaction.commit();
        }
        return grantConditions;
    }
}
