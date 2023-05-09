package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import ir.dotin.facilitiesdemo.services.PrivateCustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/privatecustomer/update")
public class UpdateCustomerServlet extends HttpServlet {

    private PrivateCustomerService privateCustomerService;

    @Override
    public void init() {
        privateCustomerService = new PrivateCustomerService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String fatherName = req.getParameter("fatherName");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String nationalID = req.getParameter("nationalID");
        String number = req.getParameter("customerNumber");

        PrivateCustomer customer = new PrivateCustomer(id, firstName, lastName, fatherName, dob, nationalID, number);
        privateCustomerService.updateCustomer(customer);
        req.getSession().setAttribute("success", "Customer updated successfully");
        res.sendRedirect("list");
    }
}
