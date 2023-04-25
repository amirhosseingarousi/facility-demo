package ir.dotin.facilitiesdemo.dao;

import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import ir.dotin.facilitiesdemo.util.HibernateUtil;
import ir.dotin.facilitiesdemo.models.Loan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LoanDao {

    public void saveLoan(Loan loan) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
        }
    }

    public void updateLoan(Loan loan) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.update(loan);
            transaction.commit();
        }
    }

    public void deleteLoan(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Loan loan = session.get(Loan.class, id);
            if (loan != null) {
                session.delete(loan);
                System.out.println("Loan is deleted");
            }
            transaction.commit();
        }
    }

    public Loan getLoan(int id) {
        Transaction transaction = null;
        Loan loan = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            loan = session.get(Loan.class, id);
            transaction.commit();
        }
        return loan;
    }

    public List<Loan> getAllLoan() {
        Transaction transaction = null;
        List<Loan> loans = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            loans = session.createQuery("from Loan").getResultList();
            transaction.commit();
        }
        return loans;
    }



}
