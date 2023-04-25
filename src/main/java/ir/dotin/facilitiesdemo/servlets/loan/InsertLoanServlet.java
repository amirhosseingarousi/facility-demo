package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.models.GrantCondition;
import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.services.LoanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/loan/insert")
public class InsertLoanServlet extends HttpServlet {
    private LoanService loanService;

    @Override
    public void init() {
        loanService = new LoanService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String loanName = session.getAttribute("loanName").toString();
        String loanRate = session.getAttribute("loanRate").toString();

        List<GrantCondition> conditions = (List<GrantCondition>) session.getAttribute("listCondition");
        session.invalidate();

        Loan loan = new Loan(loanName, Double.parseDouble(loanRate));
        loan.setConditions(conditions);
        loanService.addLoan(loan);

        res.sendRedirect("list");
    }
}
