package app.service;

import app.entities.Account;
import app.entities.Customer;
import app.repository.interfaces.CustomerRepInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepInt customerDao;

    public Page<Customer> getAllCustomer(int page){
        return customerDao.findAll(PageRequest.of(page, 7));
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
