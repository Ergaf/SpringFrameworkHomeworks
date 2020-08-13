package app.service;

import app.entities.Customer;
import app.repository.CustomerDaoHibernate;
import app.repository.CustomerDaoInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
//    private CustomerDao customerDao;
    private CustomerDaoHibernate customerDao;

    public List<Customer> getAllCustomer(){
        return customerDao.findAll();
    }

    public Customer getOneCustomer(Long id){
        return customerDao.getOne(id);
    }

    public Customer saveCustomer(Customer customer){
        customer.setId(UUID.randomUUID().hashCode());
        return customerDao.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer){
        customer.setId(UUID.randomUUID().hashCode());
        return customerDao.save(customer);
    }

    public boolean deleteCustomer(Long id){
        customerDao.deleteById(id);
        return true;
    }


}
