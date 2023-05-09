package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.services.PrivateCustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/privatecustomer/delete")
public class DeleteCustomerServlet extends HttpServlet {

    private PrivateCustomerService privateCustomerService;

    @Override
    public void init() {
        privateCustomerService = new PrivateCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        privateCustomerService.deleteCustomerById(id);
        req.getSession().setAttribute("success", "Customer removed successfully");
        res.sendRedirect("list");

    }
}
