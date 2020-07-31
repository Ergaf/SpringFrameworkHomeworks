package app.service;

import app.entities.Account;
import app.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> getAllAccounts(){
        return accountDao.findAll();
    }
}
