package app.repository;

import app.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;
import java.util.List;

@Repository
@Transactional
public class AccountDaoHibernate implements Dao{
    @Autowired
    EntityManager em;

    @Override
    public Account save(Object obj) {
//        EmGet.transaction.begin();
        Account account = em.merge((Account)obj);
//        EmGet.transaction.commit();
        return account;
    }

    @Override
    public boolean delete(Object obj) {
        Account acc = (Account)obj;
        Account account = em.find(Account.class, acc.getId());

//        EmGet.transaction.begin();
        em.remove(account);
//        EmGet.transaction.commit();
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
        return em.createNativeQuery("SELECT * FROM account", Account.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Account account = em.find(Account.class, id);
//        EmGet.transaction.begin();
        em.remove(account);
//        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Account getOne(Long id) {
        return em.find(Account.class, id);
    }
}
