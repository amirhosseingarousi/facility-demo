package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.repository.GrantConditionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loan/grant-condition")
public class ListGrantConditionServlet extends HttpServlet {

    private GrantConditionDao grantConditionDao;

    @Override
    public void init() {
        grantConditionDao = new GrantConditionDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String loanName = req.getParameter("loanName");
        String loanRate = req.getParameter("loanRate");

        req.setAttribute("name", loanName);
        req.setAttribute("rate", loanRate);
        req.getRequestDispatcher("grant-condition.jsp").forward(req, res);
    }
}
