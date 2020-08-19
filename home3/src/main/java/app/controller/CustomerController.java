package app.controller;

import app.entities.Account;
import app.entities.Customer;
import app.entities.dto.CustomerReq;
import app.entities.dto.CustomerRes;
import app.facade.customer.CustomerReqMap;
import app.facade.customer.CustomerResMap;
import app.service.CustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
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
        resMap = Mappers.getMapper(CustomerResMap.class);
    }

    @GetMapping("customer")
    List<CustomerRes> getAllCustomer(){
        List<CustomerRes> customersRes = new ArrayList<>();
        for(Customer c: customerService.getAllCustomer()){
            System.out.println(c);
            CustomerRes cR = resMap.customerToDtoRes(c);
            System.out.println(cR);
            customersRes.add(cR);
        }
        return customersRes;
    }

    @GetMapping("customer/{id}")
    CustomerRes getOneCustomer(@PathVariable Long id){
        return resMap.customerToDtoRes(customerService.getOneCustomer(id));
    }

    @PostMapping("customer")
    Customer saveCustomer(@Valid @RequestBody CustomerReq customerReq){
        Customer customer = reqMap.dtoCResToCustomer(customerReq);
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
