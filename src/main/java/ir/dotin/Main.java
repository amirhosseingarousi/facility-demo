package ir.dotin;

import ir.dotin.facilitiesdemo.dao.GrantConditionDao;
import ir.dotin.facilitiesdemo.dao.LoanDao;
import ir.dotin.facilitiesdemo.models.GrantCondition;
import ir.dotin.facilitiesdemo.models.Loan;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        LoanDao loanDao = new LoanDao();
        GrantConditionDao grantConditionDao = new GrantConditionDao();

        Loan loan = new Loan("home", .12);
        Loan loan1 = new Loan("home", .12);

        GrantCondition grantCondition = new GrantCondition("age", 1, 3, 10, 50);
        GrantCondition grantCondition2 = new GrantCondition("balance", 2, 4, 45, 99);
        GrantCondition grantCondition3 = new GrantCondition("deposit", 1, 1, 2, 2);

        List<GrantCondition> conditions = new ArrayList<>();
        List<GrantCondition> conditions1 = new ArrayList<>();
        conditions.add(grantCondition);
        conditions.add(grantCondition2);
        conditions1.add(grantCondition3);

        loan.setConditions(conditions);
        loan1.setConditions(conditions1);
        loanDao.saveLoan(loan);
        loanDao.saveLoan(loan1);

        loanDao.deleteLoan(1);
    }
}
