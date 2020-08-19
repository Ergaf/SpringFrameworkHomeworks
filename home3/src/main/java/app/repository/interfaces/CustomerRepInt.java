package app.repository.interfaces;

import app.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepInt extends CrudRepository<Customer, Long> {

}
