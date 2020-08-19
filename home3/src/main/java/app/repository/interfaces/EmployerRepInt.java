package app.repository.interfaces;

import app.entities.Employer;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepInt extends CrudRepository<Employer, Long> {
}
