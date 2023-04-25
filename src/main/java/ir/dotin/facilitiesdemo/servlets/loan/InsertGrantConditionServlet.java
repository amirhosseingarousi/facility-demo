package ir.dotin.facilitiesdemo.servlets.loan;

import ir.dotin.facilitiesdemo.dao.GrantConditionDao;
import ir.dotin.facilitiesdemo.dao.LoanDao;
import ir.dotin.facilitiesdemo.models.GrantCondition;
import ir.dotin.facilitiesdemo.models.Loan;
import ir.dotin.facilitiesdemo.services.LoanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/loan/addcondition")
public class InsertGrantConditionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String loanName = req.getParameter("loanName");
        String loanRate = req.getParameter("loanRate");
        String conditionName = req.getParameter("conditionName");
        double minAmount = Double.parseDouble(req.getParameter("minAmount"));
        double maxAmount = Double.parseDouble(req.getParameter("maxAmount"));
        int minPeriod = Integer.parseInt(req.getParameter("minPeriod"));
        int maxPeriod = Integer.parseInt(req.getParameter("maxPeriod"));

        GrantCondition grantCondition = new GrantCondition(conditionName, minPeriod, maxPeriod, minAmount, maxAmount);
        List<GrantCondition> conditions = new ArrayList<>();

        if (req.getSession().getAttribute("listCondition") == null) {
            HttpSession session = req.getSession();
            conditions.add(grantCondition);
            session.setAttribute("listCondition", conditions);
            session.setAttribute("loanName", loanName);
            session.setAttribute("loanRate", loanRate);
        } else {
            HttpSession session = req.getSession();
            conditions = (List<GrantCondition>) session.getAttribute("listCondition");
            conditions.add(grantCondition);
            session.setAttribute("listCondition", conditions);
        }

        res.sendRedirect("grant-condition?loanName=" + loanName + "&loanRate=" + loanRate);
    }

}
