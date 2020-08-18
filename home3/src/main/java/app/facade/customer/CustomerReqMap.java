package app.facade.customer;

import app.entities.Customer;
import app.entities.dto.CustomerReq;
import app.entities.dto.CustomerRes;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerReqMap {
    Customer dtoCResToCustomer(CustomerReq customerRes);
    CustomerReq customerToDtoRes(Customer customer);
}
