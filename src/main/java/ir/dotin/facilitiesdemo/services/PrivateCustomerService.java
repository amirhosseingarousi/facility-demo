package ir.dotin.facilitiesdemo.services;

import ir.dotin.facilitiesdemo.repository.PrivateCustomerDao;
import ir.dotin.facilitiesdemo.models.PrivateCustomer;

import java.util.ArrayList;
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

    public PrivateCustomer getCustomerByNumber(String number) {
        return privateCustomerDao.getCustomerByNumber(number);
    }

    public List<PrivateCustomer> searchCustomerByFirstName(String name) {
        return privateCustomerDao.searchCustomerByName(name);
    }

    public void addCustomer(PrivateCustomer customer) {
        privateCustomerDao.saveCustomer(customer);
    }

    public void deleteCustomerById(int id) {
        privateCustomerDao.deleteCustomer(id);
    }

}
