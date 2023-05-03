package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.services.LoanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/loan/edit")
public class EditLoanServlet extends HttpServlet {

    private LoanService loanService;

    @Override
    public void init() throws ServletException {
        loanService = new LoanService();
    }
}
