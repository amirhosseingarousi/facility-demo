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

@WebServlet("/legalcustomer/insert")
public class InsertLegalCustomerServlet extends HttpServlet {

    private LegalCustomerService legalCustomerService;

    @Override
    public void init() {
        legalCustomerService = new LegalCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("companyName").trim();
        LocalDate registerDate = LocalDate.parse(req.getParameter("registerDate"));
        String code = req.getParameter("economicCode").trim();

        LegalCustomer customer = new LegalCustomer(name, registerDate, code);
        customer.setNumber(legalCustomerService.generateCustomerNumber());
        legalCustomerService.addCustomer(customer);
        res.sendRedirect("list");
    }
}
