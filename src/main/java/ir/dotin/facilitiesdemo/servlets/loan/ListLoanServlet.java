package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.services.LoanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loan/list")
public class ListLoanServlet extends HttpServlet {
    private LoanService loanService;

    @Override
    public void init() {
        loanService = new LoanService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Loan> loans = loanService.getAllLoan();
        req.setAttribute("listLoan", loans);
        req.getRequestDispatcher("loan-list.jsp").forward(req, res);
    }
}
