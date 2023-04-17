package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

@WebServlet("/privatecustomer/insert")
public class InsertCustomerServlet extends HttpServlet {

    private PrivateCustomerDao privateCustomerDao;

    @Override
    public void init(ServletConfig config) {
        privateCustomerDao = new PrivateCustomerDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String fatherName = req.getParameter("fatherName");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        String nationalID = req.getParameter("nationalID");

        PrivateCustomer customer = new PrivateCustomer(firstName, lastName, fatherName, dob, nationalID);
        customer.setNumber(generateCustomerNumber());
        privateCustomerDao.saveCustomer(customer);
        res.sendRedirect("list");
    }

    public String generateCustomerNumber() {
        Random random = new Random();
        int num = random.nextInt(999999);
        return String.format("%06d", num);
    }
}
