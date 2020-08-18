package app.controller;

import app.entities.Account;
import app.entities.Customer;
import app.entities.dto.CustomerReq;
import app.facade.CustomerMapper;
import app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper mapper;

    @GetMapping("customer")
    List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("customer/{id}")
    Customer getOneCustomer(@PathVariable Long id){
        return customerService.getOneCustomer(id);
    }

    @PostMapping("customer")
    Customer saveCustomer(@Valid @RequestBody Customer customer){
        System.out.println("пришел Customer "+customer);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("customer/{id}/account")
    public Account addAccountForCurrentCustomer(@PathVariable Long id, @RequestBody Account account){
        return customerService.addAccountInCustomer(id, account);
    }

    @DeleteMapping("customer/{id}/account")
    public long deleteAccountForCurrentCustomer(@PathVariable Long id){
        return id;
    }
}
