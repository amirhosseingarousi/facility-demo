package ir.dotin.facilitiesdemo.servlets.loanfile;

import ir.dotin.facilitiesdemo.models.GrantCondition;
import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import ir.dotin.facilitiesdemo.services.LoanService;
import ir.dotin.facilitiesdemo.services.PrivateCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loan-file/proceed")
public class LoanFileServlet extends HttpServlet {

    private LoanService loanService;
    private PrivateCustomerService privateCustomerService;

    @Override
    public void init() {
        loanService = new LoanService();
        privateCustomerService = new PrivateCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("confirm") != null && req.getParameter("register") == null) {
            System.out.println("confirm called ...");

            String customerNumber = req.getParameter("customerNumber").trim();

            PrivateCustomer customer = privateCustomerService.getCustomerByNumber(customerNumber);
//            PrivateCustomer customer = loanFileService.getCustomerByNumber(customerNumber);
            List<Loan> loans = loanService.getAllLoan();

            req.setAttribute("customer", customer);
            req.setAttribute("loanList", loans);
            req.getRequestDispatcher("loan-file.jsp").forward(req, res);
        }

        if (req.getParameter("register") != null) {
            System.out.println("register called ...");
            String customerNumber = req.getParameter("customerNumber").trim();
            PrivateCustomer customer = privateCustomerService.getCustomerByNumber(customerNumber);
            System.out.println(customer);

            double amount = Double.parseDouble(req.getParameter("amount"));
            int period = Integer.parseInt(req.getParameter("period"));
            int loanId = Integer.parseInt(req.getParameter("loanId"));

            Loan loan = loanService.getLoanById(loanId);
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
                privateCustomerService.updateCustomer(customer);
                req.getSession().setAttribute("success", "Customer register loan successfully");
                res.sendRedirect("loan-file.jsp");
            } else {
                req.getSession().setAttribute("fail", "Customer request reject");
                res.sendRedirect("loan-file.jsp");
            }

        }
    }
}
