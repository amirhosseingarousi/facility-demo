package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.dao.LoanDao;
import ir.dotin.facilitiesdemo.models.Loan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loan/list")
public class ListLoanServlet extends HttpServlet {

    private LoanDao loanDao;

    @Override
    public void init() {
        loanDao = new LoanDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Loan> loans = loanDao.getAllLoan();
        req.setAttribute("listLoan", loans);
        req.getRequestDispatcher("loan-list.jsp").forward(req, res);
    }
}
