package ir.dotin.facilitiesdemo.services;

import ir.dotin.facilitiesdemo.dao.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;
import org.hibernate.JDBCException;

import java.util.List;

public class PrivateCustomerService {

    private PrivateCustomerDao privateCustomerDao;

    public PrivateCustomerService() {
        this.privateCustomerDao = new PrivateCustomerDao();
    }

    public List<PrivateCustomer> getAllCustomer() {
        return privateCustomerDao.getAllCustomer();
    }

    public PrivateCustomer getCustomerById(int id) {
        return privateCustomerDao.getCustomer(id);
    }

    public void updateCustomer(PrivateCustomer customer) {
        privateCustomerDao.updateCustomer(customer);
    }

    public void addCustomer(PrivateCustomer customer) {
        privateCustomerDao.saveCustomer(customer);
    }

    public void deleteCustomerById(int id) {
        privateCustomerDao.deleteCustomer(id);
    }

}
