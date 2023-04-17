package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/privatecustomer/delete")
public class DeleteCustomerServlet extends HttpServlet {

    private PrivateCustomerDao privateCustomerDao;

    @Override
    public void init() {
        privateCustomerDao = new PrivateCustomerDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        privateCustomerDao.deleteCustomer(id);
        res.sendRedirect("list");
    }
}
