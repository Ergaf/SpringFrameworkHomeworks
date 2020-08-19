package app.repository.interfaces;

import app.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepInt extends CrudRepository<Account, Long> {
}
