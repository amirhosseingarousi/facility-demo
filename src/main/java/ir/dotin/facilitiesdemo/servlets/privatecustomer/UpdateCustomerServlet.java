package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/privatecustomer/update")
public class UpdateCustomerServlet extends HttpServlet {

    private PrivateCustomerDao privateCustomerDao;

    @Override
    public void init() {
        privateCustomerDao = new PrivateCustomerDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String fatherName = req.getParameter("fatherName");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));;
        String nationalID = req.getParameter("nationalID");
        String number = req.getParameter("customerNumber");
        System.out.println("number is: " + number);

        PrivateCustomer customer = new PrivateCustomer(id, firstName, lastName, fatherName, dob, nationalID, number);
        privateCustomerDao.updateCustomer(customer);
        res.sendRedirect("list");
    }
}
