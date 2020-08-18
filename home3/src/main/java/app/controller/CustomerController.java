package app.controller;

import app.entities.Account;
import app.entities.Customer;
import app.entities.dto.CustomerReq;
import app.facade.customer.CustomerReqMap;
import app.facade.customer.CustomerResMap;
import app.service.CustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    CustomerReqMap reqMap;
    CustomerResMap resMap;

    @PostConstruct
    public void init(){
        reqMap = Mappers.getMapper(CustomerReqMap.class);
    }

    @GetMapping("customer")
    List<Customer> getAllCustomer(){
        System.out.println("пришли за списком всех Customer");
        return customerService.getAllCustomer();
    }

    @GetMapping("customer/{id}")
    Customer getOneCustomer(@PathVariable Long id){
        System.out.println("пришли за одним Customer");
        return customerService.getOneCustomer(id);
    }

    @PostMapping("customer")
    Customer saveCustomer(@Valid @RequestBody CustomerReq customerReq){
        System.out.println("пришел на создание новый Customer "+customerReq);
        Customer customer = reqMap.dtoCResToCustomer(customerReq);
        System.out.println("после mapStruct "+customer);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        System.out.println("пришел на изменение новый Customer "+customer);
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("customer/{id}")
    public boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("customer/{id}/account")
    public Account addAccountForCurrentCustomer(@PathVariable Long id, @RequestBody Account account){
        System.out.println("пришел на создание в текущем Customer новый Account "+account);
        return customerService.addAccountInCustomer(id, account);
    }

    @DeleteMapping("customer/{id}/account")
    public long deleteAccountForCurrentCustomer(@PathVariable Long id){
        return id;
    }
}
