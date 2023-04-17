package ir.dotin.facilitiesdemo.servlets.loanfile;

import ir.dotin.facilitiesdemo.dao.LoanDao;
import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String customerNumber = req.getParameter("customerNumber").trim();

        PrivateCustomer customer = privateCustomerDao.getCustomerByNumber(customerNumber);
        List<Loan> loans = loanDao.getAllLoan();

        req.setAttribute("customer", customer);
        req.setAttribute("loanList", loans);
        req.getRequestDispatcher("loan-file.jsp").forward(req, res);
    }
}
