package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.services.LoanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loan/delete")
public class DeleteLoanServlet extends HttpServlet {

    private LoanService loanService;

    @Override
    public void init() throws ServletException {
        loanService = new LoanService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        loanService.deleteLoanById(id);
        req.getSession().setAttribute("success", "Customer removed successfully");
        res.sendRedirect("list");
    }
}
