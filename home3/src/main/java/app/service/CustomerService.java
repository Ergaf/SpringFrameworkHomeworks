package app.service;

import app.entities.Account;
import app.entities.Customer;
import app.repository.interfaces.CustomerRepInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepInt customerDao;

    public List<Customer> getAllCustomer(){
        return (List<Customer>) customerDao.findAll();
    }

    public Customer getOneCustomer(Long id){
        Optional<Customer> opt = customerDao.findById(id);
        return opt.get();
    }

    public Customer saveCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer){
        customer.setId(id);
        return customerDao.save(customer);
    }

    public boolean deleteCustomer(Long id){
        customerDao.deleteById(id);
        return true;
    }

    public Account addAccountInCustomer(Long id, Account account){
        Customer customer = getOneCustomer(id);
        customer.getAccounts().add(account);
        customerDao.save(customer);
        return account;
    }

}
