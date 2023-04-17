package ir.dotin.facilitiesdemo.servlets.privatecustomer;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/privatecustomer/new")
public class NewCustomerServlet extends HttpServlet {

    private PrivateCustomerDao privateCustomerDao;

    @Override
    public void init() {
        privateCustomerDao = new PrivateCustomerDao();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("private-customer-form.jsp")
                .forward(req, res);
    }
}
