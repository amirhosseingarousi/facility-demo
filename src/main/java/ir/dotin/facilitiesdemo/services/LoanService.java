package ir.dotin.facilitiesdemo.services;

import ir.dotin.facilitiesdemo.repository.LoanDao;
import ir.dotin.facilitiesdemo.models.Loan;

import java.util.List;

public class LoanService {
    private LoanDao loanDao;

    public LoanService() {
        loanDao = new LoanDao();
    }

    public List<Loan> getAllLoan() {
        return loanDao.getAllLoan();
    }

    public Loan getLoanById(int id) {
        return loanDao.getLoan(id);
    }

    public void addLoan(Loan loan) {
        loanDao.saveLoan(loan);
    }

    public void deleteLoanById(int id) {
        loanDao.deleteLoan(id);
    }
}
