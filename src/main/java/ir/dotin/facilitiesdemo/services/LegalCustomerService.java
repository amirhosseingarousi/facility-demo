package ir.dotin.facilitiesdemo.services;

import ir.dotin.facilitiesdemo.dao.LegalCustomerDao;
import ir.dotin.facilitiesdemo.models.LegalCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LegalCustomerService {

    private LegalCustomerDao legalCustomerDao;

    public LegalCustomerService() {
        legalCustomerDao = new LegalCustomerDao();
    }

    public List<LegalCustomer> getAllCustomer() {
        return legalCustomerDao.getAllCustomer();
    }

    public LegalCustomer getCustomerById(int id) {
        return legalCustomerDao.getCustomer(id);
    }

    public void updateCustomer(LegalCustomer customer) {
        legalCustomerDao.updateCustomer(customer);
    }

    public void addCustomer(LegalCustomer customer) {
        legalCustomerDao.saveCustomer(customer);
    }

    public void deleteCustomerById(int id) {
        legalCustomerDao.deleteCustomer(id);
    }

    public List<LegalCustomer> searchCustomerByName(String name) {
        List<LegalCustomer> allCustomer = getAllCustomer();
        List<LegalCustomer> customers = new ArrayList<>();
        for (LegalCustomer customer : allCustomer) {
            if (customer.getCompanyName().contains(name)) {
                customers.add(customer);
            }
        }
        return customers;
    }

    public String generateCustomerNumber() {
        Random random = new Random();
        int num = random.nextInt(999999);
        return String.format("%06d", num);
    }

}
