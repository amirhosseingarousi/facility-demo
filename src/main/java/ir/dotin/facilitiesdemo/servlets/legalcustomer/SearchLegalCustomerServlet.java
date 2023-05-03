package ir.dotin.facilitiesdemo.servlets.legalcustomer;

import ir.dotin.facilitiesdemo.models.LegalCustomer;
import ir.dotin.facilitiesdemo.services.LegalCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/legalcustomer/search")
public class SearchLegalCustomerServlet extends HttpServlet {

    private LegalCustomerService legalCustomerService;

    @Override
    public void init() throws ServletException {
        legalCustomerService = new LegalCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        List<LegalCustomer> customers = legalCustomerService.searchCustomerByName(name);
        req.setAttribute("listCustomer", customers);
        req.getRequestDispatcher("legal-customer-list.jsp").forward(req, res);
    }
}
