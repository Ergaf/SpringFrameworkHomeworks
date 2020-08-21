package app.repository.interfaces;

import app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepInt extends JpaRepository<Customer, Long> {
}
