package app.facade.customer;

import app.entities.Customer;
import app.entities.dto.CustomerRes;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerResMap {
    Customer dtoCResToCustomer(CustomerRes customerRes);
    CustomerRes customerToDtoRes(Customer customer);
}
