package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.dao.GrantConditionDao;
import ir.dotin.facilitiesdemo.models.GrantCondition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loan/grant-condition")
public class ListGrantConditionServlet extends HttpServlet {

    private GrantConditionDao grantConditionDao;

    @Override
    public void init() {
        grantConditionDao = new GrantConditionDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        List<GrantCondition> grantConditions = grantConditionDao.getAllGrantCondition();
//        req.setAttribute("listCondition", grantConditions);
        String loanName = req.getParameter("loanName");
        String loanRate = req.getParameter("loanRate");

        req.setAttribute("name", loanName);
        req.setAttribute("rate", loanRate);
        req.getRequestDispatcher("grant-condition.jsp").forward(req, res);
    }
}
