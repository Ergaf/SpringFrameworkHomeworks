package app.repository;

import app.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoInMemory implements Dao{
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public Object save(Object obj) {
        accounts.add((Account) obj);
        return (Account) obj;
    }

    @Override
    public boolean delete(Object obj) {
        return accounts.remove((Account) obj);
    }

    @Override
    public void deleteAll(List entities) {
        accounts.clear();
    }

    @Override
    public void saveAll(List entities) {
        accounts.containsAll(entities);
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean deleteById(Long id) {
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getId() == id){
                accounts.remove(accounts.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getOne(Long id) {
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getId() == id){
                return accounts.get(i);
            }
        }
        return null;
    }
}
