package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import ir.dotin.facilitiesdemo.services.PrivateCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/privatecustomer/list")
public class ListCustomerServlet extends HttpServlet {
    private PrivateCustomerService privateCustomerService;

    @Override
    public void init() {
        privateCustomerService = new PrivateCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<PrivateCustomer> customers = privateCustomerService.getAllCustomer();
        req.setAttribute("listCustomer", customers);
        req.getRequestDispatcher("private-customer-list.jsp").forward(req, res);

    }
}
