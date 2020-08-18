package app.repository;

import app.entities.Account;
import app.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoHibernate implements Dao{
    @Autowired
    EntityManager em;

    @Override
    public Customer save(Object obj) {
//        EmGet.transaction.begin();
        Customer customer = em.merge((Customer)obj);
//        EmGet.transaction.commit();
        return customer;
    }

    @Override
    public boolean delete(Object obj) {
        Customer acc = (Customer)obj;
        Customer customer = em.find(Customer.class, acc.getId());

//        EmGet.transaction.begin();
        em.remove(customer);
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
    public List<Customer> findAll() {
        return em.createNativeQuery("SELECT * FROM customer", Customer.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Customer customer = em.find(Customer.class, id);
//        EmGet.transaction.begin();
        em.remove(customer);
//        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Customer getOne(Long id) {
        return em.find(Customer.class, id);
    }

    public Account addAccountInCustomer(Long id, Account account){
        Customer customer = em.find(Customer.class, id);
        customer.getAccounts().add(account);
//        EmGet.transaction.begin();
        em.merge(customer);
//        EmGet.transaction.commit();
        System.out.println(account);
        return account;
    }
}
