package ir.dotin.facilitiesdemo.servlets.legalcustomer;

import ir.dotin.facilitiesdemo.services.LegalCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/legalcustomer/delete")
public class DeleteLegalCustomerServlet extends HttpServlet {

    private LegalCustomerService legalCustomerService;

    @Override
    public void init() {
        legalCustomerService = new LegalCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        legalCustomerService.deleteCustomerById(id);
        res.sendRedirect("list");
    }
}
