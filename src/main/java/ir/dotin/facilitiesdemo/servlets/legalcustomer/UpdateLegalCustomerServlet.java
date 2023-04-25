package ir.dotin.facilitiesdemo.servlets.legalcustomer;

import ir.dotin.facilitiesdemo.models.LegalCustomer;
import ir.dotin.facilitiesdemo.services.LegalCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/legalcustomer/update")
public class UpdateLegalCustomerServlet extends HttpServlet {

    private LegalCustomerService legalCustomerService;

    @Override
    public void init() {
        legalCustomerService = new LegalCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("companyName");
        LocalDate registerDate = LocalDate.parse(req.getParameter("registerDate"));
        String code = req.getParameter("economicCode");
        String number = req.getParameter("customerNumber");

        LegalCustomer customer = new LegalCustomer(id, name, registerDate, code, number);
        legalCustomerService.updateCustomer(customer);
        res.sendRedirect("list");
    }
}
