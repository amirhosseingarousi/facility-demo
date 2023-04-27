package ir.dotin.facilitiesdemo.servlets.loanfile;

import ir.dotin.facilitiesdemo.dao.LoanDao;
import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.GrantCondition;
import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/loan-file/proceed")
public class LoanFileServlet extends HttpServlet {

    private PrivateCustomerDao privateCustomerDao;
    private LoanDao loanDao;

    @Override
    public void init() {
        privateCustomerDao = new PrivateCustomerDao();
        loanDao = new LoanDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("confirm") != null && req.getParameter("register") == null) {
            System.out.println("confirm called ...");

            String customerNumber = req.getParameter("customerNumber").trim();

            PrivateCustomer customer = privateCustomerDao.getCustomerByNumber(customerNumber);
            List<Loan> loans = loanDao.getAllLoan();

            req.setAttribute("customer", customer);
            req.setAttribute("loanList", loans);
            req.getRequestDispatcher("loan-file.jsp").forward(req, res);
        }

        if (req.getParameter("register") != null) {
            System.out.println("register called ...");
            String customerNumber = req.getParameter("customerNumber").trim();
            PrivateCustomer customer = privateCustomerDao.getCustomerByNumber(customerNumber);
            System.out.println(customer);

            double amount = Double.parseDouble(req.getParameter("amount"));
            int period = Integer.parseInt(req.getParameter("period"));
            int loanId = Integer.parseInt(req.getParameter("loanId"));

            Loan loan = loanDao.getLoan(loanId);
            List<GrantCondition> conditions = loan.getConditions();

            boolean flag = false;

            for (GrantCondition condition : conditions) {
                int conditionMinPeriod = condition.getMinYear();
                int conditionMaxPeriod = condition.getMaxYear();
                double conditionMinAmount = condition.getMinAmount();
                double conditionMaxAmount = condition.getMaxAmount();

                if ((amount >= conditionMinAmount && amount <= conditionMaxAmount) &&
                        (period >= conditionMinPeriod && period <= conditionMaxPeriod)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                List<Loan> loans = customer.getLoans();
                System.out.println("Customer loans: " + loans.size());
                loans.add(loan);
                customer.setLoans(loans);
                privateCustomerDao.updateCustomer(customer);
                res.sendRedirect("loan-file.jsp");
            } else {
                System.out.println("Sorry!");
            }

        }


    }
}
