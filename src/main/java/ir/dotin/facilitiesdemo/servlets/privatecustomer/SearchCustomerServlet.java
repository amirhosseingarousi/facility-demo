package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import ir.dotin.facilitiesdemo.services.PrivateCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/privatecustomer/search")
public class SearchCustomerServlet extends HttpServlet {

    private PrivateCustomerService privateCustomerService;

    @Override
    public void init() throws ServletException {
        privateCustomerService = new PrivateCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("firstName").trim();
        List<PrivateCustomer> customers = privateCustomerService.searchCustomerByName(name);
        req.setAttribute("listCustomer", customers);
        req.getRequestDispatcher("private-customer-list.jsp").forward(req, res);

    }
}
