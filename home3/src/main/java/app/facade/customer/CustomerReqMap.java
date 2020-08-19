package app.facade.customer;

import app.entities.Customer;
import app.entities.dto.CustomerReq;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerReqMap {
    Customer dtoCResToCustomer(CustomerReq customerReq);
    CustomerReq customerToDtoRes(Customer customer);
}
