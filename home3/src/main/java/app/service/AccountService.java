package app.service;

import app.entities.Account;
import app.repository.AccountDaoHibernate;
import app.repository.AccountDaoInMemory;
import app.repository.interfaces.AccountRepInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepInt accountDao;

    public List<Account> getAllAccounts(){
        return (List<Account>) accountDao.findAll();
    }

    public boolean replenishAccountBalance(Long id, Double sum){
        Account thisA = accountDao.findById(id).get();
        thisA.setBalance(thisA.getBalance() + sum);
        accountDao.save(thisA);
        return true;
    }

    public boolean takeOffFromAccountBalance(Long id, Double sum){
        Account thisA = accountDao.findById(id).get();
        if(thisA.getBalance() >= sum){
            thisA.setBalance(thisA.getBalance() - sum);
            accountDao.save(thisA);
            return true;
        }
        return false;
    }

    public boolean transferMoneyFromAccountToAccount(Long id1, Long id2, Double sum){
        Account thisA1 = accountDao.findById(id1).get();
        Account thisA2 = accountDao.findById(id2).get();
        if(thisA1.getBalance() >= sum){
            thisA1.setBalance(thisA1.getBalance() - sum);
            thisA2.setBalance(thisA2.getBalance() + sum);
            accountDao.save(thisA1);
            accountDao.save(thisA2);
            return true;
        }
        return false;
    }
}
