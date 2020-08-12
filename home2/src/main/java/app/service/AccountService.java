package app.service;

import app.entities.Account;
import app.repository.AccountDaoInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDaoInMemory accountDao;

    public List<Account> getAllAccounts(){
        return accountDao.findAll();
    }

    public boolean replenishAccountBalance(Long id, Double sum){
        Account thisA = (Account) accountDao.getOne(id);
        thisA.setBalance(thisA.getBalance() + sum);
        return true;
    }

    public boolean takeOffFromAccountBalance(Long id, Double sum){
        Account thisA = (Account) accountDao.getOne(id);
        if(thisA.getBalance() >= sum){
            thisA.setBalance(thisA.getBalance() - sum);
            return true;
        }
        return false;
    }

    public boolean transferMoneyFromAccountToAccount(Long id1, Long id2, Double sum){
        Account thisA1 = (Account) accountDao.getOne(id1);
        Account thisA2 = (Account) accountDao.getOne(id2);
        if(thisA1.getBalance() >= sum){
            thisA1.setBalance(thisA1.getBalance() - sum);
            thisA2.setBalance(thisA2.getBalance() + sum);
            return true;
        }
        return false;
    }
}
