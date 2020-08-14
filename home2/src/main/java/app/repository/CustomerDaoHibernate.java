package app.repository;

import app.entities.Account;
import app.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoHibernate implements Dao{
    @Override
    public Customer save(Object obj) {
        EmGet.transaction.begin();
        Customer customer = EmGet.em.merge((Customer)obj);
        EmGet.transaction.commit();
        return customer;
    }

    @Override
    public boolean delete(Object obj) {
        Customer acc = (Customer)obj;
        Customer customer = EmGet.em.find(Customer.class, acc.getId());

        EmGet.transaction.begin();
        EmGet.em.remove(customer);
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
    public List<Customer> findAll() {
        return EmGet.em.createNativeQuery("SELECT * FROM CUSTOMER", Customer.class).getResultList();
    }

    @Override
    public boolean deleteById(Long id) {
        Customer customer = EmGet.em.find(Customer.class, id);
        EmGet.transaction.begin();
        EmGet.em.remove(customer);
        EmGet.transaction.commit();
        return true;
    }

    @Override
    public Customer getOne(Long id) {
        return EmGet.em.find(Customer.class, id);
    }

    public Account addAccountInCustomer(Long id, Account account){
        Customer customer = EmGet.em.find(Customer.class, id);
        customer.getAccounts().add(account);
        EmGet.transaction.begin();
        EmGet.em.merge(customer);
        EmGet.transaction.commit();
        System.out.println(account);
        return account;
    }
}
