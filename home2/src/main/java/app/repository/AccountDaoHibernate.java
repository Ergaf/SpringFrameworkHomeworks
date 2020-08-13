package app.repository;

import app.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoHibernate implements Dao{
    @Override
    public Account save(Object obj) {
        EmGet.transaction.begin();
        Account account = EmGet.em.merge((Account)obj);
        EmGet.transaction.commit();
        return account;
    }

    @Override
    public boolean delete(Object obj) {
        Account acc = (Account)obj;
        Account account = EmGet.em.find(Account.class, acc.getId());

        EmGet.transaction.begin();
        EmGet.em.remove(account);
        EmGet.transaction.commit();
        return true;
    }

    @Override
    public void deleteAll(List entities) {

    }

    @Override
    public void saveAll(List entities) {

    }

    @Override
    public List<Account> findAll() {
        return EmGet.em.createNativeQuery("SELECT * FROM account", Account.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Account account = EmGet.em.find(Account.class, id);
        EmGet.transaction.begin();
        EmGet.em.remove(account);
        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Account getOne(Long id) {
        return EmGet.em.find(Account.class, id);
    }
}
